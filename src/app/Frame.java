package app;

import javax.swing.*;
import java.awt.*;


public class Frame extends JFrame {
    private static JFrame window;
    private static PaintPanel paintPanel;

    private void settings(){
        paintPanel = new PaintPanel();
        window = new JFrame("Physics");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(600,600);
        window.setResizable(false);
        window.setVisible(true);
        window.add(paintPanel);
    }

    public Frame() {
        settings();

    }


}
