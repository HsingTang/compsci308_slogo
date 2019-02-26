package Model.ModelInterfaces;

import View.ObserverInterfaces.TurtleObserver;

public interface TurtleModelInterface {

    void registerTurtleObserver(TurtleObserver o);

    void removeTurtleObserver(TurtleObserver o);

    void setX(double x);

    void setY(double y);

    void hasMoved();

    void setLeftRotate(double deg);

    void setRightRotate(double deg);

    void setHeading(double deg);

    double getX();

    double getY();

    double getHeading();

}
