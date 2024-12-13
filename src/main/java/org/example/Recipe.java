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
        scanner.nextLine();
        System.out.println("Podaj opis przepisu: ");
        String description = scanner.nextLine();
        System.out.println("Podaj czas potrzebny do przygotowania tego dania: ");
        double timeToPrepared = scanner.nextDouble();

        return new Recipe(title, description, timeToPrepared);
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString(){

        return String.format("%d Przepis to: %s\n", this.id, this.title);
    }

    boolean isEqual(Recipe recipe){
        boolean areTitleSame = this.title.equalsIgnoreCase(recipe.title);
        boolean arePreparedTimeSame = this.timeToPrepared == recipe.timeToPrepared;

        return areTitleSame && arePreparedTimeSame;
    }

}
