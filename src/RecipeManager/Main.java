package RecipeManager;

import Entities.Recipe;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.srart();

        ListRepository listRepository = new ListRepository();

        listRepository.addNewRecipe();
        listRepository.addNewRecipe();
        ArrayList<Recipe> recipes= listRepository.getAllRecipes();
        for (Recipe recipe : recipes)
        {
            System.out.println(recipe);
        }
        Recipe recipe = listRepository.getRecipeById(1);
        System.out.println(recipe);
    }
}