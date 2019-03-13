package Model;

import Model.ModelInterfaces.IModel;
import View.ObserverInterfaces.IObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class that is extended by VariablePaneModel and CommandHistoryModel to realize Model/View interactions
 */
public abstract class PaneModel implements IModel {
    private ArrayList<IObserver> myObservers;

    /**
     * Instantiates a new PaneModel object and set up necessary field
     */
    public PaneModel(){
        myObservers = new ArrayList<>();
    }

    /**
     * Registers a front-end observer component (a Console) as this Model's observer
     * @param o the observer to register
     */
    @Override
    public void registerObserver(IObserver o) {
        myObservers.add(o);
    }

    /**
     * Removes a front-end observer component from the list of observers for this Model
     * @param o the observer to remove
     */
    @Override
    public void removeObserver(IObserver o) {
        myObservers.remove(o);
    }

    /**
     * Notifies front-end observers about any change in the data stored in this Model
     */
    @Override
    public void notifyObserver() {
        for (IObserver o:myObservers){
            o.updateData();
        }
    }

    /**
     * @return the value stored in this Model to front-end View component
     */
    @Override
    public abstract List getData();
}
