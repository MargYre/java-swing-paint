// src/PaintGUI.java
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import java.awt.*;

public class PaintGUI {
    private JFrame mainFrame;
    private JToolBar toolBar;
    private JPanel drawingPanel;

    public PaintGUI() {
        mainFrame = new JFrame("Paint Application");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(800, 600);
        //init toolBar
        toolBar = new JToolBar();
        initializeToolBar();
        //add toolBar to mainFrame
        mainFrame.add(toolBar, 0);

        //init drawing area
        drawingPanel = new JPanel();
        initializeDrawingPanel();
        //add
        mainFrame.add(toolBar, BorderLayout.NORTH);
        mainFrame.add(drawingPanel, BorderLayout.CENTER);
    }

    private void initializeToolBar() {
        JButton drawButton = new JButton("Draw");
        toolBar.add(drawButton);
        JButton eraseButton = new JButton("Erase");
        toolBar.add(eraseButton);
        toolBar.addSeparator();
    }
    private void initializeDrawingPanel() {
        drawingPanel.setBackground(Color.WHITE);
    }
    public void start() {
        mainFrame.setVisible(true);
    }
}