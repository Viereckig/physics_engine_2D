package obstacles;

import java.awt.*;
import java.util.List;

public interface Obstacle {
    public void draw(Graphics g);
    public List<Integer> getCoordinates();
    public void setCoordinates(int x, int y);
    public void setColor(Color color);

}
