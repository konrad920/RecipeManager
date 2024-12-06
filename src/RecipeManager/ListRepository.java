package RecipeManager;

import Entities.Recipe;

import java.util.ArrayList;
import java.util.Scanner;

public class ListRepository implements IRepository{
    private final ArrayList<Recipe> recipes = new ArrayList<Recipe>();

    public ListRepository(){

    }

    private Recipe createNewRecipe(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj tytuł przepisu: ");
        String title = scanner.next();

        System.out.print("Podaj opis przepisu: ");
        String description = scanner.next();

        return new Recipe(title, description);
    }

    @Override
    public void addNewRecipe() {
        Recipe recipe = createNewRecipe();
        recipes.add(recipe);
    }

    @Override
    public void removeRecipeById(int id) {
recipes.remove(id);
    }

    @Override
    public Recipe getRecipeById(int id) {
        return recipes.get(id);
    }

    @Override
    public ArrayList<Recipe> getAllRecipes() {
        return this.recipes;
    }
}
