// src/gui/DrawingPanel.java
/**
 * Main drawing area of the paint application.
 * Provides a white canvas and tracks the current drawing color.
 */
package gui;
import javax.swing.JPanel;
import java.awt.Color;

public class DrawingPanel extends JPanel {
    private Color currentColor = Color.BLACK;

    public DrawingPanel() {
        setBackground(Color.WHITE);
    }

    public void setCurrentColor(Color color) {
        this.currentColor = color;
    }

    public Color getCurrentColor() {
        return currentColor;
    }
}