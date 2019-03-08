package State;

import Model.TurtleModel;
import View.Turtles.TurtleView;

public interface SettableState {
    void setTurtleState(double newX, double newY, double newHeading, double penDown, double isInvisible);
}
