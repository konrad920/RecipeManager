package org.example;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        ConsoleLogger consoleLogger = new ConsoleLogger();
        //ListRepository listRepository = new ListRepository(consoleLogger);
        FileRepository fileRepository = new FileRepository(consoleLogger);
        Frame frame = new Frame();
        frame.setVisible(true);

        frame.bNewFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    fileRepository.addNewFile();
                } catch (FileNotFoundException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

        frame.bShowFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                        System.out.print("Podaj nazwę pliku którego szukasz: ");
                        String fileNameToFind = scanner.next();
                        fileRepository.printFile(fileNameToFind + ".txt");
                    } catch (FileNotFoundException ex) {
                        System.out.println(ex.getMessage());
                    }
            }
        });

        frame.bExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        });


//        byte operationNumber;
//        do {
//            System.out.println("Witaj w programie do przepisów kulinarnych!!!");
//            System.out.println("1 - Wyświetl listę przepisów");
//            System.out.println("2 - Wyświetl przepis o konkretnym numerze ID");
//            System.out.println("3 - Dodaj nowy przepis");
//            System.out.println("4 - Usuń przepis z listy");
//            System.out.println("5 - Edytuj przepis z listy");
//            System.out.println("6 - Stwórz plik przepisu");
//            System.out.println("7 - Odczytaj plik przepisu");
//            System.out.println("9 - Zakończ działanie programu\n");
//            System.out.print("Wybierz co chcesz zrobić: ");
//            operationNumber = scanner.nextByte();
//
//            switch (operationNumber) {
//                case 1:
//                    try {
//                        listRepository.printRecipes();
//                    } catch (NullPointerException e) {
//                        System.out.println(e.getMessage());
//                    }
//                    break;
//                case 2:
//                    System.out.print("Podaj id przepisu do wyświetlenia: ");
//                    int idToGet = scanner.nextInt();
//                    try {
//                        listRepository.printRecipe(idToGet - 1);
//                    } catch (Exception e) {
//                        System.out.println(e.getMessage());
//                    }
//                    break;
//                case 3:
//                    try {
//                        listRepository.addRecipe();
//                    } catch (Exception e) {
//                        System.out.println(e.getMessage());
//                    }
//                    break;
//                case 4:
//                    System.out.print("Podaj id przepisu do usunięcia: ");
//                    int idToDelete = scanner.nextInt();
//                    try {
//                        listRepository.deleteRecipeByID(idToDelete - 1);
//                    } catch (Exception e) {
//                        System.out.println(e.getMessage());
//                    }
//                    break;
//                case 5:
//                    System.out.print("Podaj id przepisu do edycji: ");
//                    int idToEdit = scanner.nextInt();
//                    try {
//                        listRepository.editRecipeByID(idToEdit - 1);
//                    } catch (Exception e) {
//                        System.out.println(e.getMessage());
//                    }
//                    break;
//                case 6:
//                    try {
//                        fileRepository.addNewFile();
//                    } catch (FileNotFoundException e) {
//                        System.out.println(e.getMessage());
//                    }
//                    break;
//                case 7:
//                    try {
//                        System.out.print("Podaj nazwę pliku którego szukasz: ");
//                        String fileNameToFind = scanner.next();
//                        fileRepository.printFile(fileNameToFind + ".txt");
//                    } catch (FileNotFoundException e) {
//                        System.out.println(e.getMessage());
//                    }
//                    break;
//                case 9:
//                    System.out.println("Zakończyłeś pracę programu");
//                    break;
//                default:
//                    System.out.println("Podany numer operacji nie istnieje");
//            }
//        } while (operationNumber != 9);
    }
}