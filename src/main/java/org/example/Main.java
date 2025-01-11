package org.example;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner scanner = new Scanner(System.in);
        //ConsoleLogger consoleLogger = new ConsoleLogger();
        //ListRepository listRepository = new ListRepository(consoleLogger);
        //FileRepository fileRepository = new FileRepository(consoleLogger);
        Frame frame = new Frame();
        frame.setVisible(true);

//        frame.bNewFile.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    fileRepository.addNewFile();
//                } catch (FileNotFoundException ex) {
//                    System.out.println(ex.getMessage());
//                }
//            }
//        });
//
//        frame.bShowFile.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                        System.out.print("Podaj nazwę pliku którego szukasz: ");
//                        String fileNameToFind = scanner.next();
//                        fileRepository.printFile(fileNameToFind + ".txt");
//                    } catch (FileNotFoundException ex) {
//                        System.out.println(ex.getMessage());
//                    }
//            }
//        });
//
//        frame.bExit.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//            }
//        });
    }
}