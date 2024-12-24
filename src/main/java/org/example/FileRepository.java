package org.example;

import java.io.FileNotFoundException;

public class FileRepository{
    private static final String fileDestinationPrefix = "C:\\programy java\\RecipeManager\\files\\";
    private final ConsoleLogger logger;

    public FileRepository(ConsoleLogger logger){
        this.logger = logger;
    }

    public void addNewFile() throws FileNotFoundException {
        Recipe newRecipe = Recipe.createNewRecipe();
        String path = String.format("%s%s.txt", fileDestinationPrefix, newRecipe.getTitle());
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.writeFile(newRecipe.getDescription(), newRecipe.getTimeToPrepared());

        String infoString = String.format("Utworzono plik %s", newRecipe.getTitle());
        logger.info(infoString);
        throw new FileNotFoundException(infoString);
    }
}
