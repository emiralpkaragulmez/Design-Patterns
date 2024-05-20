package dev.Emir.RecipeManager.CommandModule;

import dev.Emir.RecipeFiles.Recipe;

public class RemoveIngredientCommand implements Command {
    Recipe newRecipe = null;
    String ingredient = null;
    Recipe oldRecipe = null;


    public RemoveIngredientCommand(Recipe recipe, String ingredient) {
        this.newRecipe = recipe;
        this.ingredient = ingredient;
        oldRecipe = recipe;
    }

//    public void execute() {
//        newRecipe.
//    }

    @Override
    public void execute() {
        newRecipe = newRecipe.removeDecorator(ingredient,newRecipe);
    }

    public void undo() {
        Recipe before = Recipe.beforeDecorator;
        if (before != null) {
            before.setRecipe(Recipe.removedDecorator);
            Recipe.removedDecorator.setRecipe(Recipe.afterDecorator);
        }else{
            oldRecipe.setRecipe(Recipe.afterDecorator);
            newRecipe = oldRecipe;
        }

    }

    public void updateIngredient(String ingredient){
        this.ingredient = ingredient;
    }

    public Recipe getRecipe(){
        return newRecipe;
    }
}
