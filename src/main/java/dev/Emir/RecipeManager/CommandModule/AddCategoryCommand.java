package dev.Emir.RecipeManager.CommandModule;

import dev.Emir.RecipeFiles.Categories.CtgBreakfast;
import dev.Emir.RecipeFiles.Categories.CtgDinner;
import dev.Emir.RecipeFiles.Categories.CtgLunch;
import dev.Emir.RecipeFiles.Categories.CtgDessert;
import dev.Emir.RecipeFiles.Ingredients.IngBrisket;
import dev.Emir.RecipeFiles.Ingredients.IngChicken;
import dev.Emir.RecipeFiles.Ingredients.IngTomato;
import dev.Emir.RecipeFiles.Recipe;

public class AddCategoryCommand implements Command{
    Recipe newRecipe;
    String category;
    Recipe oldRecipe = null;

    public AddCategoryCommand(Recipe recipe, String ingredient) {
        this.newRecipe = recipe;
        this.category = ingredient;
        oldRecipe = recipe;
    }

    @Override
    public void execute() {
        switch (category){
            case "Appetizer":
                newRecipe = new CtgBreakfast(newRecipe);
                System.out.println("Appetizer category added");
                break;
            case "Dessert":
                newRecipe = new CtgDessert(newRecipe);
                System.out.println("Dessert category added");
                break;
            case "Breakfast":
                newRecipe = new CtgBreakfast(newRecipe);
                System.out.println("Breakfast category added");
                break;
            case "Lunch":
                newRecipe = new CtgLunch(newRecipe);
                System.out.println("Lunch category added");
                break;
            case "Dinner":
                newRecipe = new CtgDinner(newRecipe);
                System.out.println("Dinner category added");
                break;
            default:
                break;
        }

    }

    @Override
    public void undo() {
        newRecipe = oldRecipe;
    }

    public Recipe getRecipe(){
        return newRecipe;
    }

    public void updateCategory(String category){
        this.category = category;
    }
}
