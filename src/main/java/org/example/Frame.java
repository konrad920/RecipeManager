package org.example;
import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame{
    public Frame(){
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Recipe Manager");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\programy java\\RecipeManager\\img\\icon.jpg"));
        this.setBounds(100, 50, 300, 100);
        //this.pack();
    }
}
