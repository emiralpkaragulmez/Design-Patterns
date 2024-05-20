package dev.Emir.RecipeManager.CommandModule;

import dev.Emir.RecipeFiles.Ingredients.*;
import dev.Emir.RecipeFiles.Recipe;

public class AddIngredientCommand implements Command{
    Recipe newRecipe;
    String ingredient;
    Recipe oldRecipe = null;

    public AddIngredientCommand(Recipe recipe, String ingredient) {
        this.newRecipe = recipe;
        this.ingredient = ingredient;
        oldRecipe = recipe;
    }

    @Override
    public void execute() {
        switch (ingredient){
            case "Brisket":
                newRecipe = new IngBrisket(newRecipe);
                System.out.println("Brisket ingredient added");
                break;
            case "Tomato":
                newRecipe = new IngTomato(newRecipe);
                System.out.println("Tomato ingredient added");
                break;
            case "Chicken":
                newRecipe = new IngChicken(newRecipe);
                System.out.println("Chicken ingredient added");
                break;
            case "Beef":
                newRecipe = new IngBeef(newRecipe);
                System.out.println("Beef ingredient added");
                break;
            case "Rice":
                newRecipe = new IngRice(newRecipe);
                System.out.println("Rice ingredient added");
                break;
            case "Cheese":
                newRecipe = new IngCheese(newRecipe);
                System.out.println("Cheese ingredient added");
                break;
            case "Eggs":
                newRecipe = new IngEggs(newRecipe);
                System.out.println("Eggs ingredient added");
                break;
            case "Fish":
                newRecipe = new IngFish(newRecipe);
                System.out.println("Fish ingredient added");
                break;
            case "Lamb":
                newRecipe = new IngLamb(newRecipe);
                System.out.println("Lamb ingredient added");
                break;
            case "Onion":
                newRecipe = new IngOnion(newRecipe);
                System.out.println("Onion ingredient added");
                break;
            case "Pasta":
                newRecipe = new IngPasta(newRecipe);
                System.out.println("Pasta ingredient added");
                break;
            case "Vegetables": // This is a new ingredient
                newRecipe = new IngVegetables(newRecipe);
                System.out.println("Vegetables ingredient added");
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

    public void updateIngredient(String ingredient){
        this.ingredient = ingredient;
    }
}
