package dev.Emir.RecipeSearch;

import dev.Emir.RecipeFiles.Recipe;

import java.util.ArrayList;

public interface SearchBehaviour {
    public abstract ArrayList<Recipe> Search(ArrayList<Recipe> recipes);

}