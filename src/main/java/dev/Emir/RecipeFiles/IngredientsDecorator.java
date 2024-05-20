package dev.Emir.RecipeFiles;

public abstract class IngredientsDecorator extends Recipe{
    String name;
    public abstract void setName(String name);
    public abstract String getName();
    public abstract void setCookingInstructions(String cookingInstructions);
    public abstract String getCookingInstructions();
    public abstract void setServingSize(int servingSize);
    public abstract int getServingSize();
    public abstract void setRating(float rating);
    public abstract float getRating();
    public abstract void increaseTotalRatings();
    public abstract int getTotalRatings();
    public abstract String getDecoratorName();
    public abstract void setRecipe(Recipe recipe);
    public abstract Recipe removeDecorator(String decoratorName, Recipe currentDecorator);
    public abstract void removeDecorator(String decoratorName, Recipe currentDecorator, Recipe previousDecorator);
}

