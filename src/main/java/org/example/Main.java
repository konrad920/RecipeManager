package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ListRepository listRepository = new ListRepository();
        listRepository.addRecipe();
        listRepository.addRecipe();
        ArrayList<Recipe> lista = listRepository.getRecipes();
        for (Recipe recipe : lista) {
            System.out.println(recipe.toString());
        }

        System.out.println("wybieram przepis z id=1");
        System.out.println(listRepository.getRecipeById(1).toString());
        System.out.println("usuwam przepis z id=1");
        listRepository.deleteRecipe(1);

        for (Recipe recipe : lista) {
            System.out.println(recipe.toString());
        }
    }
}