package Handlers.HandlerInterfaces;

import Model.CommandInfo;

import java.util.Map;
import java.util.Queue;

public interface CommandHandlerInterface {

    double moveForward(double px);

    double moveBackwards(double px);

    double turnLeft(double deg);

    double turnRight(double deg);

    double setHeading(double deg);

    double turnTowards(double x, double y);

    double goTo(double x, double y);

    double penDown();

    double penUp();

    double showTurtle();

    double hideTurtle();

    double goHome();

    double clearScreen();

    double getXcor();

    double getYcor();

    double getHeading();

    double getPenState();

    double getTurtleState();

    Queue getQueue();

    void makeVariable(String name, Double value);

    boolean isVariable(String name);

    Double getVariable(String name);

    Map getVars();

    boolean isCommand(String name);

    CommandInfo getCommand(String name);

    Map getCommands();

    void makeCommand(CommandInfo info);

    void addToHistory(String command);

    void addReturnVal(String val);
}
