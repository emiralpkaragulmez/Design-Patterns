package dev.Emir.RecipeManager.CommandModule;

import dev.Emir.RecipeFiles.Recipe;

public class RemoveTagCommand implements Command{
    Recipe newRecipe = null;
    String tag = null;
    Recipe oldRecipe = null;


    public RemoveTagCommand(Recipe recipe, String ingredient) {
        this.newRecipe = recipe;
        this.tag = ingredient;
        oldRecipe = recipe;
    }

//    public void execute() {
//        newRecipe.
//    }

    @Override
    public void execute() {
        newRecipe = newRecipe.removeDecorator(tag,newRecipe);
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

    public void updateTag(String tag){
        this.tag = tag;
    }

    public Recipe getRecipe(){
        return newRecipe;
    }
}


