package dev.Emir.RecipeManager;

import dev.Emir.RecipeFiles.Categories.CtgBreakfast;
import dev.Emir.RecipeFiles.Categories.CtgDessert;
import dev.Emir.RecipeFiles.Categories.CtgDinner;
import dev.Emir.RecipeFiles.Categories.CtgLunch;
import dev.Emir.RecipeFiles.ClassicRecipe;
import dev.Emir.RecipeFiles.Recipe;
import dev.Emir.RecipeFiles.Ingredients.IngBrisket;
import dev.Emir.RecipeFiles.Ingredients.IngChicken;
import dev.Emir.RecipeFiles.Ingredients.*;
import dev.Emir.RecipeFiles.Tags.*;

import java.util.ArrayList;
import java.util.Scanner;

public class RecipeCreateModule {

    public Recipe createRecipe(int servingSize, String cookingInstructions, String name){
        ClassicRecipe recipe = new ClassicRecipe();
        recipe.setServingSize(servingSize);
        recipe.setCookingInstructions(String.valueOf(cookingInstructions));
        recipe.setName(name);
        return recipe;
    }

    public Recipe askAndAddIngredients(Recipe recipe){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bir malzeme ekleyin: ");
        String ingredient = scanner.nextLine();
        recipe = addIngredients(ingredient, recipe);
        return recipe;
    }
    public Recipe addIngredients(String ingredient, Recipe recipe){
        switch (ingredient){
            case "Brisket":
                recipe = new IngBrisket(recipe);
                System.out.println("Brisket ingredient added");
                break;
            case "Tomato":
                recipe = new IngTomato(recipe);
                System.out.println("Tomato ingredient added");
                break;
            case "Chicken":
                recipe = new IngChicken(recipe);
                System.out.println("Chicken ingredient added");
                break;
            case "Beef":
                recipe = new IngBeef(recipe);
                System.out.println("Beef ingredient added");
                break;
            case "Rice":
                recipe = new IngRice(recipe);
                System.out.println("Rice ingredient added");
                break;
            case "Cheese":
                recipe = new IngCheese(recipe);
                System.out.println("Cheese ingredient added");
                break;
            case "Eggs":
                recipe = new IngEggs(recipe);
                System.out.println("Eggs ingredient added");
                break;
            case "Fish":
                recipe = new IngFish(recipe);
                System.out.println("Fish ingredient added");
                break;
            case "Lamb":
                recipe = new IngLamb(recipe);
                System.out.println("Lamb ingredient added");
                break;
            case "Onion":
                recipe = new IngOnion(recipe);
                System.out.println("Onion ingredient added");
                break;
            case "Pasta":
                recipe = new IngPasta(recipe);
                System.out.println("Pasta ingredient added");
                break;
            case "Vegetables": // This is a new ingredient
                recipe = new IngVegetables(recipe);
                System.out.println("Vegetables ingredient added");
                break;
            default:
                break;
        }

        return recipe;
    }

    public void printIngredients(Recipe recipe){
        ArrayList<String> list = ((ClassicRecipe)recipe).getIngredientsList();

        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    public void printCategories(Recipe recipe){
        ArrayList<String> list = ((ClassicRecipe)recipe).getCategoryList();

        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    public Recipe askAndAddCategories(Recipe recipe){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bir kategori ekleyin: ");
        String category = scanner.nextLine();
        recipe = addCategories(category, recipe);
        return recipe;
    }

    public Recipe addCategories(String category, Recipe recipe){
        switch (category){
            case "Appetizer":
                recipe = new CtgBreakfast(recipe);
                System.out.println("Appetizer category added");
                break;
            case "Dessert":
                recipe = new CtgDessert(recipe);
                System.out.println("Dessert category added");
                break;
            case "Breakfast":
                recipe = new CtgBreakfast(recipe);
                System.out.println("Breakfast category added");
                break;
            case "Lunch":
                recipe = new CtgLunch(recipe);
                System.out.println("Lunch category added");
                break;
            case "Dinner":
                recipe = new CtgDinner(recipe);
                System.out.println("Dinner category added");
                break;
            default:
                break;
        }

        return recipe;
    }


    public Recipe printTags(Recipe recipe){
        ArrayList<String> list = ((ClassicRecipe)recipe).getTagsList();

        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
        return recipe;
    }

    public Recipe askAndAddTags(Recipe recipe){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bir etiket ekleyin: ");
        String tag = scanner.nextLine();
        recipe = addTags(tag, recipe);
        return recipe;
    }

    public Recipe addTags(String tag, Recipe recipe){
        switch (tag){
            case "Cold":
                recipe = new TagCold(recipe);
                System.out.println("Cold tag added");
                break;
            case "Hot":
                recipe = new TagHot(recipe);
                System.out.println("Hot tag added");
                break;
            case "SmallPortion":
                recipe = new TagSmallPortion(recipe);
                System.out.println("SmallPortion tag added");
                break;
            case "Salty":
                recipe = new TagSalty(recipe);
                System.out.println("Salty tag added");
                break;
            case "Sweet":
                recipe = new TagSweet(recipe);
                System.out.println("Sweet tag added");
                break;
            case "Spicy":
                recipe = new TagSpicy(recipe);
                System.out.println("Spicy tag added");
                break;
            case "Sour":
                recipe = new TagSour(recipe);
                System.out.println("Sour tag added");
                break;
            default:
                break;
        }

        return recipe;
    }

    public Recipe completeCreatingRecipe(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the recipe: ");
        String name = scanner.nextLine();
        System.out.println("Enter the serving size of the recipe: ");
        int servingSize = scanner.nextInt();
        System.out.println("Enter the cooking instructions of the recipe: ");
        String cookingInstructions = scanner.next();
        Recipe recipe = createRecipe(servingSize, cookingInstructions, name);
        Recipe recipeBase = recipe;
        System.out.println("Enter the ingredients of the recipe: ");
        printIngredients(recipeBase);
        System.out.println("To finish selecting ingredients, type 'exit'");
        while (true){
            String ingredient = scanner.next();
            if (ingredient.equals("exit")){
                break;
            }
            recipe = addIngredients(ingredient, recipe);
        }

        System.out.println("Enter the categories of the recipe: ");
        printCategories(recipeBase);
        System.out.println("To finish selecting categories, type 'exit'");
        while (true){
            String category = scanner.next();
            if (category.equals("exit")){
                break;
            }
            recipe = addCategories(category, recipe);
        }

        System.out.println("Enter the tags of the recipe: ");
        printTags(recipeBase);
        System.out.println("To finish selecting tags, type 'exit'");
        while (true){
            String tag = scanner.next();
            if (tag.equals("exit")){
                break;
            }
            recipe = addTags(tag, recipe);
        }

        return recipe;
    }

}
