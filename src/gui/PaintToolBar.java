// src/gui/PaintToolBar.java
/**
 * Toolbar containing drawing tools and color controls.
 * Includes draw/erase buttons, color chooser, and current color display.
 */package gui;

import javax.swing.*;
import java.awt.*;

public class PaintToolBar extends JToolBar {
    private final JPanel colorIndicator = new JPanel();
    private Color currentColor = Color.BLACK;
    private final DrawingPanel drawingPanel;

    public PaintToolBar(DrawingPanel drawingPanel) {
        this.drawingPanel = drawingPanel;
        initializeComponents();
    }

    private void initializeComponents() {
        // Boutons de base
        add(new JButton("Draw"));
        add(new JButton("Erase"));
        
        // Bouton de couleur
        JButton colorButton = new JButton("Choose Color");
        colorButton.addActionListener(e -> {
            Color chosenColor = JColorChooser.showDialog(this, "Choose a Color", currentColor);
            if (chosenColor != null) {
                currentColor = chosenColor;
                updateColorIndicator();
                drawingPanel.setCurrentColor(currentColor);
            }
        });
        add(colorButton);

        // Configuration de l'indicateur de couleur
        colorIndicator.setPreferredSize(new Dimension(30, 30));
        colorIndicator.setMinimumSize(new Dimension(10, 10));
        colorIndicator.setMaximumSize(new Dimension(10, 10));
        colorIndicator.setBackground(currentColor);
        colorIndicator.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        add(Box.createHorizontalGlue());
        add(colorIndicator);
        add(Box.createHorizontalGlue());
        addSeparator();
    }

    private void updateColorIndicator() {
        colorIndicator.setBackground(currentColor);
    }
    public interface ColorChangeListener {
        void onColorChange(Color newColor);
    }
}