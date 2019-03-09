package Handlers;

import Handlers.HandlerInterfaces.CommandHandlerInterface;
import Model.*;
import Model.ModelInterfaces.TurtleModelInterface;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import State.TurtleState;

public class CommandHandler implements CommandHandlerInterface {
    public static final double INITIAL_HEADING = 90.0;

    static final double MAX = 240;
    final TurtleModelInterface turtleModel;
    final VariablePaneModel varModel;
    final CommandPaneModel commandModel;
    final ReturnValModel returnModel;
    private Queue<TurtleState> states;


    public CommandHandler(TurtleModelInterface turtleModel, VariablePaneModel varModel, CommandPaneModel commandModel, ReturnValModel returnModel) {
        this.turtleModel = turtleModel;
        this.varModel = varModel;
        this.states = new LinkedList<>();
        this.commandModel = commandModel;
        this.returnModel = returnModel;
    }

    public double moveForward(double px) {
        double heading = Math.toRadians(getAngle(turtleModel.getHeading()));
        double newX = turtleModel.getX() + px*Math.cos(heading);
        double newY = turtleModel.getY() - px*Math.sin(heading);
        setMovement(newX, newY, heading);
        addTurtleState();
        return px;
    }

    public double moveBackwards(double px) {
        double heading = Math.toRadians(getAngle(turtleModel.getHeading()));
        double newX = turtleModel.getX() - px*Math.cos(heading);
        double newY = turtleModel.getY() + px*Math.sin(heading);
        setMovement(newX, newY, heading);
        addTurtleState();
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

    @Override
    public double getXcor() {
        return turtleModel.getX();
    }

    @Override
    public double getYcor() {
        return turtleModel.getY();
    }

    @Override
    public double getHeading() {
        return turtleModel.getHeading();
    }

    @Override
    public double getPenState() {
        if(turtleModel.getPenDown()){
            return 1;
        }
        return 0;
    }

    @Override
    public double getTurtleState() {
        if(turtleModel.isInvisible()){
            return 0;
        }
        return 1;
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

    public void addToHistory(String command) { this.commandModel.addToHistory(command);}

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

    public void addReturnVal(String val) {
        this.returnModel.addReturnVal(val);
    }
    private void setMovement(double newX, double newY, double heading) {
        if (newX > -MAX && newX < MAX && newY < -MAX) {
            turtleModel.setX(newX - (Math.abs(newY) - MAX)/Math.tan(heading));
            turtleModel.setY(-MAX);
        } else if (newX > -MAX && newX < MAX && newY > MAX) {
            turtleModel.setX(newX - (Math.abs(newY) - MAX)/-Math.tan(heading));
            turtleModel.setY(MAX);
        } else if (newY > -MAX && newY < MAX && newX > MAX){
            turtleModel.setX(MAX);
            turtleModel.setY(newY + (Math.abs(newX) - MAX)*Math.tan(heading));
        } else if (newY > -MAX && newY < MAX && newX < -MAX)  {
            turtleModel.setX(-MAX);
            turtleModel.setY(newY + (Math.abs(newX) - MAX)*-Math.tan(heading));
        } else {
            turtleModel.setX(newX);
            turtleModel.setY(newY);
        }
    }

    private double getAngle(double angle) {
        while (angle < 0) {
            angle += 360;
        }
        return angle;
    } 
}
