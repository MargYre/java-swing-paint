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
     private ShapeType currentShape = ShapeType.FREEHAND;
     
     private class Drawing {
         List<Point> points;
         ShapeType type;
         
         Drawing(List<Point> points, ShapeType type) {
             this.points = points;
             this.type = type;
         }
     }
     
     private List<Drawing> allDrawings = new ArrayList<>();
     private List<Point> currentDrawing = new ArrayList<>();
     private Point startPoint;
     private Point endPoint;
 
     public DrawingPanel() {
         setBackground(Color.WHITE);
         setPreferredSize(new Dimension(800, 600));
 
         addMouseMotionListener(new MouseMotionAdapter() {
             @Override
             public void mouseDragged(MouseEvent e) {
                 if (currentShape == ShapeType.FREEHAND) {
                     currentDrawing.add(e.getPoint());
                 } else {
                     endPoint = e.getPoint();
                 }
                 repaint();
             }
         });
 
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                 startPoint = e.getPoint();
                 if (currentShape == ShapeType.FREEHAND) {
                     currentDrawing = new ArrayList<>();
                     currentDrawing.add(startPoint);
                 }
            }
 
             @Override
             public void mouseReleased(MouseEvent e) {
                 if (currentShape == ShapeType.FREEHAND) {
                     if (!currentDrawing.isEmpty()) {
                         allDrawings.add(new Drawing(new ArrayList<>(currentDrawing), ShapeType.FREEHAND));
                         currentDrawing.clear();
                     }
                 } else {
                     List<Point> shape = new ArrayList<>();
                     shape.add(startPoint);
                     shape.add(endPoint);
                     allDrawings.add(new Drawing(shape, currentShape));
                 }
                 startPoint = null;
                 endPoint = null;
                 repaint();
             }
         });
     }
 
     @Override
     protected void paintComponent(Graphics g) {
         super.paintComponent(g);
         Graphics2D g2d = (Graphics2D) g;
         g2d.setColor(currentColor);
 
         // Draw completed shapes
         for (Drawing drawing : allDrawings) {
             if (drawing.type == ShapeType.FREEHAND) {
                 for (int i = 1; i < drawing.points.size(); i++) {
                     Point p1 = drawing.points.get(i - 1);
                     Point p2 = drawing.points.get(i);
                     g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
                 }
             } else {
                 drawShape(g2d, drawing.points.get(0), drawing.points.get(1), drawing.type);
             }
         }
         // Draw current shape
         if (startPoint != null && endPoint != null && currentShape != ShapeType.FREEHAND) {
             drawShape(g2d, startPoint, endPoint, currentShape);
         }
 
         // Draw current freehand drawing
         if (currentShape == ShapeType.FREEHAND) {
             for (int i = 1; i < currentDrawing.size(); i++) {
                 Point p1 = currentDrawing.get(i - 1);
                 Point p2 = currentDrawing.get(i);
                 g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
             }
         }
     }
 
     private void drawShape(Graphics2D g2d, Point start, Point end, ShapeType type) {
         int x = Math.min(start.x, end.x);
         int y = Math.min(start.y, end.y);
         int width = Math.abs(end.x - start.x);
         int height = Math.abs(end.y - start.y);
 
         switch (type) {
             case RECTANGLE:
                 g2d.drawRect(x, y, width, height);
                 break;
             case OVAL:
                 g2d.drawOval(x, y, width, height);
                 break;
             case TRIANGLE:
                 int[] xPoints = {start.x, end.x, start.x};
                 int[] yPoints = {start.y, end.y, end.y};
                 g2d.drawPolygon(xPoints, yPoints, 3);
                 break;
         }
     }
 
     public void setCurrentColor(Color color) {
         this.currentColor = color;
     }
     public void setCurrentShape(ShapeType shapeType) {
         this.currentShape = shapeType;
     }
     public void clearAll() {
        allDrawings.clear();
        currentDrawing.clear();
        startPoint = null;
        endPoint = null;
        repaint();
    }
 }