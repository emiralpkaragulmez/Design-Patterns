package dev.Emir.RecipeManager.CommandModule;

import dev.Emir.RecipeFiles.Recipe;

public class ChangeInstructionCommand implements Command{
    Recipe recipe;
    String Instruction;
    String oldInstruction;

    public ChangeInstructionCommand(Recipe recipe, String Instruction) {
        this.recipe = recipe;
        this.Instruction = Instruction;
        oldInstruction = recipe.getCookingInstructions();
    }


    @Override
    public void execute() {
        recipe.setCookingInstructions(Instruction);

    }

    @Override
    public void undo() {
        recipe.setCookingInstructions(oldInstruction);
    }

    public void updateInstruction(String Instruction){
        this.Instruction = Instruction;
    }
}
