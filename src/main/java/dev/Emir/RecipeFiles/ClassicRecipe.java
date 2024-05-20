package dev.Emir.RecipeFiles;

import java.util.ArrayList;

public class ClassicRecipe extends Recipe {
    ArrayList<String> ingredientsList = new ArrayList<>();
    ArrayList<String> CategoriesList = new ArrayList<>();
    ArrayList<String> TagsList = new ArrayList<>();


    public ClassicRecipe() {
        this.Innit();
    }

    @Override
    public ArrayList<String> getIngredients() {
        return null;
    }

    @Override
    public ArrayList<String> getTags() {
        return null;
    }

    @Override
    public ArrayList<String> getCategories() {
        return null;
    }

    @Override
    public ArrayList<Integer> getRatings() {
        return null;

    }


    public void Innit() {
        ingredientsList.add("Brisket");
        ingredientsList.add("Chicken");
        ingredientsList.add("Beef");
        ingredientsList.add("Cheese");
        ingredientsList.add("Vegetables");
        ingredientsList.add("Eggs");
        ingredientsList.add("Fish");
        ingredientsList.add("Lamb");
        ingredientsList.add("Onion");
        ingredientsList.add("Pasta");
        ingredientsList.add("Rice");
        ingredientsList.add("Tomato");


        CategoriesList.add("Breakfast");
        CategoriesList.add("Lunch");
        CategoriesList.add("Dinner");
        CategoriesList.add("Dessert");
        CategoriesList.add("Appetizer");

        TagsList.add("Cold");
        TagsList.add("Hot");
        TagsList.add("SmallPortion");
        TagsList.add("Salty");
        TagsList.add("Sour");
        TagsList.add("Spicy");
        TagsList.add("Sweet");

    }


    public void setName(String name) {
        this.name = name;

    }


    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;

    }


    public void setCookingInstructions(String cookingInstructions) {
        this.cookingInstructions = cookingInstructions;
    }

    public ArrayList<String> getIngredientsList(){
        return ingredientsList;
    }


    public ArrayList<String> getCategoryList() {
        return CategoriesList;
    }


    public ArrayList<String> getTagsList() {
        return TagsList;
    }
}
