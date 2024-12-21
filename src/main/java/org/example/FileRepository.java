package org.example;

import java.io.FileNotFoundException;

public class FileRepository{
    private static final String fileDestinationPrefix = "C:\\programy java\\RecipeManager\\files\\";

    public FileRepository(){
    }

    public void addNewFile(){
        Recipe newRecipe = Recipe.createNewRecipe();
        String path = String.format("%s%s.txt", fileDestinationPrefix, newRecipe.getTitle());
        FileWriter fileWriter = new FileWriter(path);
        try {
            fileWriter.writeFile(newRecipe.getDescription(), newRecipe.getTimeToPrepared());
        } catch (FileNotFoundException e) {
            System.out.println("Plik nie istnieje");
        }
    }
}
