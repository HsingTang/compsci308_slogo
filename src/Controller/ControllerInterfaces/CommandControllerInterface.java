package Controller.ControllerInterfaces;

public interface CommandControllerInterface {

    void moveForward(double px);

    void moveBackwards(double px);

    void turnLeft(double deg);

    void turnRight(double deg);

    void setHeading(double deg);

    void turnTowards(double x, double y);

    void goTo(double x, double y);

    void penDown();

    void penUp();

    void showTurtle();

    void hideTurtle();

    void goHome();

    void clearScreen();

}
