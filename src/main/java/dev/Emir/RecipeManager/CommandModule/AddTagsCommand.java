package dev.Emir.RecipeManager.CommandModule;

import dev.Emir.RecipeFiles.Recipe;
import dev.Emir.RecipeFiles.Tags.*;

public class AddTagsCommand implements Command{
    Recipe newRecipe;
    String tag;
    Recipe oldRecipe = null;

    public AddTagsCommand(Recipe recipe, String tag) {
        this.newRecipe = recipe;
        this.tag = tag;
        oldRecipe = recipe;
    }

    @Override
    public void execute() {
        switch (tag){
            case "Cold":
                newRecipe = new TagCold(newRecipe);
                System.out.println("Cold tag added");
                break;
            case "Hot":
                newRecipe = new TagHot(newRecipe);
                System.out.println("Hot tag added");
                break;
            case "SmallPortion":
                newRecipe = new TagSmallPortion(newRecipe);
                System.out.println("SmallPortion tag added");
                break;
            case "Salty":
                newRecipe = new TagSalty(newRecipe);
                System.out.println("Salty tag added");
                break;
            case "Sweet":
                newRecipe = new TagSweet(newRecipe);
                System.out.println("Sweet tag added");
                break;
            case "Spicy":
                newRecipe = new TagSpicy(newRecipe);
                System.out.println("Spicy tag added");
                break;
            case "Sour":
                newRecipe = new TagSour(newRecipe);
                System.out.println("Sour tag added");
                break;
            default:
                break;
        }
    }

    public void undo() {
        newRecipe = oldRecipe;
    }

    public Recipe getRecipe(){
        return newRecipe;
    }
    public void updateTag(String tag){
        this.tag = tag;
    }


}
