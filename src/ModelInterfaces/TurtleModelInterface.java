package ModelInterfaces;

import View.ObserverInterfaces.TurtleObserver;

public interface TurtleModelInterface {

    void registerTurtleObserver(TurtleObserver o);

    void removeTurtleObserver(TurtleObserver o);

    void setX(double x);

    double getX();

    void notifyX();

}
