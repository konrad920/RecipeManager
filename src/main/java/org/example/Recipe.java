package org.example;

import java.util.Scanner;

public class Recipe {
    private String title;
    private String description;
    private double timeToPrepared;
    private static int idCounter = 0;
    private int id;

    public Recipe(String title){
        this.title = title;
        this.description = null;
        this.timeToPrepared = 0;
    }

    public Recipe(String title, String description, double timeToPrepared){
        this.title = title;
        this.description = description;
        this.timeToPrepared = timeToPrepared;
        this.id = ++idCounter;
    }

    public static Recipe createNewRecipe(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj tytuł przepisu: ");
        String title = scanner.next();
        System.out.println("Podaj opis przepisu: ");
        String description = scanner.next();
        System.out.println("Podaj czas potrzebny do przygotowania tego dania: ");
        double timeToPrepared = scanner.nextDouble();

        return new Recipe(title, description, timeToPrepared);
    }

    @Override
    public String toString(){

        return String.format("Przepis: %s, ma id: %d", this.title,this.id);
    }
}
