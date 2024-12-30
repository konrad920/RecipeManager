package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

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

    public void initComponents() {
        panel.add(timer);
        panel.add(time);
        ActionListener timer = new TimeListener();
        Timer clock = new Timer(1000, timer);
        clock.start();

        GroupLayout layout = new GroupLayout(getContentPane());
        this.getContentPane().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(
                                layout.createParallelGroup().addComponent(bNewFile).addComponent(bShowFile)
                        ).addGroup(
                                layout.createParallelGroup().addComponent(bEditRecipe).addComponent(bDeleteRecipe)
                        ).addGap(10, 20, Short.MAX_VALUE)
                        .addComponent(panel)
                        .addComponent(bExit)
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(panel)
                        .addGroup(
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

    JButton bNewFile = new JButton("Add New Recipe");
    JButton bShowFile = new JButton("Show Recipe");
    JButton bEditRecipe = new JButton("Edit Recipe");
    JButton bDeleteRecipe = new JButton("Delete Recipe");
    JButton bExit = new JButton("Exit");

    private class TimeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            time.setText(getTime());
        }
    }

    private String getTime(){
        GregorianCalendar calendar = new GregorianCalendar();
        String h = ""+calendar.get(Calendar.HOUR_OF_DAY);
        String min = ""+calendar.get(Calendar.MINUTE);
        String sec = ""+calendar.get(Calendar.SECOND);

        if(Integer.parseInt(h) < 10)
            h = "0" + h;
        if(Integer.parseInt(min) < 10)
            min = "0" + min;
        if(Integer.parseInt(sec) < 10)
            sec = "0" + sec;

        return h + " : " + min + " : " + sec;
    }

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
