package org.example.UI;

import org.example.DataAccess.FileRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class NewRecipeFrame extends JFrame {
    private FileRepository fileRepository;

    public NewRecipeFrame(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
        this.setTitle("New Recipe");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\programy java\\RecipeManager\\img\\newRecipeIcon.jpg"));
        this.setBounds(800, 200, 300, 300);

        this.initComponents();
    }

    public void initComponents() {
        confirm.addActionListener(new ConfirmHandler());
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(rootPane, "Czy napewno zakończyłeś wprowadzanie nowego przepisu?", "Confirm NewRecipe",JOptionPane.YES_NO_OPTION);
                if(option == 0)
                {
                    NewRecipeFrame.this.dispose();
                }
            }
        });

        titleField.addKeyListener(new KeyHandler());
        descriptionArea.addKeyListener(new KeyHandler());
        timeToPrepareField.addKeyListener(new KeyHandler());

        GroupLayout layout = new GroupLayout(getContentPane());
        this.getContentPane().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(
                                layout.createParallelGroup()
                                        .addComponent(titleLabel)
                                        .addComponent(titleField)
                                        .addComponent(timeToPreparedLabel)
                                        .addComponent(timeToPrepareField)
                                        .addComponent(descriptionLabel)
                                        .addComponent(scrollPanel)
                                        .addComponent(confirm)
                        )
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addComponent(titleField)
                        .addGap(10, 20, Short.MAX_VALUE)
                        .addComponent(timeToPreparedLabel)
                        .addComponent(timeToPrepareField)
                        .addGap(10, 20, Short.MAX_VALUE)
                        .addComponent(descriptionLabel)
                        .addComponent(scrollPanel)
                        .addGap(10, 20, Short.MAX_VALUE)
                        .addComponent(confirm)
        );
        this.pack();
    }

    private JTextField titleField = new JTextField(10);
    private JTextField timeToPrepareField = new JTextField(10);
    private JTextArea descriptionArea = new JTextArea(10, 10);
    private JScrollPane scrollPanel = new JScrollPane(descriptionArea);
    private JButton confirm = new JButton("Zatwierdź");
    private JLabel titleLabel = new JLabel("Tytuł dania:");
    private JLabel timeToPreparedLabel = new JLabel("Czas potrzebny do przygotowania:");
    private JLabel descriptionLabel = new JLabel("Opis sposobu przygotowania:");

    public class ConfirmHandler extends WindowAdapter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String title = titleField.getText();
                isStringNull(title);
                double timeToPrepared = getTimeAsDouble(timeToPrepareField.getText());
                String description = descriptionArea.getText();
                fileRepository.addNewFileFromFrame(title, description, timeToPrepared);
            } catch (FileNotFoundException | NumberFormatException | NullPointerException ex) {
                System.out.println(ex.getMessage());
            }
            NewRecipeFrame.this.dispose();
        }

        private void isStringNull(String textToCheck) throws NullPointerException {
            if (textToCheck.isEmpty()) {
                String errorText = "Tytuł jest pusty";
                throw new NullPointerException(errorText);
            }
        }

        private double getTimeAsDouble(String timeAsString) throws NumberFormatException {
            double timeAsDouble = 0;
            try {
                timeAsDouble = Double.parseDouble(timeAsString);
            } catch (NumberFormatException ex) {
                String errorText = "To nie jest liczba zmiennoprzecinkowa";
                throw new NumberFormatException(errorText);
            }
            return timeAsDouble;
        }
    }

    private class KeyHandler extends KeyAdapter{
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_CONTROL && e.getKeyCode() == KeyEvent.VK_V){
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                DataFlavor flavor = DataFlavor.stringFlavor;
                String stringClipboard = "";

                try {
                    stringClipboard = (String) clipboard.getData(flavor);
                } catch (IOException ex) {
                    System.out.println("Wystąpił błąd na wejściu/wyjściu");;
                } catch (UnsupportedFlavorException ex) {
                    System.out.println("To nie jest String");;
                }
            }
        }
    }
}
