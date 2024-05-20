package dev.Emir.RecipeManager.CommandModule;

import dev.Emir.RecipeFiles.ClassicRecipe;
import dev.Emir.RecipeFiles.Recipe;
import dev.Emir.RecipeSystemManager;

import java.util.ArrayList;
import java.util.Scanner;

public class CommandModuleManager {

    public static void mainCommandScreen(){


        while(true){

            boolean chosen = false;
            Scanner sc = new Scanner(System.in);
            String in = "";
            Recipe recipe = null;
            System.out.println ("To list the recipes --> 'list'" +
                    "\nTo exit the main menu --> 'exit'" +
                    "\nor you can enter the number of the recipe that you'd like to modify. ");;
            System.out.print("-->>");
            in = sc.next();

            if(in.toLowerCase().equals("list")){
                RecipeSystemManager.printRecipes(RecipeSystemManager.RecipeInventory);
                continue;
            } else if (in.toLowerCase().equals("exit")) {
                RecipeSystemManager.mainOptions();
            }
            else{
                try{
                    Integer.parseInt(in);
                }catch (NumberFormatException e){
                    System.out.println("The input is not expected. Please try again.");
                    continue;
                }

                if(Integer.parseInt(in) < 0 || Integer.parseInt(in) > RecipeSystemManager.RecipeInventory.size()-1){
                    System.out.println("The input is out of range, please try again.");
                    continue;
                }
                else {
                    recipe = RecipeSystemManager.RecipeInventory.get(Integer.parseInt(in));
                    System.out.println(recipe);
                }
            }
            while(true) {

                System.out.println("Which modification would you like to do?");
                System.out.println("Exit for go back to main menu.");
                System.out.println("1. Modify Recipe Name");
                System.out.println("2. Add Ingredient");
                System.out.println("3. Remove Ingredient");
                System.out.println("4. Add Tags");
                System.out.println("5. Remove Tags");
                System.out.println("6. Add categories");
                System.out.println("7. Remove categories");
                System.out.println("8. Change serving size");
                System.out.println("9. Change Instructions");

                System.out.print("Input --> ");
                String input = sc.next();

                if(input.toLowerCase().equals("exit")) mainCommandScreen();

                if (input.equals("1")) {
                    String str = "";
                    while(true){
                        System.out.println("Current name: " + recipe.getName());
                        System.out.println("Please enter the new name or type 'save' to save the changes.");
                        System.out.print("New name --> ");
                        str = sc.nextLine();
                        ChangeNameCommand changeNameCommand = new ChangeNameCommand(recipe,str);
                        changeNameCommand.execute();
                        System.out.println("New name --> recipe.getName()" + " Would you like to save? '1' --> save : '0' --> undo");
                        str = sc.next();
                        if(str.equals("1")){
                            RecipeSystemManager.RecipeInventory.set(Integer.parseInt(in),recipe);
                            break;
                        } else if (str.equals("0")){
                            changeNameCommand.undo();
                            break;
                        }

                    }
                }


                if(input.equals("2")){
                    String str = "";
                    while(true){
                        System.out.println("Current Ingredients: " + recipe.getIngredients());
                        System.out.println("Please enter the new ingredient or type 'save' to save the changes.");
                        System.out.println(new ClassicRecipe().getIngredientsList());
                        System.out.print("New ingredient --> ");
                        str = sc.next();
                        AddIngredientCommand addIngredientCommand = new AddIngredientCommand(recipe,str);
                        addIngredientCommand.execute();
                        recipe = addIngredientCommand.getRecipe();
                        System.out.println("New Ingredients --> " + " " + recipe.getIngredients() + "Would you like to save? '1' --> save : '0' --> undo");
                        str = sc.next();
                        if(str.equals("1")){
                            RecipeSystemManager.RecipeInventory.set(Integer.parseInt(in),recipe);
                            break;
                        } else if (str.equals("0")){
                            addIngredientCommand.undo();
                            recipe = addIngredientCommand.getRecipe();
                            RecipeSystemManager.RecipeInventory.set(Integer.parseInt(in),recipe);
                            break;
                        }

                    }
                }

                if(input.equals("3")){
                    String str = "";
                    while(true){
                        System.out.println("Current Ingredients: " + recipe.getIngredients());
                        System.out.println("Please enter the ingredient that you'd like to remove or type 'save' to save the changes.");
                        System.out.println(new ClassicRecipe().getIngredientsList());
                        System.out.print("Ingredient --> ");
                        str = sc.next();
                        RemoveIngredientCommand removeIngredientCommand = new RemoveIngredientCommand(recipe,str);
                        removeIngredientCommand.execute();
                        recipe = removeIngredientCommand.getRecipe();
                        System.out.println("New Ingredients --> " + " " + recipe.getIngredients() + "Would you like to save? '1' --> save : '0' --> undo");
                        str = sc.next();
                        if(str.equals("1")){
                            RecipeSystemManager.RecipeInventory.set(Integer.parseInt(in),recipe);
                            break;
                        } else if (str.equals("0")){
                            removeIngredientCommand.undo();
                            recipe = removeIngredientCommand.getRecipe();
                            RecipeSystemManager.RecipeInventory.set(Integer.parseInt(in),recipe);

                            break;
                        }

                    }
                }

                if(input.equals("4")){
                    String str = "";
                    while(true){
                        System.out.println("Current Tags: " + recipe.getTags());
                        System.out.println("Please enter the new tag or type 'save' to save the changes.");
                        System.out.println(new ClassicRecipe().getTagsList());
                        System.out.print("New tag --> ");
                        str = sc.next();
                        AddTagsCommand addTagsCommand = new AddTagsCommand(recipe,str);
                        addTagsCommand.execute();
                        recipe = addTagsCommand.getRecipe();
                        System.out.println("New Tags --> " + " " + recipe.getTags() + "Would you like to save? '1' --> save : '0' --> undo");
                        str = sc.next();
                        if(str.equals("1")){
                            RecipeSystemManager.RecipeInventory.set(Integer.parseInt(in),recipe);
                            break;
                        } else if (str.equals("0")){

                            addTagsCommand.undo();
                            recipe = addTagsCommand.getRecipe();
                            RecipeSystemManager.RecipeInventory.set(Integer.parseInt(in),recipe);
                            break;
                        }

                    }
                }
                if(input.equals("5")){
                    String str = "";
                    while(true){
                        System.out.println("Current Tags: " + recipe.getTags());
                        System.out.println("Please enter the tag that you'd like to remove or type 'save' to save the changes.");
                        System.out.println(new ClassicRecipe().getTagsList());
                        System.out.print("Tag --> ");
                        str = sc.next();
                        RemoveTagCommand removeTagCommand = new RemoveTagCommand(recipe,str);
                        removeTagCommand.execute();
                        recipe = removeTagCommand.getRecipe();
                        System.out.println("New Tags --> " + " " + recipe.getTags() + "Would you like to save? '1' --> save : '0' --> undo");
                        str = sc.next();
                        if(str.equals("1")){
                            RecipeSystemManager.RecipeInventory.set(Integer.parseInt(in),recipe);
                            break;
                        } else if (str.equals("0")){
                            removeTagCommand.undo();
                            recipe = removeTagCommand.getRecipe();
                            RecipeSystemManager.RecipeInventory.set(Integer.parseInt(in),recipe);
                            break;
                        }

                    }
                }
                if(input.equals("6")){
                    String str = "";
                    while(true){
                        System.out.println("Current Categories: " + recipe.getCategories());
                        System.out.println("Please enter the new category or type 'save' to save the changes.");
                        System.out.println(new ClassicRecipe().getCategoryList());
                        System.out.print("New category --> ");
                        str = sc.next();
                        AddCategoryCommand addCategoryCommand = new AddCategoryCommand(recipe,str);
                        addCategoryCommand.execute();
                        recipe = addCategoryCommand.getRecipe();
                        System.out.println("New Categories --> " + " " + recipe.getCategories() + "Would you like to save? '1' --> save : '0' --> undo");
                        str = sc.next();
                        if(str.equals("1")){
                            RecipeSystemManager.RecipeInventory.set(Integer.parseInt(in),recipe);
                            break;
                        } else if (str.equals("0")){
                            addCategoryCommand.undo();
                            recipe = addCategoryCommand.getRecipe();
                            RecipeSystemManager.RecipeInventory.set(Integer.parseInt(in),recipe);
                            break;
                        }
                    }
                }

                if(input.equals("7")){
                    String str = "";
                    while(true){
                        System.out.println("Current Categories: " + recipe.getCategories());
                        System.out.println("Please enter the category that you'd like to remove or type 'save' to save the changes.");
                        System.out.println(new ClassicRecipe().getCategoryList());
                        System.out.print("Category --> ");
                        str = sc.next();
                        RemoveCategoryCommand removeCategoryCommand = new RemoveCategoryCommand(recipe,str);
                        removeCategoryCommand.execute();
                        recipe = removeCategoryCommand.getRecipe();
                        System.out.println("New Categories --> " + " " + recipe.getCategories() + "Would you like to save? '1' --> save : '0' --> undo");
                        str = sc.next();
                        if(str.equals("1")){
                            RecipeSystemManager.RecipeInventory.set(Integer.parseInt(in),recipe);
                            break;
                        } else if (str.equals("0")){
                            removeCategoryCommand.undo();
                            recipe = removeCategoryCommand.getRecipe();
                            RecipeSystemManager.RecipeInventory.set(Integer.parseInt(in),recipe);
                            break;
                        }
                    }
                }

                if(input.equals("8")){
                    String str = "";
                    while(true){
                        System.out.println("Current Serving Size: " + recipe.getServingSize());
                        System.out.println("Please enter the new serving size or type 'save' to save the changes.");
                        System.out.print("New serving size --> ");
                        str = sc.next();
                        ChangeServingSizeCommand changeServingSizeCommand = new ChangeServingSizeCommand(recipe,Integer.parseInt(str));
                        changeServingSizeCommand.execute();
                        System.out.println("New Serving Size --> " + " " + recipe.getServingSize() + "Would you like to save? '1' --> save : '0' --> undo");
                        str = sc.next();
                        if(str.equals("1")){
                            RecipeSystemManager.RecipeInventory.set(Integer.parseInt(in),recipe);
                            break;
                        } else if (str.equals("0")){
                            changeServingSizeCommand.undo();

                            break;
                        }
                    }
                }
                if (input.equals("9")) {
                    System.out.println(recipe);
                    String str = "";
                    while(true){
                        System.out.println("Current Instructions: " + recipe.getCookingInstructions());
                        System.out.println("Please enter the new instructions or type 'save' to save the changes.");
                        System.out.print("New instructions --> ");
                        str = sc.nextLine();
                        ChangeInstructionCommand changeInstructionCommand = new ChangeInstructionCommand(recipe,str);
                        changeInstructionCommand.execute();
                        System.out.println("New Instructions --> " + " " + recipe.getCookingInstructions() + "Would you like to save? '1' --> save : '0' --> undo");
                        str = sc.next();
                        if(str.equals("1")){
                            RecipeSystemManager.RecipeInventory.set(Integer.parseInt(in),recipe);
                            break;
                        } else if (str.equals("0")){
                            changeInstructionCommand.undo();

                            break;
                        }
                    }
                }
            }

        }


    }
}
