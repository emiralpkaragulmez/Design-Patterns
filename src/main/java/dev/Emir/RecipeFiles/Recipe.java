package dev.Emir.RecipeFiles;

import java.util.ArrayList;

public abstract class Recipe {
//    ArrayList<String> ingredientsList = new ArrayList<>();
//    ArrayList<String> CategoriesList = new ArrayList<>();
//    ArrayList<String> TagsList = new ArrayList<>();
//    String cookingInstructions = "Cooking Instructions";
//    String name = "Recipe";
//    int servingSize = 0;
//    float rating = 0.0f;
    String cookingInstructions = "Cooking Instructions";
    String name = "Recipe";
    int servingSize = 0;
    float rating = 0.0f;
    int totalRatings = 0;

    public static Recipe beforeDecorator;
    public static Recipe removedDecorator;
    public static Recipe afterDecorator;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setCookingInstructions(String cookingInstructions) {
        this.cookingInstructions = cookingInstructions;
    }
    public String getCookingInstructions() {
        return cookingInstructions;
    }
    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }
    public int getServingSize() {
        return servingSize;
    }
    public void setRating(float rating) {
        this.rating = rating;
    }
    public float getRating() {
        return rating;
    }
    public void increaseTotalRatings() {
        this.totalRatings += 1;
    }
    public int getTotalRatings() {
        return totalRatings;
    }

    public void setRecipe(Recipe recipe) {
    }

    public Recipe removeDecorator(String decoratorName, Recipe currentDecorator) {
        return null;
    }

    public void removeDecorator(String decoratorName, Recipe currentDecorator, Recipe previousDecorator) {

    }

    public abstract ArrayList<String> getIngredients();
    public abstract ArrayList<String> getTags();
    public abstract ArrayList<String> getCategories();
    public abstract ArrayList<Integer> getRatings();


}
