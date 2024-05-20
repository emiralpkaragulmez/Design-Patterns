package dev.Emir;

import dev.Emir.RecipeFiles.Recipe;
import dev.Emir.RecipeManager.CommandModule.CommandModuleManager;
import dev.Emir.RecipeManager.RecipeCreateModule;
import dev.Emir.RecipeManager.RecipeRateModule;
import dev.Emir.RecipeSearch.SearchManager;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class RecipeSystemManager {
    public static ArrayList<Recipe> RecipeInventory = new ArrayList<>();
    public static void mainOptions(){

        System.out.println("\n -> Entered Main Menu");

        boolean repeat = false;
        while(true){
            Scanner sc = new Scanner(System.in);
            String decision = "";
            if(!repeat) {
                decision = "";
                System.out.println("1. Recipe Creation Module"
                        + "\n2. Recipe Modification Module"
                        + "\n3. Recipe Search Module"
                        + "\n4. Recipe Rate Module");
            }
            System.out.print("Please, enter a number to get into the desired module --> ");
            decision = sc.next();

            try{
                Integer.parseInt(decision);
            }catch (NumberFormatException e){
                System.out.println("The input is not expected. Please try again.");
                repeat = true;
                continue;
            }

            //*********************************************
            /* Those Modules hasn't been implemented yet. */






            if(decision.equals("1")){
                //Enters recipe "CREATION" module.
                System.out.println("\n -> Entered recipe creation module\n");
                RecipeCreateModule recipeCreateModule = new RecipeCreateModule();
                Recipe recipe = recipeCreateModule.completeCreatingRecipe();
                RecipeInventory.add(recipe);
            }





            if(decision.equals("2")){
                //Enters recipe "MODIFICATION" module.
                System.out.println("\n -> Entered modification creation module\n");
                CommandModuleManager.mainCommandScreen();
            }





            if(decision.equals("3")){
                //Enters recipe "SEARCH" module.
                System.out.println("\n -> Entered recipe search module\n");
                SearchManager searchManager = new SearchManager();
                searchManager.makeSearch();
            }





            if(decision.equals("4")){
                //Enters recipe "RATE" module.
                System.out.println("\n -> Entered recipe rate module\n");

                outerloop:
                while(true){
                    if(RecipeInventory.size() == 0){
                        System.out.println("There is no recipe to rate. Please, go back to the main menu.");
                        break;
                    }
                    int i;
                    System.out.println (">Please, type '1' to list the recipes or \n'2' for rate the recipe entering its number \n" +
                            " or print '3' to go to Main Menu");
                    String input = sc.next();
                    if(input.equals("1")){
                        printRecipes(RecipeInventory);
                    }
                    else if(input.equals("2")){
                        System.out.println ("You can list the recipes to learn its number from previous menu." +
                                "\nYou can go to previous menu by typing 'exit' or you can enter a number");
                        String in = sc.next();
                        if(in.toLowerCase().equals("Exit".toLowerCase())){
                            continue;
                        }

                        try{
                            i = Integer.parseInt(in);
                        }catch (NumberFormatException e){
                            System.out.println("Wrong input, please try again");
                            continue;
                        }

                        System.out.println("Please, enter your rate between [1,5] -> ");
                        String rate = sc.next();

                        int rate1;
                        while(true) {
                            try {
                                rate1 = Integer.parseInt(rate);
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Wrong input, please try again");
                                continue outerloop;
                            }
                        }

                        if(rate1>5 || rate1<1){
                            System.out.println("Invalid rate. Please, try again.");
                            continue;
                        }

                        if(i>RecipeInventory.size()){
                            System.out.println("Invalid recipe number. Please, try again.");
                            continue;
                        }

                        RecipeRateModule recipeRateModule = new RecipeRateModule();
                        Recipe newRecipe = RecipeInventory.get(i);
                        newRecipe = recipeRateModule.rateRecipe(newRecipe, rate1);
                        RecipeInventory.set(i, newRecipe);

                    } else if (input.equals("3")) {
                        mainOptions();
                    }

                }

            }
            /* *************************** */
            // *****************************************
            repeat = false;
        }
    }






    public static void printRecipes(ArrayList<Recipe> recipes){
        if(recipes.size() == 0) {
            System.out.println("There is no saved recipe.");
            return;
        }
        for(int i=0 ; i < recipes.size() ; i++){
            Recipe recipe = recipes.get(i);
            System.out.println("**** Recipe : " + (i) + " ****");
            System.out.println(recipe.getName());
            System.out.println("----------------");
            System.out.println(recipe.getServingSize());
            System.out.println("----------------");
            System.out.println(recipe.getCookingInstructions());
            System.out.println("----------------");
            System.out.println(recipe.getCategories());
            System.out.println("----------------");
            System.out.println(recipe.getIngredients());
            System.out.println("----------------");
            System.out.println(recipe.getTags());
            System.out.println("----------------");
            System.out.println(recipe.getRating());
            System.out.println("----------------");
            System.out.println(recipe.getTotalRatings());
            System.out.println("**** End of Recipe : " + (i) + " ****");
        }
    }

}