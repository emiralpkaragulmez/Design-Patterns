package dev.Emir.RecipeSearch;

import dev.Emir.RecipeFiles.Recipe;
import dev.Emir.RecipeSystemManager;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchManager {
    SearchBehaviour searchBehaviour;

    public SearchManager() {
    }

    public void makeSearch(){
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println ("\nWhich way would you like to search in recipes?" +
                    "\nType '1' for Search by tags " +
                    "\nType '2' Search by categories " +
                    "\nType '3' Search by ingredients" +
                    "\nType '4' To exit main menu.\n");
            System.out.print("Please, enter a number that indication desired method --> ");
            String decision = sc.next();

            switch (decision) {
                case ("1"):
                    setSearchBehaviour(new SearchByTag());
                    printRecipes(searchBehaviour.Search(RecipeSystemManager.RecipeInventory));
                    break;
                case ("2"):
                    setSearchBehaviour(new SearchByCategories());
                    printRecipes(searchBehaviour.Search(RecipeSystemManager.RecipeInventory));
                    break;
                case ("3"):
                    setSearchBehaviour(new SearchByIngredients());
                    printRecipes(searchBehaviour.Search(RecipeSystemManager.RecipeInventory));
                    break;
                case ("4"):
                    RecipeSystemManager.mainOptions();
                    break;
                default :
                    System.out.println("Sorry, the input seems like invalid. Please, try again.");
                    break;
            }
        }

    }
    public void setSearchBehaviour(SearchBehaviour searchBehaviour){
        this.searchBehaviour = searchBehaviour;
    }

    public void printRecipes(ArrayList<Recipe> recipes){
        if(recipes.size() == 0) return;
        for(int i=0 ; i < recipes.size() ; i++){
            Recipe recipe = recipes.get(i);
            System.out.println("**** Recipe : " + (i+1) + " ****");
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

        }
    }
}