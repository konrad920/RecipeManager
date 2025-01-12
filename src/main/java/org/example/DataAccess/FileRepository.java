package org.example.DataAccess;

import org.example.Components.ConsoleLogger;
import org.example.Components.FileReader;
import org.example.Components.FileWriter;

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

    public void addNewFileFromFrame(String title, String description, double timeToPrepared) throws FileNotFoundException {
        if (isFileExist(title + ".txt")) {
            System.out.printf("plik %s już istnieje", title);
        } else {
            Recipe newRecipe = new Recipe(title, description, timeToPrepared);
            String path = String.format("%s%s.txt", fileDestinationPrefix, newRecipe.getTitle());
            FileWriter fileWriter = new FileWriter(path);
            fileWriter.writeFile(newRecipe.getDescription(), newRecipe.getTimeToPrepared());

            String infoString = String.format("Utworzono plik %s", newRecipe.getTitle());
            logger.info(infoString);
            throw new FileNotFoundException(infoString);
        }
    }

    public void printFile(String fileNameToFind) throws FileNotFoundException {
        File fileFound = getFile(this.directory, fileNameToFind);
        FileReader fileReader = new FileReader(fileFound.getAbsolutePath());
        fileReader.readFile();
    }

    private File getFile(File directory, String fileNameToFind) throws FileNotFoundException {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        getFile(file, fileNameToFind);
                    } else {
                        if (file.getName().equals(fileNameToFind)) {
                            return file;
                        }
                    }
                }
            }
        }
        throw new FileNotFoundException("Nie ma takiego przepisu");
    }

    private boolean isFileExist(String fileTitleToFind) {
        try {
            File fileToFind = getFile(this.directory, fileTitleToFind);
            if (fileToFind.getName().equals(fileTitleToFind))
                return true;
        } catch (FileNotFoundException e) {
            return false;
        }
        return false;
    }
}
