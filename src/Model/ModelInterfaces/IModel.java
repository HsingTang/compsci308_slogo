package Model.ModelInterfaces;

import View.ObserverInterfaces.IObserver;

import java.util.List;

public interface IModel {

    void registerObserver(IObserver o);

    void removeObserver(IObserver o);

    void notifyObserver();

    List getData();

    void ObserverUpdateModel(Object o);


}
