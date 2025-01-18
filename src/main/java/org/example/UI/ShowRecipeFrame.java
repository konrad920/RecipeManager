package org.example.UI;

import org.example.DataAccess.FileRepository;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class ShowRecipeFrame extends JDialog {
    private FileRepository fileRepository;

    ShowRecipeFrame(FileRepository fileRepository){
        this.fileRepository = fileRepository;
        this.setTitle("Show Recipe");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\programy java\\RecipeManager\\img\\newRecipeIcon.jpg"));
        this.setBounds(800, 200, 300, 300);

        this.initComponents();
    }

    private void initComponents(){
        findingButton.addActionListener(new FindHandler());
        panelShow.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

        panelShow.add(titleFindingField);
        panelShow.add(findingButton);

        foundedRecipe.setEditable(false);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3,1));
        container.add(titleFindingLabel);
        container.add(panelShow);
        container.add(scrollPaneRecipe);
    }

    private JPanel panelShow = new JPanel();
    private JLabel titleFindingLabel = new JLabel("Podaj tytuł przepisu który chcesz wyświetlić:");
    private JTextField titleFindingField = new JTextField(6);
    private JButton findingButton = new JButton("Znajdź");
    private JTextArea foundedRecipe = new JTextArea("Tu pojawi sie znaleziony przepis", 10, 6);
    JScrollPane scrollPaneRecipe = new JScrollPane(foundedRecipe);

    private class FindHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String titleToFind = titleFindingField.getText() + ".txt";
                List<String> foundedFile = fileRepository.getFileToListString(titleToFind);
                StringBuilder fileStringBuilder = new StringBuilder();
                for(String line : foundedFile){
                    fileStringBuilder.append(line+"\n");
                }
                foundedRecipe.setText(fileStringBuilder.toString());
            } catch (FileNotFoundException ex) {
                ex.getMessage();
            }
        }
    }
}
