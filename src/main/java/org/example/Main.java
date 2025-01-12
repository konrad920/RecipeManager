package org.example;

import org.example.Components.ConsoleLogger;
import org.example.DataAccess.FileRepository;
import org.example.UI.Frame;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Frame frame = new Frame();
        frame.setVisible(true);
//        ConsoleLogger consoleLogger = new ConsoleLogger();
//        FileRepository fileRepository = new FileRepository(consoleLogger);
//        Scanner scanner = new Scanner(System.in);

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
    }
}