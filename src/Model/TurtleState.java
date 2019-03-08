package Model;

public class TurtleState {

    private double newX;
    private double newY;
    private double newHeading;
    private double penDown;
    private double isInvisible;

    public void TurtleState(double newX, double newY, double newHeading, double penDown, double isInvisible) {
        this.newX = newX;
        this.newY = newY;
        this.newHeading = newHeading;
        this.penDown = penDown;
        this.isInvisible = isInvisible;
    }


}
