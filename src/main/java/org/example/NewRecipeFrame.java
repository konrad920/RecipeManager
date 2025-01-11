package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class NewRecipeFrame extends JDialog {
    private ConsoleLogger consoleLogger = new ConsoleLogger();
    private FileRepository fileRepository = new FileRepository(consoleLogger);

    public NewRecipeFrame(){
        this.setTitle("New recipe");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setBounds(800, 200, 300, 300);

        this.initComponents();
    }

    public void initComponents(){

        confirm.addActionListener(new ConfirmHandler());

        GroupLayout layout = new GroupLayout(getContentPane());
        this.getContentPane().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(
                                layout.createParallelGroup().addComponent(titleField).addComponent(timeToPrepareField).addComponent(descriptionField).addComponent(confirm)
                        )
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(titleField)
                        .addGap(10, 20, Short.MAX_VALUE)
                        .addComponent(timeToPrepareField)
                        .addGap(10, 20, Short.MAX_VALUE)
                        .addComponent(descriptionField)
                        .addGap(10, 20, Short.MAX_VALUE)
                        .addComponent(confirm)
        );

        this.pack();
    }

    public class ConfirmHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String title= titleField.getText();
            double timeToPrepared = getTimeAsDouble(timeToPrepareField.getText());
            String description = descriptionField.getText();
            try {
                    fileRepository.addNewFileFromFrame(title, description, timeToPrepared);
                } catch (FileNotFoundException ex) {
                    System.out.println(ex.getMessage());
                }
        }

        private double getTimeAsDouble(String timeAsString){
            return  Double.parseDouble(timeAsString);
        }
    }

    private JTextField titleField = new JTextField(10);
    private JTextField timeToPrepareField = new JTextField(10);
    private  JTextArea descriptionField = new JTextArea(10,10);
    private JButton confirm = new JButton("Zatwierdź");

}
