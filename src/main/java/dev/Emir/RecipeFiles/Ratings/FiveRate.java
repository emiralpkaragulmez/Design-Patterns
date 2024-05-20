package dev.Emir.RecipeFiles.Ratings;

import dev.Emir.RecipeFiles.RatingsDecorator;
import dev.Emir.RecipeFiles.Recipe;

import java.util.ArrayList;

public class FiveRate extends RatingsDecorator {
    Recipe recipe;

    public FiveRate(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public ArrayList<String> getIngredients() {
        return recipe.getIngredients();
    }

    @Override
    public ArrayList<String> getTags() {
        return recipe.getTags();
    }

    @Override
    public ArrayList<String> getCategories() {
        return recipe.getCategories();
    }

    @Override
    public ArrayList<Integer> getRatings() {
        if (recipe.getRatings() == null) {
            ArrayList<Integer> ratings = new ArrayList<>();
            ratings.add(5);
            return ratings;
        } else {
            ArrayList<Integer> ratings = recipe.getRatings();
            ratings.add(5);
            return ratings;
        }
    }
    @Override
    public void setName(String name) {
        recipe.setName(name);
    }

    @Override
    public String getName() {
        return recipe.getName();
    }

    @Override
    public void setCookingInstructions(String cookingInstructions) {
        recipe.setCookingInstructions(cookingInstructions);
    }

    @Override
    public String getCookingInstructions() {
        return recipe.getCookingInstructions();
    }

    @Override
    public void setServingSize(int servingSize) {
        recipe.setServingSize(servingSize);
    }

    @Override
    public int getServingSize() {
        return recipe.getServingSize();
    }

    @Override
    public void setRating(float rating) {
        recipe.setRating(rating);
    }

    @Override
    public float getRating() {
        return recipe.getRating();
    }

    @Override
    public void increaseTotalRatings() {
        recipe.increaseTotalRatings();
    }


    @Override
    public int getTotalRatings() {
        return recipe.getTotalRatings();
    }

}
