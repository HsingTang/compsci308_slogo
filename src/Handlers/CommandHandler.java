package Handlers;

import Handlers.HandlerInterfaces.CommandHandlerInterface;
import Model.ModelInterfaces.TurtleModelInterface;
import Model.VariablePaneModel;

import java.util.HashMap;
import java.util.HashSet;

public class CommandHandler implements CommandHandlerInterface {
    final TurtleModelInterface turtleModel;
    final VariablePaneModel varModel;

    public CommandHandler(TurtleModelInterface turtleModel, VariablePaneModel varModel) {
        this.turtleModel = turtleModel;
        this.varModel = varModel;
    }

    public double moveForward(double px) {
        double heading = Math.toRadians(turtleModel.getHeading());
        turtleModel.setX(turtleModel.getX() + px*Math.cos(heading));
        turtleModel.setY(turtleModel.getY() - px*Math.sin(heading));
        turtleModel.moveWithAnimation();
        System.out.println("forward " + px);
        return px;
    }

    public double moveBackwards(double px) {
        double heading = Math.toRadians(turtleModel.getHeading());
        turtleModel.setX(turtleModel.getX() - px*Math.cos(heading));
        turtleModel.setY(turtleModel.getY() + px*Math.sin(heading));
        turtleModel.moveWithAnimation();

        System.out.println("backward " + px);
        return px;
    }

    public double turnLeft(double deg) {
        turtleModel.setLeftRotate(deg);
        return deg;
    }

    public double turnRight(double deg) {
        turtleModel.setRightRotate(deg);
        return deg;
    }

    public double setHeading(double deg) {
        double initialHeading = turtleModel.getHeading();
        turtleModel.setHeading(deg);
        return turtleModel.getHeading() - initialHeading;
    }

    public double turnTowards(double x, double y) {
        double angle = Math.atan(y/x);
        double initialHeading = turtleModel.getHeading();
        turtleModel.setHeading(angle);
        return turtleModel.getHeading() - initialHeading;
    }

    public double goTo(double x, double y) {
        double initialX = turtleModel.getX();
        double initialY = turtleModel.getY();
        turtleModel.setX(x);
        turtleModel.setY(y);
        return calcDistance(initialX, turtleModel.getX(), initialY, turtleModel.getY());
    }

    public double penDown() {
        turtleModel.setPenDown();
        return 1;
    }

    public double penUp() {
        turtleModel.setPenUp();
        return 0;
    }

    public double showTurtle() {
        turtleModel.setVisible();
        return 1;
    }

    public double hideTurtle() {
        turtleModel.setInvisible();
        return 0;
    }

    public double goHome() {
        double initialX = turtleModel.getX();
        double initialY = turtleModel.getY();
        turtleModel.setHome();
        return calcDistance(initialX, turtleModel.getX(), initialY, turtleModel.getY());

    }

    public double clearScreen() {
        turtleModel.clearPen();
        return goHome();
    }

    private double calcDistance(double x1, double x2, double y1, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public boolean isVariable(String name){
        return this.varModel.isVariable(name);
    }

    public Double getVariable(String name){
        return this.varModel.getVariable(name);
    }

    public HashMap getVars(){
        return this.varModel.getVars();
    }

    public void makeVariable(String name, Double value){
        this.varModel.makeVariable(name, value);
    }
}
