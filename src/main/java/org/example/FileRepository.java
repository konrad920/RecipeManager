package org.example;

import java.io.File;
import java.io.FileNotFoundException;

public class FileRepository {
    private static final String fileDestinationPrefix = "C:\\programy java\\RecipeManager\\files\\";
    private final ConsoleLogger logger;
    File directory = new File("C:\\programy java\\RecipeManager\\files");

    public FileRepository(ConsoleLogger logger) {
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

    public void printFile(String fileNameToFind) throws FileNotFoundException {
        File fileFound = getFileTitle(this.directory, fileNameToFind);
        //String path = String.format("%sre.txt", fileDestinationPrefix);
        FileReader fileReader = new FileReader(fileFound.getAbsolutePath());
        fileReader.readFile();
    }

    private File getFileTitle(File directory, String fileNameToFind) throws FileNotFoundException {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        getFileTitle(file, fileNameToFind);
                    } else {
                        if(file.getName().equals(fileNameToFind)){
                            return file;
                        }
                    }
                }
            }
        }
        throw new FileNotFoundException();
    }
}
