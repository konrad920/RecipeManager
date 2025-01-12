package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class NewRecipeFrame extends JDialog {
    private ConsoleLogger consoleLogger = new ConsoleLogger();
    private FileRepository fileRepository = new FileRepository(consoleLogger);

    public NewRecipeFrame() {
        this.setTitle("New recipe");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setBounds(800, 200, 300, 300);

        this.initComponents();
    }

    public void initComponents() {

        confirm.addActionListener(new ConfirmHandler());

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
                                        .addComponent(descriptionField)
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
                        .addComponent(descriptionField)
                        .addGap(10, 20, Short.MAX_VALUE)
                        .addComponent(confirm)
        );

        this.pack();
    }

    private JTextField titleField = new JTextField(10);
    private JTextField timeToPrepareField = new JTextField(10);
    private JTextArea descriptionField = new JTextArea(10, 10);
    private JButton confirm = new JButton("Zatwierdź");
    private JLabel titleLabel = new JLabel("Tytuł dania:");
    private JLabel timeToPreparedLabel = new JLabel("Czas potrzebny do przygotowania:");
    private JLabel descriptionLabel = new JLabel("Opis sposobu przygotowania:");

    public class ConfirmHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String title = titleField.getText();
                isStringNull(title);
                double timeToPrepared = getTimeAsDouble(timeToPrepareField.getText());
                String description = descriptionField.getText();
                fileRepository.addNewFileFromFrame(title, description, timeToPrepared);
            } catch (FileNotFoundException | NumberFormatException | NullPointerException ex) {
                System.out.println(ex.getMessage());
            }
//            }catch (FileNotFoundException ex) {
//                System.out.println(ex.getMessage());
//            }catch (NumberFormatException ex){
//                System.out.println(ex.getMessage());
//            }catch (NullPointerException ex){
//                System.out.println(ex.getMessage());
//            }
        }

        private void isStringNull(String textToCheck) throws NullPointerException{
            if(textToCheck.isEmpty()){
                String errorText = "Tytuł jest pusty";
                throw new NullPointerException(errorText);
            }
        }

        private double getTimeAsDouble(String timeAsString) throws NumberFormatException {
            double timeAsDouble = 0;
            try{
                timeAsDouble = Double.parseDouble(timeAsString);
            }catch (NumberFormatException ex){
                String errorText = "Zły format do zapisu pliku";
                throw new NumberFormatException(errorText);
            }
            return timeAsDouble;
        }
    }
}
