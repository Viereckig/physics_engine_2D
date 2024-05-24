package app;

import javax.swing.*;
import java.awt.*;


public class Frame extends JFrame {
    private static JFrame window;
    private static PaintPanel paintPanel;
    private static int meterToPixel = 10;

    private void settings(){
        window = new JFrame("Physics");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(600,600);
        window.setResizable(false);

        paintPanel = new PaintPanel();
        window.add(paintPanel);

        window.setVisible(true);
        paintPanel.repaint();
    }

    public Frame() {
        settings();

    }

    public static int getMeterToPixel() {
        return meterToPixel;
    }

    public static JFrame getWindow() {
        return window;
    }
}
