package Handlers;

import Handlers.HandlerInterfaces.CommandHandlerInterface;
import Model.ModelInterfaces.ModelInterface;

public class CommandHandler implements CommandHandlerInterface {
    ModelInterface model;

    public CommandHandler(ModelInterface model) {
        this.model = model;
    }

    public double moveForward(double px) {
        double heading = Math.toRadians(model.getHeading());
        model.setX(px*Math.cos(heading));
        model.setY(px*Math.sin(heading));
        model.moveWithAnimation();
        return px;
    }

    public double moveBackwards(double px) {
        double heading = Math.toRadians(model.getHeading());
        model.setX(-px*Math.cos(heading));
        model.setY(-px*Math.sin(heading));
        model.moveWithAnimation();
        return px;
    }

    public double turnLeft(double deg) {
        model.setLeftRotate(deg);
        return deg;
    }

    public double turnRight(double deg) {
        model.setRightRotate(deg);
        return deg;
    }

    public double setHeading(double deg) {
        double initialHeading = model.getHeading();
        model.setHeading(deg);
        return model.getHeading() - initialHeading;
    }

    public double turnTowards(double x, double y) {
        double angle = Math.atan(y/x);
        double initialHeading = model.getHeading();
        model.setHeading(angle);
        return model.getHeading() - initialHeading;
    }

    public double goTo(double x, double y) {
        double initialX = model.getX();
        double initialY = model.getY();
        model.setX(x);
        model.setY(y);
        return calcDistance(initialX, model.getX(), initialY, model.getY());
    }

    public double penDown() {
        model.setPenDown();
        return 1;
    }

    public double penUp() {
        model.setPenUp();
        return 0;
    }

    public double showTurtle() {
        model.setVisible();
        return 1;
    }

    public double hideTurtle() {
        model.setInvisible();
        return 0;
    }

    public double goHome() {
        double initialX = model.getX();
        double initialY = model.getY();
        model.setHome();
        return calcDistance(initialX, model.getX(), initialY, model.getY());

    }

    public double clearScreen() {
        // Clear the trail.
        return goHome();
    }

    private double calcDistance(double x1, double x2, double y1, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
