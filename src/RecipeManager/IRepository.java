package RecipeManager;

import Entities.Recipe;

import java.util.ArrayList;

public interface IRepository {

    void addNewRecipe();

    void removeRecipeById(int id);

    Recipe getRecipeById(int id);

    ArrayList<Recipe> getAllRecipes();
}
