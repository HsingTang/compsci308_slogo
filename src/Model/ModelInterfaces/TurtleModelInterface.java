package Model.ModelInterfaces;

import View.ObserverInterfaces.TurtleObserver;

public interface TurtleModelInterface {

    void registerTurtleObserver(TurtleObserver o);

    void removeTurtleObserver(TurtleObserver o);

    void setX(double x);

    void setY(double y);

    void setHome();

    void moveWithAnimation();

    void setLeftRotate(double deg);

    void setRightRotate(double deg);

    void setHeading(double deg);

    void setPenDown();

    void setPenUp();

    void setInvisible();

    void setVisible();

    double getX();

    double getY();

    double getHeading();

    boolean getPenDown();

    boolean isInvisible();

    void clearPen();

}
