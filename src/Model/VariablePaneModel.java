package Model;

import Model.ModelInterfaces.ModelInterface;
import View.GUIFeatures.Panels.Variable;
import View.ObserverInterfaces.ObserverInterface;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VariablePaneModel implements ModelInterface {

    private ArrayList<ObserverInterface> myObservers;
    private ArrayList<Variable> myVariables;

    public VariablePaneModel(){
        myVariables = new ArrayList<>();
        myObservers = new ArrayList<>();
    }


    @Override
    public void registerObserver(ObserverInterface o) {
        myObservers.add(o);
    }

    @Override
    public void removeObserver(ObserverInterface o) {
        myObservers.remove(o);
    }

    @Override
    public void notifyObserver() {
        for (ObserverInterface o:myObservers){
            o.updateData();
        }
    }

    @Override
    public List<Variable> getData(){
        return Collections.unmodifiableList(myVariables);
    }
}
