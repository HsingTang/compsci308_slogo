package Model;

import Model.ModelInterfaces.ModelInterface;
import View.GUIFeatures.Panels.Variable;
import View.ObserverInterfaces.ObserverInterface;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class VariablePaneModel implements ModelInterface {

    private ArrayList<ObserverInterface> myObservers;
    private HashMap<String, Double> myVariables;

    public VariablePaneModel(){
        myVariables = new HashMap<>();
        myObservers = new ArrayList<>();
    }

    public void makeVariable(String name, Double value){
        this.myVariables.put(name, value);
    }

    public Double getVariable(String name){
        return this.myVariables.get(name);
    }

    public boolean isVariable(String name){
        return myVariables.keySet().contains(name);
    }

    public HashMap getVars(){
        return this.myVariables;
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
    public List getData(){
        ArrayList<Variable> data = new ArrayList<>();
        for(String var: this.myVariables.keySet()){
            Variable variable = new Variable(var, Double.toString(this.myVariables.get(var)));
            data.add(variable);
        }
        return data;
    }
}
