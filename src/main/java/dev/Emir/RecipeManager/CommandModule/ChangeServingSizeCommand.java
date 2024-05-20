package dev.Emir.RecipeManager.CommandModule;

import dev.Emir.RecipeFiles.Recipe;

public class ChangeServingSizeCommand implements Command{
    Recipe recipe;
    int servingSize;
    int oldServingSize;

    public ChangeServingSizeCommand(Recipe recipe, int servingSize) {
        this.recipe = recipe;
        this.servingSize = servingSize;
        oldServingSize = recipe.getServingSize();
    }


    @Override
    public void execute() {
        recipe.setServingSize(servingSize);

    }

    @Override
    public void undo() {
        recipe.setServingSize(oldServingSize);
    }

    public void updateServingSize(int servingSize){
        this.servingSize = servingSize;
    }
}
