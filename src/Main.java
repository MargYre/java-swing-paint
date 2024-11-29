// Main.java

import gui.PaintGUI;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PaintGUI gui = new PaintGUI();
            gui.start();
        });
    }
}