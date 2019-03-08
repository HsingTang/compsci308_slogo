package Model;

import Model.ModelInterfaces.IModel;
import View.ObserverInterfaces.IObserver;

import java.util.ArrayList;
import java.util.List;

public abstract class PaneModel implements IModel {
    private ArrayList<IObserver> myObservers;

    public PaneModel(){
        myObservers = new ArrayList<>();
    }

    @Override
    public void registerObserver(IObserver o) {
        myObservers.add(o);
    }

    @Override
    public void removeObserver(IObserver o) {
        myObservers.remove(o);
    }

    @Override
    public void notifyObserver() {
        for (IObserver o:myObservers){
            o.updateData();
        }
    }

    @Override
    public abstract List getData();
}
