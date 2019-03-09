package Handlers;

import Handlers.HandlerInterfaces.CommandHandlerInterface;
import Model.CommandInfo;
import Model.CommandPaneModel;
import Model.ModelInterfaces.TurtleModelInterface;
import Model.VariablePaneModel;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import State.TurtleState;

public class CommandHandler implements CommandHandlerInterface {
    public static final double INITIAL_HEADING = 90.0;

    static final double WIDTH = 480;
    static final double HEIGHT = 480;
    final TurtleModelInterface turtleModel;
    final VariablePaneModel varModel;
    final CommandPaneModel commandModel;
    private Queue<TurtleState> states;


    public CommandHandler(TurtleModelInterface turtleModel, VariablePaneModel varModel, CommandPaneModel commandModel) {
        this.turtleModel = turtleModel;
        this.varModel = varModel;
        this.states = new LinkedList<>();
        this.commandModel = commandModel;
    }

    public double moveForward(double px) {
        double heading = Math.toRadians(turtleModel.getHeading());
        double potentialNewX = turtleModel.getX() + px*Math.cos(heading);
        double potentialNewY = turtleModel.getY() - px*Math.sin(heading);
        double maxX = turtleModel.getX();
        turtleModel.setX(turtleModel.getX() + px*Math.cos(heading));
        turtleModel.setY(turtleModel.getY() - px*Math.sin(heading));
        addTurtleState();
        System.out.println("forward " + px);
        return px;
    }

    public double moveBackwards(double px) {
        double heading = Math.toRadians(turtleModel.getHeading());
        turtleModel.setX(turtleModel.getX() - px*Math.cos(heading));
        turtleModel.setY(turtleModel.getY() + px*Math.sin(heading));
        addTurtleState();
        System.out.println("backward " + px);
        return px;
    }

    public double turnLeft(double deg) {
        turtleModel.setLeftRotate(deg);
        addTurtleState();
        return deg;
    }

    public double turnRight(double deg) {
        turtleModel.setRightRotate(deg);
        addTurtleState();
        return deg;
    }

    public double setHeading(double deg) {
        double initialHeading = turtleModel.getHeading();
        turtleModel.setHeading(deg);
        addTurtleState();
        return turtleModel.getHeading() - initialHeading;
    }

    public double turnTowards(double x, double y) {
        double angle = Math.atan(y/x);
        double initialHeading = turtleModel.getHeading();
        turtleModel.setHeading(angle);
        addTurtleState();
        return turtleModel.getHeading() - initialHeading;
    }

    public double goTo(double x, double y) {
        double initialX = turtleModel.getX();
        double initialY = turtleModel.getY();
        turtleModel.setX(x);
        turtleModel.setY(y);
        addTurtleState();
        return calcDistance(initialX, turtleModel.getX(), initialY, turtleModel.getY());
    }

    public double penDown() {
        turtleModel.setPenDown();
        addTurtleState();
        return 1;
    }

    public double penUp() {
        turtleModel.setPenUp();
        addTurtleState();
        return 0;
    }

    public double showTurtle() {
        turtleModel.setVisible();
        addTurtleState();
        return 1;
    }

    public double hideTurtle() {
        turtleModel.setInvisible();
        addTurtleState();
        return 0;
    }

    public double goHome() {
        double distance = setHomePositioning();
        addTurtleState();
        return distance;

    }

    public double clearScreen() {
        turtleModel.setHeading(INITIAL_HEADING);
        double distance = setHomePositioning();
        turtleModel.clearPen();
        addTurtleState();
        return distance;
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

    public Queue getQueue() {
        return this.states;
    }

    public void makeVariable(String name, Double value){
        this.varModel.makeVariable(name, value);
    }

    public boolean isCommand(String name) { return this.commandModel.isCommand(name);}

    public CommandInfo getCommand(String name) { return this.commandModel.getCommand(name);}

    public HashMap getCommands() { return this.commandModel.getCommands();}

    public void makeCommand(CommandInfo info) { this.commandModel.makeCommand(info);}

    private void addTurtleState() {
        TurtleState newState = new TurtleState(turtleModel.getX(), turtleModel.getY(), turtleModel.getHeading(), turtleModel.getPenDown(), turtleModel.isInvisible(), turtleModel.isMoving(), turtleModel.isPenInvisible());
        turtleModel.getModelStates().add(newState);
    }

    private double setHomePositioning() {
        double initialX = turtleModel.getX();
        double initialY = turtleModel.getY();
        turtleModel.setHome();
        return calcDistance(initialX, turtleModel.getX(), initialY, turtleModel.getY());
    }

    private double[] getMaxDistanceAndPointsForwards(double angle, double xPos, double yPos) {
        double[] distanceMaxAndMaxY = new double[3];
        angle = findAngle(angle);
        if (0 < angle && angle <= 90) { // Quadrant 1

        } else if (angle > 90 && angle <= 180) { // Quadrant 2

        } else if (angle > 180 && angle <= 270) { // Quadrant 3

        } else { // Quadrant 4

        }

        return distanceMaxAndMaxY;
    }

    private double findAngle(double angle) {
        while (angle < 0) {
            angle+=360;
        }
        return angle;
    }
}
