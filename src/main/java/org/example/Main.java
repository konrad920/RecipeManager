package org.example;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsoleLogger consoleLogger = new ConsoleLogger();
        ListRepository listRepository = new ListRepository(consoleLogger);
        Frame frame = new Frame();

        byte operationNumber;
        do {
            System.out.println("Witaj w programie do przepisów kulinarnych!!!");
            System.out.println("1 - Wyświetl listę przepisów");
            System.out.println("2 - Wyświetl przepis o konkretnym numerze ID");
            System.out.println("3 - Dodaj nowy przepis");
            System.out.println("4 - Usuń przepis z listy");
            System.out.println("9 - Zakończ działanie programu\n");
            System.out.print("Wybierz co chcesz zrobić: ");
            operationNumber = scanner.nextByte();

            switch (operationNumber) {
                case 1:
                    try {
                        listRepository.printRecipes();
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Podaj id przepisu do wyświetlenia: ");
                    int idToGet = scanner.nextInt();
                    try {
                        listRepository.printRecipe(idToGet - 1);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        listRepository.addRecipe();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("Podaj id przepisu do usunięcia: ");
                    int idToDelete = scanner.nextInt();
                    try {
                        listRepository.deleteRecipeByID(idToDelete - 1);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 9:
                    System.out.println("Zakończyłeś pracę programu");
                    break;
                default:
                    System.out.println("Podany numer operacji nie istnieje");
            }
        } while (operationNumber != 9);
    }
}