package Model.ModelInterfaces;

import View.ObserverInterfaces.ObserverInterface;
import View.ObserverInterfaces.TurtleObserver;

import java.util.ArrayList;

public interface ModelInterface {

    void registerObserver(ObserverInterface o);

    void removeObserver(ObserverInterface o);

    void notifyObserver();

}
