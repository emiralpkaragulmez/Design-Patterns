package dev.Emir.RecipeFiles.Categories;

import dev.Emir.RecipeFiles.CategoriesDecorator;
import dev.Emir.RecipeFiles.Recipe;

import java.util.ArrayList;
import java.util.Objects;

public class CtgDinner extends CategoriesDecorator {
    Recipe recipe;



    public CtgDinner(Recipe recipe) {
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
        if (recipe.getCategories() == null) {
            return new ArrayList<String>() {{
                add("Dinner");
            }};
        } else {
            ArrayList<String> categories = recipe.getCategories();
            categories.add("Dinner");
            return categories;
        }
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
        return "Dinner";
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

//    public Recipe removeDecorator(String decoratorName) {
//        if (Objects.equals(getDecoratorName(), decoratorName)) {
//            return recipe;
//        } else {
//            return removeDecorator(decoratorName, recipe);
//        }
//    }
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
