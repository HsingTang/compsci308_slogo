package Model;

import Model.ModelInterfaces.IModel;
import View.ObserverInterfaces.IObserver;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextArea;

import java.util.ArrayList;


/**
 * @author Hsingchih Tang
 * Back-end Model component corresponding to the Console on the front end
 * There should be one ReturnValModel paired to each Console
 */
public class ReturnValModel implements IModel {
    private ArrayList<IObserver> myObservers;
    private StringProperty myReturnVal = new SimpleStringProperty();

    /**
     * Instantiates a new ReturnValModel object
     */
    public ReturnValModel(){
        myObservers = new ArrayList<>();
    }


    /**
     * Updates the value to be transferred back to front-end View components and then notifies observers of the update
     * @param val the new value to return to front end
     */
    public void addReturnVal(String val){
        this.updateReturnVal(val);
    }

    @Override
    public void registerObserverData(Object o) {
        ((TextArea)(o)).promptTextProperty().bind(myReturnVal);
    }

    /**
     * Updates the value to be transferred back to front-end View components
     * @param s the new value to return to front end
     */
    public void updateReturnVal(String s){
        myReturnVal.setValue(s);
    }
}
