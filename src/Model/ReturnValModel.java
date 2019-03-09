package Model;

import Model.ModelInterfaces.IModel;
import View.ObserverInterfaces.IObserver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReturnValModel implements IModel {
    private ArrayList<IObserver> myObservers;
    private String myReturnVal;

    public ReturnValModel(){
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
    public List getData() {
        return Arrays.asList(myReturnVal);
    }

    @Override
    public void ObserverUpdateModel(Object o) {

    }

    public void updateReturnVal(String s){
        myReturnVal = s;
    }
}
