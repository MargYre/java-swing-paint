// src/gui/PaintGUI.java
/**
 * Main window of the paint application.
 * Manages the overall layout and coordinates DrawingPanel and PaintToolBar.
 */
package gui;
import javax.swing.JFrame;
import java.awt.BorderLayout;

public class PaintGUI {
    private final JFrame mainFrame;
    private final DrawingPanel drawingPanel;
    private final PaintToolBar toolBar;

    public PaintGUI() {
        mainFrame = new JFrame("Paint Application");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(800, 600);

        // Initialize components
        drawingPanel = new DrawingPanel();
        toolBar = new PaintToolBar(drawingPanel);

        // Layout setup
        mainFrame.add(toolBar, BorderLayout.NORTH);
        mainFrame.add(drawingPanel, BorderLayout.CENTER);
    }

    public void start() {
        mainFrame.setVisible(true);
    }
}