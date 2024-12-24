package org.example;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

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
        write.println();
        write.print(text);
//        for(String line : text){
//            write.println(line);
//        }
        write.close();
    }
}
