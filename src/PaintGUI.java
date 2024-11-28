// src/PaintGUI.java
import javax.swing.JFrame;

public class PaintGUI {
    private JFrame mainFrame;

    public PaintGUI() {
        mainFrame = new JFrame("Paint Application");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(800, 600);
    }

    public void start() {
        mainFrame.setVisible(true);
    }
}