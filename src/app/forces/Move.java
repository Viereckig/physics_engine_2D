package app.forces;

import app.PaintPanel;
import app.obstacles.Obstacle;

import java.util.ArrayList;
import java.util.List;

public class Move {
    private static Move move;
    private Move() {}
    private static List<Double> forces = new ArrayList<>();
    private static List<Double> forceDirections = new ArrayList<>();

    public void consistentForces(double deltaTime){
        List<Obstacle> allObstacles =  PaintPanel.getObstacles();
        List<Obstacle> obstacles = allObstacles.stream()
                .filter(obstacle -> !obstacle.isFixed()).toList();



        for(Obstacle obstacle : obstacles){
            double xForce = 0;
            double yForce = 0;

            for(int i = 0; i<forces.size(); i++){
                double[] forceComponents = calculateForceComponents(forces.get(i), forceDirections.get(i));
                xForce += forceComponents[0];
                yForce += forceComponents[1];;
            }
            obstacle.addX((int) Math.round(xForce));
            obstacle.addY((int) Math.round(yForce));
            System.out.println(obstacle.getCoordinates());
        }
    }

    public static double[] calculateForceComponents(double force, double forceDirection) {
        double radians = Math.toRadians(forceDirection);

        double forceX = force * Math.cos(radians);
        double forceY = force * Math.sin(radians);

        return new double[]{forceX, forceY};
    }




    public static Move getMove(){
        if(move == null)
            move = new Move();

        return move;
    }

    public static void addForce(double force, double forceDirection){
        forces.add(force);
        forceDirections.add(forceDirection-90);
    }
}
