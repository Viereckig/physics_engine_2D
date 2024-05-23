package app.obstacles;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Box implements Obstacle{
    private Double x,y;
    private Color color;
    private int width, height;
    private Boolean fixed;

    private Double xVelocity, yVelocity;

    public Box(int x, int y, int width, int height, Color color, Boolean fixed){
        this.x = (double) x;
        this.y = (double) y;
        this.width = width;
        this.height = height;
        this.fixed = fixed;
        this.xVelocity = 0.0;
        this.yVelocity = 0.0;
    }


    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillRect((int) Math.round(this.x), (int) Math.round(this.y), this.width, this.height);
    }

    public List<Double> getCoordinates() {
        List<Double> coordinates = new ArrayList<>();
        coordinates.add(x);
        coordinates.add(y);
        return coordinates;
    }

    public void setCoordinates(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public void addX(Double x) {
        this.x += x;
    }

    public void addY(Double y) {
        this.y += y;
    }

    public double getXVelocity() {
        return this.xVelocity;
    }

    public double getYVelocity() {
        return this.yVelocity;
    }

    public void setVelocity(Double xVelocity, Double yVelocity) {
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
    }


    public void setColor(Color color){
        this.color = color;
    }

    public Boolean isFixed() {
        return fixed;
    }
}
