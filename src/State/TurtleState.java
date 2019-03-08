package State;

public class TurtleState {

    private double newX;
    private double newY;
    private double newHeading;
    private boolean penDown;
    private boolean isInvisible;

    public TurtleState(double newX, double newY, double newHeading, boolean penDown, boolean isInvisible) {
        this.newX = newX;
        this.newY = newY;
        this.newHeading = newHeading;
        this.penDown = penDown;
        this.isInvisible = isInvisible;
    }

    public double getNewX() {
        return this.newX;
    }

    public double getNewY() {
        return this.newY;
    }

    public double getNewHeading() {
        return this.newHeading;
    }

    public boolean getPenDown() {
        return this.penDown;
    }

    public boolean getIsInvisible() {
        return this.isInvisible;
    }

}
