package dev.Emir.RecipeManager;

import dev.Emir.RecipeFiles.Ratings.*;
import dev.Emir.RecipeFiles.Recipe;

import java.util.ArrayList;

public class RecipeRateModule {
    public RecipeRateModule() {
    }

    public Recipe rateRecipe(Recipe recipe, int rate) {
        switch (rate) {
            case 1:
                recipe = new OneRate(recipe);
                break;
            case 2:
                recipe = new TwoRate(recipe);
                break;
            case 3:
                recipe = new ThreeRate(recipe);
                break;
            case 4:
                recipe = new FourRate(recipe);
                break;
            case 5:
                recipe = new FiveRate(recipe);
                break;
            default:
                System.out.println("Invalid rate");
                break;
        }
        recipe.increaseTotalRatings();
        float newRate = calculateNewRate(recipe);
        System.out.println("New rate: " + newRate);
        recipe.setRating(newRate);

        System.out.println("Recipe rated");
        return recipe;
    }


    public float calculateNewRate(Recipe recipe) {
        ArrayList<Integer> temp = recipe.getRatings();
        System.out.println(temp);
        int length = temp.size();
        float sum = 0;
        for (int i = 0; i < length; i++) {
            sum += temp.get(i);
        }
        float avg = sum / length;
        return avg;
    }

}
