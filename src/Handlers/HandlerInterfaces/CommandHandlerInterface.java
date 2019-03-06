package Handlers.HandlerInterfaces;

import java.util.HashMap;

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

    void makeVariable(String name, Double value);

    boolean isVariable(String name);

    Double getVariable(String name);

    HashMap getVars();
}
