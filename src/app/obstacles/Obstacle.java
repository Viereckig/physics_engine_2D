package app.obstacles;

import java.awt.*;
import java.util.List;

public interface Obstacle {
    public void draw(Graphics g);
    public List<Integer> getCoordinates();
    public void setCoordinates(int x, int y);
    public void setColor(Color color);
    public Boolean isFixed();
    public void addX(int x);
    public void addY(int y);
    public double getXVelocity();
    public double getYVelocity();
    public void setXVelocity(Double xVelocity);
    public void setYVelocity(Double yVelocity);

}
