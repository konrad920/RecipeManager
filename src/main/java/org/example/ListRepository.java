package org.example;

import java.util.ArrayList;

public class ListRepository {
    private ArrayList<Recipe> recipes = new ArrayList<>();
    private ConsoleLogger logger;

    public ListRepository(ConsoleLogger logger) {
        this.logger = logger;
    }

    public void addRecipe() throws Exception {
        Recipe newRecipe = Recipe.createNewRecipe();
        boolean exist = false;
        for(Recipe recipe: recipes){
            if(recipe.isEqual(newRecipe)){
                exist = true;
            }
        }

        if(exist){
            String errorString = String.format("Przepis już istnieje: ", newRecipe.toString());
            logger.error(errorString);
            throw new Exception(errorString);
        }else{
        recipes.add(newRecipe);
        String infoString = String.format("Dodano przepis %s\n", newRecipe.getTitle());
        logger.info(infoString);}
    }

    public void deleteRecipeByID(int id) throws Exception {
        Recipe recipeToDelete = getRecipeById(id);
        recipes.remove(recipeToDelete);
        String infoString = String.format("Usunięto przepis %s", recipeToDelete.getTitle());
        logger.info(infoString);
    }

    public Recipe getRecipeById(int id) throws Exception {
        ArrayList<Recipe> recipeArrayList = getRecipes();
        if(id >= 0 && id < recipeArrayList.size()){
            return recipes.get(id);
        }
        else {
            logger.error("Nie ma przepisu z takim indeksem");
            throw new Exception("Nie ma przepisu z takim indeksem");
        }
    }

    public ArrayList<Recipe> getRecipes(){
        if(this.recipes.isEmpty()) {
            logger.error("Nie ma jeszcze żadnych przepisów");
            throw new NullPointerException("Nie ma jeszcze żadnych przepisów");
        }

        return this.recipes;
    }

    public void printRecipes(){
        ArrayList<Recipe> recipes = getRecipes();
        for (Recipe recipe : recipes){
            System.out.println(recipe.toString());
        }
    }

    public void printRecipe(int id) throws Exception {
        Recipe recipe = getRecipeById(id);
        System.out.println(recipe.toString());
    }
}
