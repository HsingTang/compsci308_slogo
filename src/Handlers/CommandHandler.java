package Handlers;

import Handlers.HandlerInterfaces.CommandHandlerInterface;
import Model.CommandInfo;
import Model.CommandPaneModel;
import Model.ModelInterfaces.TurtleModelInterface;
import Model.ReturnValModel;
import Model.VariablePaneModel;
import State.TurtleState;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Handles command transferring between each node and the model
 *
 * @author Eric Lin
 */
public class CommandHandler implements CommandHandlerInterface {
    public static final double INITIAL_HEADING = 90.0;

    static final double MAX = 240;
    private TurtleModelInterface turtleModel;
    private VariablePaneModel varModel;
    private CommandPaneModel commandModel;
    private ReturnValModel returnModel;
    private Queue<TurtleState> states;


    /**
     * Instantiates a command handler
     *
     * @param turtleModel   model interface for turtle
     * @param varModel      model for variablePane
     * @param commandModel  model for command
     * @param returnModel   model for return value
     */
    public CommandHandler(TurtleModelInterface turtleModel, VariablePaneModel varModel, CommandPaneModel commandModel, ReturnValModel returnModel) {
        this.turtleModel = turtleModel;
        this.varModel = varModel;
        this.states = new LinkedList<>();
        this.commandModel = commandModel;
        this.returnModel = returnModel;
    }

    /**
     * Sets turtle model new x and y in forward direction
     *
     * @param px distance traveled
     * @return   distance traveled
     */
    public double moveForward(double px) {
        double heading = Math.toRadians(getAngle(turtleModel.getHeading()));
        double newX = turtleModel.getX() + px*Math.cos(heading);
        double newY = turtleModel.getY() - px*Math.sin(heading);
        setMovement(newX, newY, heading);
        addTurtleState();
        return px;
    }

    /**
     * moves turtle backwards
     *
     * @param px    distance traveled
     * @return      distance traveled
     */
    public double moveBackwards(double px) {
        double heading = Math.toRadians(getAngle(turtleModel.getHeading()));
        double newX = turtleModel.getX() - px*Math.cos(heading);
        double newY = turtleModel.getY() + px*Math.sin(heading);
        setMovement(newX, newY, heading);
        addTurtleState();
        return px;
    }

    /**
     * turns turtle left
     *
     * @param deg   degrees turned
     * @return      degrees turned
     */
    public double turnLeft(double deg) {
        turtleModel.setLeftRotate(deg);
        addTurtleState();
        return deg;
    }

    /**
     * turns turtle right
     *
     * @param deg   degrees turned
     * @return      degrees turned
     */
    public double turnRight(double deg) {
        turtleModel.setRightRotate(deg);
        addTurtleState();
        return deg;
    }

    /**
     * sets heading of the turtle
     *
     * @param deg   new heading of turtle
     * @return      new heading of turtle
     */
    public double setHeading(double deg) {
        double initialHeading = turtleModel.getHeading();
        turtleModel.setHeading(deg);
        addTurtleState();
        return turtleModel.getHeading() - initialHeading;
    }

    /**
     * Turns toward a location
     *
     * @param x x of new location
     * @param y y of new location
     * @return  new heading
     */
    public double turnTowards(double x, double y) {
        double angle = Math.atan(y/x);
        double initialHeading = turtleModel.getHeading();
        turtleModel.setHeading(angle);
        addTurtleState();
        return turtleModel.getHeading() - initialHeading;
    }

    /**
     * moves turtle to specific location
     *
     * @param x x of new location
     * @param y y of new location
     * @return  distance travelled
     */
    public double goTo(double x, double y) {
        double initialX = turtleModel.getX();
        double initialY = turtleModel.getY();
        turtleModel.setX(x);
        turtleModel.setY(y);
        addTurtleState();
        return calcDistance(initialX, turtleModel.getX(), initialY, turtleModel.getY());
    }

    /**
     * sets the turtles pen to down
     *
     * @return  indication of pen being down (1)
     */
    public double penDown() {
        turtleModel.setPenDown();
        addTurtleState();
        return 1;
    }

    /**
     * sets the turtles pen to up
     *
     * @return  indication of pen being up (0)
     */
    public double penUp() {
        turtleModel.setPenUp();
        addTurtleState();
        return 0;
    }

    /**
     * Shows the turtle on the screen if invisible
     *
     * @return  indication that the turtle is visible (1)
     */
    public double showTurtle() {
        turtleModel.setVisible();
        addTurtleState();
        return 1;
    }

    /**
     * Hides the turtle if is visible
     *
     * @return  indication that the turtle is invisible (0)
     */
    public double hideTurtle() {
        turtleModel.setInvisible();
        addTurtleState();
        return 0;
    }

    /**
     * return to center
     *
     * @return  distance travelled
     */
    public double goHome() {
        double distance = setHomePositioning();
        addTurtleState();
        return distance;

    }

    /**
     * clears the screen of pen and returns the turtle back to center
     *
     * @return  distance travelled
     */
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

    public Map getVars(){
        return this.varModel.getVars();
    }

    /**
     * Gets the queue of turtle states
     *
     * @return  turtle states queue
     */
    public Queue getQueue() {
        return this.states;
    }

    /**
     * Makes variable in model
     *
     * @param name      name of variable
     * @param value     value of variable
     */
    public void makeVariable(String name, Double value){
        this.varModel.makeVariable(name, value);
    }

    /**
     * Determine whether or not text is a command
     *
     * @param name  command
     * @return      boolean whether or not is true
     */
    public boolean isCommand(String name) { return this.commandModel.isCommand(name);}

    /**
     * Gets the command form the command model
     *
     * @param name  command
     * @return      command if found
     */
    public CommandInfo getCommand(String name) { return this.commandModel.getCommand(name);}

    /**
     * Gets mapping of commands
     *
     * @return  map of commands
     */
    public Map getCommands() { return this.commandModel.getCommands();}

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

    /**
     * add return value to the return model
     *
     * @param val   return value
     */
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
