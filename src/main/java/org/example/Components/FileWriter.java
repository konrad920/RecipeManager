package org.example.Components;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileWriter {
    private final String path;
    private final static String timeToPreparedText = "Czas potrzebny do przygotowania tego dania to: ";

    public FileWriter(String path){
        this.path = path;

    }

    public void writeFile(String text, double value) throws FileNotFoundException {
        PrintWriter write = new PrintWriter(this.path);
        String timeToPrepared = String.format("%s%.2f", timeToPreparedText, value);
        write.println(timeToPrepared);
        write.println("Sposób wykonania:");
        write.print(text);
        write.close();
    }
}
