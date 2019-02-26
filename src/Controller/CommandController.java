package Controller;

import Controller.ControllerInterfaces.CommandControllerInterface;
import Model.ModelInterfaces.TurtleModelInterface;

public class CommandController implements CommandControllerInterface {
    TurtleModelInterface model;

    public CommandController(TurtleModelInterface model) {
        this.model = model;
    }

    public void moveForward(double px) {
        double heading = Math.toRadians(model.getHeading());
        model.setX(px*Math.cos(heading));
        model.setY(px*Math.sin(heading));
        model.moveWithAnimation();
    }

    public void moveBackwards(double px) {
        double heading = Math.toRadians(model.getHeading());
        model.setX(-px*Math.cos(heading));
        model.setY(-px*Math.sin(heading));
        model.moveWithAnimation();
    }

    public void turnLeft(double deg) {
        model.setLeftRotate(deg);
    }

    public void turnRight(double deg) {
        model.setRightRotate(deg);
    }

    public void setHeading(double deg) {
        model.setHeading(deg);
    }

    public void turnTowards(double x, double y) {
        double angle = Math.atan(y/x);
        model.setHeading(angle);
    }

    public void goTo(double x, double y) {
        model.setX(x);
        model.setY(y);
    }

    public void penDown() {
        model.setPenDown();
    }

    public void penUp() {
        model.setPenUp();
    }

    public void showTurtle() {

    }

    public void hideTurtle() {

    }

    public void goHome() {

    }

    public void clearScreen() {

    }

}
