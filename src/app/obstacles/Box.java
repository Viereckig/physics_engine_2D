package app.obstacles;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Box implements Obstacle{
    private int x,y;
    private Color color;
    private int width, height;
    private Boolean fixed;

    private Double xVelocity, yVelocity;

    public Box(int x, int y, int width, int height, Color color, Boolean fixed){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.fixed = fixed;
    }


    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillRect(this.x, this.y, this.width, this.height);
    }

    public List<Integer> getCoordinates() {
        List<Integer> coordinates = new ArrayList<>();
        coordinates.add(x);
        coordinates.add(y);
        return coordinates;
    }

    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void addX(int x) {
        this.x += x;
    }

    public void addY(int y) {
        this.y += y;
    }

    public double getXVelocity() {
        return this.xVelocity;
    }

    public double getYVelocity() {
        return this.yVelocity;
    }

    public void setXVelocity(Double xVelocity) {
        this.xVelocity = xVelocity;
    }

    public void setYVelocity(Double yVelocity) {
        this.yVelocity = yVelocity;
    }


    public void setColor(Color color){
        this.color = color;
    }

    public Boolean isFixed() {
        return fixed;
    }
}
