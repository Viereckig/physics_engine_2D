package app;

import app.forces.Move;
import app.obstacles.Box;
import app.obstacles.Obstacle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static app.forces.Move.getMove;

public class PaintPanel extends JPanel {
    private Image background;
    private Graphics graphics;
    private static List<Obstacle> obstacles;
    private volatile boolean running;
    private long lastUpdateTime;

    public PaintPanel() {

        obstacles = new ArrayList<>();

        //----------------------Forces---------------------//
        Move.addForce(9.81, 180);

        //--------------------Obstacles--------------------//
        addWall();
        obstacles.add(new Box(100, 200, 50, 50, Color.BLUE, false));

        //-----------------------Thread---------------------//
        running = true;
        Thread gameThread = new Thread(new Updater());
        gameThread.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        background = createImage(this.getWidth(), this.getHeight());
        graphics = background.getGraphics();
        g.drawImage(background, 0, 0, this);

        for (Obstacle obstacle : obstacles) {
            obstacle.draw(g);
        }
    }

    private void addWall() {
        obstacles.add(new Box(0, 0, this.getWidth(), 1, Color.BLACK, true)); // Obere Wand
        obstacles.add(new Box(0, this.getHeight(), this.getWidth(), 1, Color.BLACK, true)); // Untere Wand
        obstacles.add(new Box(0, 0, 1, this.getHeight(), Color.BLACK, true)); // Linke Wand
        obstacles.add(new Box(this.getWidth(), 0, 1, this.getHeight(), Color.BLACK, true)); // Rechte Wand
    }

    public static List<Obstacle> getObstacles() {
        return obstacles;
    }

    private class Updater implements Runnable {
        public void run() {
            lastUpdateTime = System.nanoTime();
            while (running) {
                long currentTime = System.nanoTime();
                double deltaTime = (currentTime - lastUpdateTime) / 1e9;
                lastUpdateTime = currentTime;

                getMove().consistentForces(deltaTime);
                repaint();

                Thread.yield();
            }
        }
    }

}
