package dev.Emir.RecipeManager.CommandModule;

import dev.Emir.RecipeFiles.Recipe;

public class RemoveCategoryCommand implements Command {
    Recipe newRecipe = null;
    String category = null;
    Recipe oldRecipe = null;


    public RemoveCategoryCommand(Recipe recipe, String ingredient) {
        this.newRecipe = recipe;
        this.category = ingredient;
        oldRecipe = recipe;
    }

//    public void execute() {
//        newRecipe.
//    }

    @Override
    public void execute() {
        newRecipe = newRecipe.removeDecorator(category,newRecipe);
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

    public void updateCategory(String category){
        this.category = category;
    }

    public Recipe getRecipe(){
        return newRecipe;
    }
}
