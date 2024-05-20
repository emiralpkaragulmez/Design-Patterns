package dev.Emir.RecipeSearch;

import dev.Emir.RecipeFiles.ClassicRecipe;
import dev.Emir.RecipeFiles.Recipe;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchByIngredients implements SearchBehaviour{
    @Override
    public ArrayList<Recipe> Search(ArrayList<Recipe> recipes) {
        int count = 0;
        ArrayList<String> ExpectedKeys = getKeywords();

        try{
            if(recipes.size() == 0){
                System.out.println("There is no saved recipes.");
                SearchManager searchManager = new SearchManager();
                searchManager.makeSearch();
            }
        }catch (NullPointerException e){
            System.out.println("There is no saved recipes.");
            SearchManager searchManager = new SearchManager();
            searchManager.makeSearch();

        }

        ArrayList<Recipe> results = new ArrayList<Recipe>();
        while(count<recipes.size()){
            Recipe recipe = recipes.get(count);
            ArrayList<String> ingredients = recipe.getIngredients();
            try{
                ingredients.size();
            }catch (NullPointerException e){
                count++;
                continue;
            }
            for(int i=0;i<ingredients.size();i++){
                for(int j=0;j<ExpectedKeys.size();j++){
                    if(ingredients.get(i).toLowerCase().equals(ExpectedKeys.get(j).toLowerCase())){
                        if(isAdded(results,recipe)) results.add(recipe);
                    }
                }
            }
            count++;
        }

        return results;
    }

    private boolean isAdded(ArrayList<Recipe> arrayList, Recipe recipe){
        for(int i=0;i<arrayList.size();i++){
            if(arrayList.get(i).equals(recipe)) return false;
        }
        return true;
    }

    public ArrayList<String> getKeywords(){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> ingredients = new ClassicRecipe().getIngredientsList();

        for(int i=0;i<ingredients.size();i++){
            System.out.println((i+1) + " " + ingredients.get(i));
        }
        System.out.println("Please select which tags would you like to search by typing the numbers and type 'End' to complete your selections.");

        int counter = 0;
        while(true){
            String decision = sc.nextLine();
            if(decision.toLowerCase().equals("end")) break;
            try{
                int i = Integer.parseInt(decision);
                if (i > ingredients.size() || i < 1){
                    System.out.println("Wrong input, please try again.");
                    continue;
                }
                arrayList.add(ingredients.get(i-1).toLowerCase());
                counter += 1;
                if(counter >= ingredients.size()) break;
            }catch (NumberFormatException e){
                System.out.println("Wrong input, please try again.");
                continue;
            }
        }
        try{
            if(arrayList.size() == 0){
                System.out.println("No match");
            }
        }catch (NullPointerException e){
            System.out.println("No match");
            return arrayList;
        }
        return arrayList;
    }
}