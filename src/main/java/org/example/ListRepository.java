package org.example;

import java.util.ArrayList;

public class ListRepository {
    private ArrayList<Recipe> recipes = new ArrayList<>();

    public void addRecipe(){
        Recipe recipe = Recipe.createNewRecipe();
        recipes.add(recipe);
    }

    public void deleteRecipe(int id){
        recipes.remove(id);
    }

    public Recipe getRecipeById(int id){
        return recipes.get(id);
    }

    public ArrayList<Recipe> getRecipes(){
        return this.recipes;
    }
}
