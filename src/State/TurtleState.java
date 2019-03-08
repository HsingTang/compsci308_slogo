package State;

public class TurtleState {

    private double newX;
    private double newY;
    private double newHeading;
    private boolean penDown;
    private boolean isInvisible;
    private boolean isMoving;
    private boolean isPenCleared;

    public TurtleState(double newX, double newY, double newHeading, boolean penDown, boolean isInvisible, boolean isMoving, boolean isPenCleared) {
        this.newX = newX;
        this.newY = newY;
        this.newHeading = newHeading;
        this.penDown = penDown;
        this.isInvisible = isInvisible;
        this.isMoving = isMoving;
        this.isPenCleared = isPenCleared;
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

    public boolean getIsMoving() { return this.isMoving; }

    public boolean getIsPenCleared() {
        return this.isPenCleared;
    }

}
