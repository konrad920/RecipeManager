package RecipeManager;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        /*
         * Create frame with dimensions and default options
         * Centralize this frame on the screen
         */
        int width = getToolkit().getScreenSize().width;
        int height = getToolkit().getScreenSize().height;

        this.setSize(width / 3, height / 2);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setIconImage(getToolkit().getImage("img\\recipes.png"));
        this.setTitle("Recipe Manager");

        int widthFrame = this.getWidth();
        int heightFrame = this.getHeight();

        this.setLocation((width - widthFrame) / 2, (height - heightFrame) / 2);

        initComponent();
        this.pack();
    }

    JButton newRecipe;
    JButton findRecipe;

    public void initComponent() {
        Container container = this.getContentPane();

        newRecipe = new JButton("Nowy Przepis");
        findRecipe = new JButton("Znajdź Przepis");

        container.add(newRecipe, BorderLayout.PAGE_START);
        container.add(findRecipe, BorderLayout.PAGE_END);
        //ustawianie lokacji przycisku recznie jeśli mamy włączony layout to to nie zadziałą
        //newRecipe.setLocation(100, 20);
        //newRecipe.setSize(50,30);
        //container.setLayout(null);
    }

    public void srart() {
        new MainFrame().setVisible(true);
    }
}
