package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Recipe {
    private String title;
    private List<String> description;

    private double timeToPrepared;
    private static int idCounter = 0;
    private int id;

    public Recipe(String title) {
        this.title = title;
        this.description = null;
        this.timeToPrepared = 0;
    }

    public Recipe(String title, List<String> description, double timeToPrepared) {
        this.title = title;
        this.description = description;
        this.timeToPrepared = timeToPrepared;
        this.id = ++idCounter;
    }

    public static Recipe createNewRecipe() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj tytuł przepisu: ");
        String title = scanner.nextLine();
        System.out.println("Podaj opis przepisu: ");
        //String description = scanner.nextLine();
        List<String>description = new ArrayList<>();
        byte extendDescription = 0;
        while(extendDescription < 2){
            if(extendDescription == 0){
                System.out.print("Czy chcesz dodać opis(T/N): ");
                String choice = scanner.nextLine();
                if(choice.equalsIgnoreCase("t")){
                    String descriptionPart = scanner.nextLine();
                    description.add(descriptionPart);
                    extendDescription++;
                } else if (choice.equalsIgnoreCase("n") ){
                    break;
                }else{
                    System.out.println("Nie ma takiego wyboru sprobuj jeszcze raz");
                }
            }else {
                System.out.print("Czy chcesz rozszerzyć opis(T/N): ");
                String choice = scanner.nextLine();
                if(choice.equalsIgnoreCase("t")){
                    String descriptionPart = scanner.nextLine();
                    description.add(descriptionPart);
                } else if (choice.equalsIgnoreCase("n")) {
                    extendDescription++;
                }else{
                    System.out.println("Nie ma takiego wyboru sprobuj jeszcze raz");
                }
            }
        }
        System.out.println("Podaj czas potrzebny do przygotowania tego dania: ");
        double timeToPrepared = scanner.nextDouble();

        return new Recipe(title, description, timeToPrepared);
    }

//    public void editRecipe() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Co chcesz zmienić");
//        System.out.println("1 - Tytuł przepisu");
//        System.out.println("2 - Opis przepisu");
//        System.out.println("3 - Czas przygotowania dania");
//        byte option = scanner.nextByte();
//        switch (option){
//            case 1:
//                System.out.print("Podaj nowy tytuł przepisu: ");
//                String editedTitle = scanner.nextLine();
//                scanner.nextLine();
//                this.title = editedTitle;
//                break;
//            case 2:
//                System.out.print("Podaj nowy opis przepisu: ");
//                String editedDescription = scanner.nextLine();
//                scanner.nextLine();
//                this.description = editedDescription;
//                break;
//            case 3:
//                System.out.print("Podaj nowy czas potrzebny do przygotowania tego dania: ");
//                this.timeToPrepared = scanner.nextDouble();
//                break;
//            default:
//                System.out.println("Podany numer operacji nie istnieje");
//        }
//    }

    public String getTitle() {
        return title;
    }

    public List<String> getDescription() {
        return description;
    }

    public double getTimeToPrepared() {
        return timeToPrepared;
    }

    @Override
    public String toString() {

        return String.format("%d Przepis to: %s\n", this.id, this.title);
    }

    boolean isEqual(Recipe recipe) {
        boolean areTitleSame = this.title.equalsIgnoreCase(recipe.title);
        boolean arePreparedTimeSame = this.timeToPrepared == recipe.timeToPrepared;

        return areTitleSame && arePreparedTimeSame;
    }

}
