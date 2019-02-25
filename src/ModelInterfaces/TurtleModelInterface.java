package ModelInterfaces;

import ObserverInterfaces.TurtleObserver;

public interface TurtleModelInterface {

    public void addTurtleObserver(TurtleObserver o);

    public void removeTurtleObserver(TurtleObserver o);

}
