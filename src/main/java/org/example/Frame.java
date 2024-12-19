package org.example;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame() {
        //podstawowe ustawienia ramki
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Recipe Manager");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\programy java\\RecipeManager\\img\\icon.jpg"));

        //centrowanie ramki
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setSize(screenWidth / 2, screenHeight / 2);
        int frameWidht = this.getSize().width;
        int frameHeight = this.getSize().height;
        this.setLocation((screenWidth - frameWidht) / 2, (screenHeight - frameHeight) / 2);

        this.initComponents();
    }

    public void initComponents(){
        GroupLayout layout = new GroupLayout(getContentPane());
        this.getContentPane().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addComponent(button1)
                        .addGroup(
                                layout.createParallelGroup().addComponent(button2).addComponent(button4)
                        )
                        .addComponent(button3)
                        .addGap(10, 20,Short.MAX_VALUE)
                        .addComponent(banuluj)
                );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(
                                layout.createParallelGroup().addComponent(button1).addComponent(button2).addComponent(button3)
                        )
                        .addComponent(button4)
                        .addGap(10, 20,Short.MAX_VALUE)
                        .addComponent(banuluj)
        );

        this.pack();
    }

    JButton button1 = new JButton("butto1");
    JButton button2 = new JButton("butto2");
    JButton button3 = new JButton("butto3");
    JButton button4 = new JButton("butto4");
    JButton banuluj = new JButton("Anuluj");

//    public void initComponents(){
//        ok = new JButton("Ok");
//        anuluj = new JButton("Anuluj");
//
//        Container buttons = this.getContentPane();
//        ok.setPreferredSize(ok.getPreferredSize());
//        anuluj.setPreferredSize(anuluj.getPreferredSize());
//
//        panel1.add(ok);
//        panel1.add(anuluj);
//
//        //this.getContentPane().add(ok, BorderLayout.LINE_START);
//        buttons.add(panel1, BorderLayout.LINE_START);
//        //buttons.add(anuluj, BorderLayout.LINE_END);
//        this.pack();
//    }
//
//    JPanel panel1 = new JPanel();
//    JButton ok;
//    JButton anuluj;
}
