package gui;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

public class DrawingPanel extends JPanel {
    private Color currentColor = Color.BLACK; // Couleur actuelle
    private List<List<Point>> allDrawings = new ArrayList<>(); // Liste pour stocker tous les dessins
    private List<Point> currentDrawing = new ArrayList<>(); // Liste des points du dessin actuel

    public DrawingPanel() {
        setBackground(Color.WHITE);

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                currentDrawing.add(e.getPoint());
                repaint();
            }
        });

        // Add listener to start new drawing
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //when mouse is pressed, start a new drawing
                currentDrawing = new ArrayList<>();
                currentDrawing.add(e.getPoint());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //when mouse is released, save the drawing
                if (!currentDrawing.isEmpty()) {
                    allDrawings.add(new ArrayList<>(currentDrawing)); //save
                    currentDrawing.clear(); //clear for next drawing
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(currentColor);

        // Draw all drawings
        for (List<Point> drawing : allDrawings) {
            for (int i = 1; i < drawing.size(); i++) {
                Point p1 = drawing.get(i - 1);
                Point p2 = drawing.get(i);
                g.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }
        //draw current drawing
        for (int i = 1; i < currentDrawing.size(); i++) {
            Point p1 = currentDrawing.get(i - 1);
            Point p2 = currentDrawing.get(i);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }
    public void setCurrentColor(Color color) {
        this.currentColor = color;
    }
}
