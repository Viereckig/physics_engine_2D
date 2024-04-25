import obstacles.Box;
import obstacles.Obstacle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Frame extends JFrame {
    private Image background;
    private Graphics graphics;
    private List<Obstacle> obstacles;

    private void settings(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);
        this.setVisible(true);
    }

    public Frame() {
        settings();

        obstacles = new ArrayList<>();
        obstacles.add(new Box(100, 200, 50,50, Color.BLUE));

    }

    public void paint(Graphics g){
        background = createImage(this.getWidth(), this.getHeight());
        graphics = background.getGraphics();
        g.drawImage(background,0,0,this);

        for(Obstacle obstacle : obstacles){
            obstacle.draw(g);
        }
    }


}
