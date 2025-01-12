package org.example.Components;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ConsoleLogger {
    private String path = "C:\\programy java\\RecipeManager\\Logger\\logger.txt";

    public void info(String message) {
        loggerWriter("INFO: " + message);
    }

    public void error(String message) {
        loggerWriter("ERROR: " + message);
    }

    public void loggerWriter(String message) {
        try {
            PrintWriter writer = new PrintWriter(this.path);
            writer.println(message);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku logger.txt");
        }
    }

    public void loggerReader() throws FileNotFoundException {
        File loggerFile = new File(this.path);
        Scanner loggerIn = new Scanner(loggerFile);

        List<String> loggerText = new ArrayList<>();
        while (true) {
            try {
                String line = loggerIn.nextLine();
                if (line != null)
                    loggerText.add(line);
            } catch (NoSuchElementException ex) {
                System.out.println("Zakończono wczytywanie pliku");
                break;
            }
        }

        for(String line : loggerText){
            System.out.println(line);
        }
    }
}
