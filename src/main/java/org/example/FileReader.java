package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileReader {
    private final String path;

    public FileReader(String path) {
        this.path = path;
    }

    public void readFile() throws FileNotFoundException {
        File file = new File(this.path);
        Scanner in = new Scanner(file);

        List<String>listOfLines = new ArrayList<>();
        int counter = 0;
        while (true) {
            try{
                String line = in.nextLine();
                if(line != null){
                    listOfLines.add(line);
                    counter++;
                }
            }catch (NoSuchElementException e){
                System.out.println("Zakończono wczytywanie pliku");
                break;
            }
        }

        for(String line : listOfLines){
            System.out.println(line);
        }
    }
}