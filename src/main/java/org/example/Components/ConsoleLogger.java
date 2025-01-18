package org.example.Components;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class ConsoleLogger {
    private String path = "C:\\programy java\\RecipeManager\\Logger\\logger.txt";
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");

    public void info(String message) {
        loggerWriter("INFO: " + message);
    }

    public void error(String message) {
        loggerWriter("ERROR: " + message);
    }

    public void loggerWriter(String message) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.path, true);
            PrintWriter writer = new PrintWriter(fileOutputStream, true);
            writer.printf("[%s] %s",getCurrentDateString(), message);
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

    private String getCurrentDateString(){
        Date now = new Date();
        return this.dateFormat.format(now);
    }
}
