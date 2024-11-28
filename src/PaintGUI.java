// src/PaintGUI.java
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaintGUI {
    private JFrame mainFrame;
    private JToolBar toolBar;
    private JPanel drawingPanel;
    private Color currentColor = Color.BLACK;

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
        //color button
         // Bouton pour sélectionner la couleur
        JButton colorButton = new JButton("Choose Color");
        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ouvrir la boîte de dialogue de sélection de couleur
                Color chosenColor = JColorChooser.showDialog(mainFrame, "Choose a Color", currentColor);
                if (chosenColor != null) {
                    currentColor = chosenColor; // Met à jour la couleur actuelle
                }
            }
        });
        toolBar.add(colorButton);

        toolBar.addSeparator();
    }
    private void initializeDrawingPanel() {
        drawingPanel.setBackground(Color.WHITE);
    }
    public void start() {
        mainFrame.setVisible(true);
    }
}