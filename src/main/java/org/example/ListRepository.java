package org.example;

import java.util.ArrayList;

public class ListRepository {
    private ArrayList<Recipe> recipes = new ArrayList<>();

    public void addRecipe(){
        Recipe recipe = Recipe.createNewRecipe();
        recipes.add(recipe);
    }

    public void deleteRecipeByID(int id){
        recipes.remove(id);
    }

    public Recipe getRecipeById(int id){
        return recipes.get(id);
    }

    public ArrayList<Recipe> getRecipes(){
        return this.recipes;
    }

    public void printRecipes(){
        ArrayList<Recipe> recipes = getRecipes();
        for (Recipe recipe : recipes){
            System.out.println(recipe.toString());
        }
    }

    public void printRecipe(int id){
        Recipe recipe = getRecipeById(id);
        System.out.println(recipe.toString());
    }
}
