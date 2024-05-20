package dev.Emir.RecipeManager.CommandModule;

import dev.Emir.RecipeFiles.Recipe;

public interface Command {
    void execute();

    void undo();
}
