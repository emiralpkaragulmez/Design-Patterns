package dev.Emir;

import dev.Emir.RecipeFiles.Categories.CtgBreakfast;
import dev.Emir.RecipeFiles.Categories.CtgDinner;
import dev.Emir.RecipeFiles.Categories.CtgLunch;
import dev.Emir.RecipeFiles.ClassicRecipe;
import dev.Emir.RecipeFiles.Ingredients.IngChicken;
import dev.Emir.RecipeFiles.Recipe;
import dev.Emir.RecipeManager.CommandModule.AddIngredientCommand;
import dev.Emir.RecipeManager.CommandModule.RemoveIngredientCommand;
import dev.Emir.*;


public class Main {
    public static void main(String[] args) {

        RecipeSystemManager.mainOptions();



        ////        RecipeCreateModule recipeCreateModule = new RecipeCreateModule();
////        Recipe recipe = recipeCreateModule.completeCreatingRecipe();
////        recipe = new OneRate(recipe);
////        System.out.println(recipe.getCategories());
////        System.out.println(recipe.getIngredients());
////        System.out.println(recipe.getTags());
////        System.out.println(recipe.getRatings());
////        System.out.println(recipe.getName());
////        System.out.println(recipe.getCookingInstructions());
////        System.out.println(recipe.getRatings());
////        System.out.println(recipe.getServingSize());
////        System.out.println(recipe.getRating());
////        System.out.println(recipe.getTotalRatings());
//        Recipe recipe = new ClassicRecipe();
//        recipe = new CtgDinner(recipe);
//        recipe = new CtgLunch(recipe);
//        recipe = new CtgBreakfast(recipe);
////        System.out.println(recipe.getCategories());
////        recipe = new IngBrisket(recipe);
////        System.out.println(recipe.getIngredients());
//
//
////        AddIngredient addIngredient = new AddIngredient();
////        addIngredient.setChanges(recipe, "Brisket");
////        recipe = addIngredient.execute();
////        recipe.getIngredients();
////









//        System.out.println(recipe.getIngredients());
//        recipe = new IngChicken(recipe);
//        AddIngredientCommand addIngredientCommand = new AddIngredientCommand(recipe, "Brisket");
//        addIngredientCommand.execute();
//        recipe = addIngredientCommand.getRecipe();
//        addIngredientCommand.updateIngredient("Chicken");
//        addIngredientCommand.execute();
//        recipe = addIngredientCommand.getRecipe();
//        System.out.println(recipe.getIngredients());
//
//
//
//        RemoveIngredientCommand removeIngredientCommand = new RemoveIngredientCommand(recipe, "Chicken");
//        removeIngredientCommand.execute();
//        recipe = removeIngredientCommand.getRecipe();
//        System.out.println(recipe.getIngredients());
//        removeIngredientCommand.undo();
//        recipe = removeIngredientCommand.getRecipe();
//        System.out.println(recipe.getIngredients());
//

    }
}