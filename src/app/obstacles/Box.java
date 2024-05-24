package app.obstacles;

import app.Frame;

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
        this.color = color;
        this.xVelocity = 0.0;
        this.yVelocity = 0.0;
    }


    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillRect((int) Math.round(this.x * Frame.getMeterToPixel()), (int) Math.round(this.y * Frame.getMeterToPixel()), this.width * Frame.getMeterToPixel(), this.height * Frame.getMeterToPixel());
    }

    public List<Double> getCoordinates() {
        List<Double> coordinates = new ArrayList<>();
        coordinates.add(x);
        coordinates.add(y);
        return coordinates;
    }


    public List<Integer> getSize() {
        List<Integer> size = new ArrayList<>();
        size.add(width);
        size.add(height);
        return size;
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

    public Boolean isCollidingWithObstacle(Obstacle obstacle) {
        Double x,y;
        int width, height;

        x = obstacle.getCoordinates().get(0);
        y = obstacle.getCoordinates().get(1);
        width = obstacle.getSize().get(0);
        height = obstacle.getSize().get(1);

        return this.x < x + width
                && this.x + this.width > x
                && this.y < y + height
                && this.y + this.height > y;

    }
}
