package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Frame extends JFrame {

    public Frame() {
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setTitle("Recipe Manager");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\programy java\\RecipeManager\\img\\icon.jpg"));

        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setSize(screenWidth / 2, screenHeight / 2);
        int frameWidht = this.getSize().width;
        int frameHeight = this.getSize().height;
        this.setLocation((screenWidth - frameWidht) / 2, (screenHeight - frameHeight) / 2);

        this.initComponents();
    }

    public void initComponents() {
        looksOption.addItem("Metal");
        looksOption.addItem("Windows");
        looksOption.addActionListener(new LooksHandler());

        panel.add(timer);
        panel.add(time);
        ActionListener timer = new TimeListener();
        Timer clock = new Timer(1000, timer);
        clock.start();

        bNewFile.addActionListener(new NewRecipeHandler());
        bExit.addActionListener(new ExitHandler());
        this.addWindowListener(new ExitHandler());

        GroupLayout layout = new GroupLayout(getContentPane());
        this.getContentPane().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(
                                layout.createParallelGroup().addComponent(panel).addComponent(bNewFile).addComponent(bShowFile)
                        ).addGroup(
                                layout.createParallelGroup().addComponent(bEditRecipe).addComponent(bDeleteRecipe)
                        ).addGap(10, 20, Short.MAX_VALUE)
                        .addGroup(
                                layout.createParallelGroup().addComponent(looksOption).addComponent(bExit)
                        )
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(
                                layout.createParallelGroup().addComponent(panel).addComponent(looksOption)
                        ).addGroup(
                                layout.createParallelGroup().addComponent(bNewFile).addComponent(bEditRecipe)
                        ).addGroup(
                                layout.createParallelGroup().addComponent(bShowFile).addComponent(bDeleteRecipe)
                        ).addGap(10, 20, Short.MAX_VALUE)
                        .addComponent(bExit)
        );

        this.pack();
    }

    JPanel panel = new JPanel();
    JLabel timer = new JLabel("Clock: ");
    JLabel time = new JLabel(getTime());

    JComboBox looksOption = new JComboBox();

    JButton bNewFile = new JButton("Add New Recipe");
    JButton bShowFile = new JButton("Show Recipe");
    JButton bEditRecipe = new JButton("Edit Recipe");
    JButton bDeleteRecipe = new JButton("Delete Recipe");
    JButton bExit = new JButton("Exit");

    private class NewRecipeHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            NewRecipeFrame recipeFrame = new NewRecipeFrame();
            recipeFrame.setVisible(true);
        }
    }

    private class ExitHandler extends WindowAdapter implements ActionListener {

        @Override
        public void windowClosing(WindowEvent e) {
            int option = JOptionPane.showConfirmDialog(rootPane, "Czy napewno chcesz zamknąć program?", "Exit confirmation", JOptionPane.YES_NO_OPTION);
            if (option == 0)
                System.exit(0);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int option = JOptionPane.showConfirmDialog(rootPane, "Czy napewno chcesz zamknąć program?", "Exit confirmation", JOptionPane.YES_NO_OPTION);
            if (option == 0)
                System.exit(0);
        }
    }

    private class LooksHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String looksName = "";
            if(((JComboBox)e.getSource()).getSelectedItem().equals("Metal"))
                looksName = "javax.swing.plaf.metal.MetalLookAndFeel";
            else if(((JComboBox)e.getSource()).getSelectedItem().equals("Windows"))
                looksName = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";

            try {
                UIManager.setLookAndFeel(looksName);
            } catch (ClassNotFoundException ex) {
                ex.getMessage();
            } catch (InstantiationException ex) {
                ex.getMessage();
            } catch (IllegalAccessException ex) {
                ex.getMessage();
            } catch (UnsupportedLookAndFeelException ex) {
                ex.getMessage();
            }
        }
    }

    private class TimeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            time.setText(getTime());
        }
    }

    private String getTime() {
        GregorianCalendar calendar = new GregorianCalendar();
        String h = "" + calendar.get(Calendar.HOUR_OF_DAY);
        String min = "" + calendar.get(Calendar.MINUTE);
        String sec = "" + calendar.get(Calendar.SECOND);

        if (Integer.parseInt(h) < 10)
            h = "0" + h;
        if (Integer.parseInt(min) < 10)
            min = "0" + min;
        if (Integer.parseInt(sec) < 10)
            sec = "0" + sec;

        return h + " : " + min + " : " + sec;
    }
}
