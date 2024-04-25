package obstacles;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Box implements Obstacle{
    private int x,y;
    private Color color;
    private int width, height;

    public Box(int x, int y, int width, int height, Color color){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
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

    public void setColor(Color color){
        this.color = color;
    }

}
