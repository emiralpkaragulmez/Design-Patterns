package dev.Emir.RecipeManager.CommandModule;

import dev.Emir.RecipeFiles.Recipe;

public class ChangeNameCommand implements Command{
    Recipe recipe;
    String name;
    String oldName;

    public ChangeNameCommand(Recipe recipe, String name) {
        this.recipe = recipe;
        this.name = name;
        oldName = recipe.getName();
    }


    @Override
    public void execute() {
        recipe.setName(name);

    }

    @Override
    public void undo() {
        recipe.setName(oldName);
    }

    public void updateName(String name){
        this.name = name;
    }
}
