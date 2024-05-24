package app.obstacles;

import java.awt.*;
import java.util.List;

public interface Obstacle {
    public void draw(Graphics g);
    public List<Double> getCoordinates();
    public List<Integer> getSize();
    public void setCoordinates(Double x, Double y);
    public void setColor(Color color);
    public Boolean isFixed();
    public void addX(Double x);
    public void addY(Double y);
    public double getXVelocity();
    public double getYVelocity();
    public void setVelocity(Double xVelocity, Double yVelocity);
    public Boolean isCollidingWithObstacle(Obstacle obstacle);


}
