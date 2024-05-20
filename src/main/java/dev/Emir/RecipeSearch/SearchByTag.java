package dev.Emir.RecipeSearch;

import dev.Emir.RecipeFiles.ClassicRecipe;
import dev.Emir.RecipeFiles.Recipe;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchByTag implements SearchBehaviour{

    public ArrayList<Recipe> Search(ArrayList<Recipe> recipes){

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
        int count = 0;
        ArrayList<Recipe> results = new ArrayList<Recipe>();
        while (count < recipes.size()) {
            Recipe recipe = recipes.get(count);
            ArrayList<String> tags = recipe.getTags();

            try{
                tags.size();
            }catch (NullPointerException e){
                count++;
                continue;
            }
            for (int i = 0; i < tags.size(); i++) {
                for (int j = 0; j < ExpectedKeys.size(); j++) {
                    if (tags.get(i).toLowerCase().equals(ExpectedKeys.get(j).toLowerCase())) {
                        if (isAdded(results, recipe)) results.add(recipe);
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

    private ArrayList<String> getKeywords(){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> tags = new ClassicRecipe().getTagsList();

        for(int i=0;i<tags.size();i++){
            System.out.println((i+1) + " " + tags.get(i));
        }
        System.out.println("Please select which tags would you like to search by typing the numbers and type 'End' to complete your selections.");

        int counter = 0;
        while(true){
            String decision = sc.nextLine();
            if(decision.toLowerCase().equals("end")) break;
            try{
                int i = Integer.parseInt(decision);
                if (i > tags.size() || i < 1){
                    System.out.println("Wrong input, please try again.");
                    continue;
                }
                arrayList.add(tags.get(i-1).toLowerCase());
                counter += 1;
                if(counter >= tags.size()) break;
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