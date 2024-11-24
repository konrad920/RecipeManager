import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    Main() {
        /*
        create frame manually in constructor but we can extend class JFrame by class Main() and use methods from the class JFrame
        JFrame frame = new JFrame();
        frame.setTitle("Recipe Manager");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(300,100);
//        frame.setSize(new Dimension(100, 100));
        frame.setLocation(100, 200);
//        frame.setLocation(new Point(100, 200));
        frame.setResizable(true);
         */

        this.setBounds(100, 200, 300, 100);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setIconImage(getToolkit().getImage("img\\recipes.png"));
        this.setTitle("Recipe Manager");
    }
    public static void main(String[] args) {
        new Main();
    }
}