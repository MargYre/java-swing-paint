// src/gui/DrawingPanel.java
/**
 * Main drawing area of the paint application.
 * Provides a white canvas and tracks the current drawing color.
 */
package gui;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

public class DrawingPanel extends JPanel {
    private Color currentColor = Color.BLACK;
    private List<Point> points = new ArrayList<>();

    public DrawingPanel() {
        setBackground(Color.WHITE);

        // Mouse event listeners
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                points.add(e.getPoint());
                repaint(); // Repaint the canvas
            }
        });
        //add new drawing point on mouse release
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                points.add(e.getPoint());
                // repaint(); Repaint the canvas
            }
        });
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(currentColor);

        // Draw all points
        for (int i = 1; i < points.size(); i++) {
            Point p1 = points.get(i - 1);
            Point p2 = points.get(i);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }
    public void setCurrentColor(Color color) {
        this.currentColor = color;
    }

    public Color getCurrentColor() {
        return currentColor;
    }
}