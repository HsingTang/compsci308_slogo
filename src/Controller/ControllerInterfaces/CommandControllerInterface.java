package Controller.ControllerInterfaces;

public interface CommandControllerInterface {

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

}
