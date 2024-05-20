package dev.Emir.RecipeFiles.Tags;
import dev.Emir.RecipeFiles.Recipe;
import dev.Emir.RecipeFiles.TagsDecorator;

import java.util.ArrayList;
import java.util.Objects;
public class TagSpicy extends TagsDecorator {
    Recipe recipe;

    public TagSpicy(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public ArrayList<String> getIngredients() {
        return recipe.getIngredients();
    }

    @Override
    public ArrayList<String> getTags() {
        if (recipe.getTags() == null) {
            ArrayList<String> tags = new ArrayList<>();
            tags.add("Spicy");
            return tags;
        } else {
            ArrayList<String> tags = recipe.getTags();
            tags.add("Spicy");
            return tags;
        }
    }

    @Override
    public ArrayList<String> getCategories() {
        return recipe.getCategories();
    }

    @Override
    public ArrayList<Integer> getRatings() {
        return recipe.getRatings();
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
    @Override
    public String getDecoratorName() {
        return "Spicy";
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }


    public Recipe removeDecorator(String decoratorName, Recipe currentDecorator) {
        if (Objects.equals(getDecoratorName(), decoratorName)) {
            removedDecorator = currentDecorator;
            afterDecorator = recipe;
            beforeDecorator = null;
            return recipe;
        } else {
            recipe.removeDecorator(decoratorName, recipe, currentDecorator);
            return currentDecorator;

        }
    }
    public void removeDecorator(String decoratorName, Recipe currentDecorator, Recipe previousDecorator) {
        if (Objects.equals(getDecoratorName(), decoratorName)) {
            previousDecorator.setRecipe(recipe);
            removedDecorator = currentDecorator;
            afterDecorator = recipe;
            beforeDecorator = previousDecorator;
        } else {
            recipe.removeDecorator(decoratorName, recipe, currentDecorator);
        }
    }
}
