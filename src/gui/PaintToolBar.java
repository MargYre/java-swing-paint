// src/gui/PaintToolBar.java
/**
 * Toolbar containing drawing tools and color controls.
 * Includes draw/erase buttons, color chooser, and current color display.
 */

 package gui;

import javax.swing.*;
import java.awt.*;

public class PaintToolBar extends JToolBar {
    private final JPanel colorIndicator = new JPanel();
    private Color currentColor = Color.BLACK;
    private final DrawingPanel drawingPanel;
    private ButtonGroup shapeButtons;

    public PaintToolBar(DrawingPanel drawingPanel) {
        this.drawingPanel = drawingPanel;
        initializeComponents();
    }

    private void initializeComponents() {
        // Shape buttons
        shapeButtons = new ButtonGroup();
        addShapeButton("Freehand", ShapeType.FREEHAND);
        addShapeButton("Rectangle", ShapeType.RECTANGLE);
        addShapeButton("Oval", ShapeType.OVAL);
        addShapeButton("Triangle", ShapeType.TRIANGLE);
        addSeparator();
        JButton clearButton = new JButton("Clear All");
        clearButton.addActionListener(e -> drawingPanel.clearAll());
        add(clearButton);

        // Color chooser
        JButton colorButton = new JButton("Color");
        colorButton.addActionListener(e -> {
            Color chosenColor = JColorChooser.showDialog(this, "Choose Color", currentColor);
            if (chosenColor != null) {
                currentColor = chosenColor;
                colorIndicator.setBackground(currentColor);
                drawingPanel.setCurrentColor(currentColor);
            }
        });
        add(colorButton);

        // Color indicator
        colorIndicator.setPreferredSize(new Dimension(30, 30));
        colorIndicator.setBackground(currentColor);
        colorIndicator.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(colorIndicator);
    }

    private void addShapeButton(String name, ShapeType shapeType) {
        JToggleButton button = new JToggleButton(name);
        button.addActionListener(e -> drawingPanel.setCurrentShape(shapeType));
        shapeButtons.add(button);
        add(button);
    }
}