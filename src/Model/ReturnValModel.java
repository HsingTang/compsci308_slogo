package Model;

import Model.ModelInterfaces.IModel;
import View.ObserverInterfaces.IObserver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hsingchih Tang
 * Back-end Model component corresponding to the Console on the front end
 * There should be one ReturnValModel paired to each Console
 */
public class ReturnValModel implements IModel {
    private ArrayList<IObserver> myObservers;
    private String myReturnVal;

    /**
     * Instantiates a new ReturnValModel object
     */
    public ReturnValModel(){
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
     * Updates the value to be transferred back to front-end View components and then notifies observers of the update
     * @param val the new value to return to front end
     */
    public void addReturnVal(String val){
        this.updateReturnVal(val);
        notifyObserver();
    }

    /**
     * @return the value to front-end View component
     */
    @Override
    public List getData() {
        return Arrays.asList(myReturnVal);
    }

    /**
     * Empty method that doesn't need to be implemented on Console/ReturnValModel pair
     * since only one-way (back to front end) data transfer is expected for this View/Model pair
     */
    @Override
    public void ObserverUpdateModel(Object o) {

    }

    /**
     * Updates the value to be transferred back to front-end View components
     * @param s the new value to return to front end
     */
    public void updateReturnVal(String s){
        myReturnVal = s;
    }
}
