package Model;

import Model.ModelInterfaces.IModel;
import View.GUIFeatures.Panes.Variable;
import View.ObserverInterfaces.IObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VariablePaneModel implements IModel {

    private ArrayList<IObserver> myObservers;
    private HashMap<String, Double> myVariables;

    public VariablePaneModel(){
        myVariables = new HashMap<>();
        myObservers = new ArrayList<>();
    }

    public void makeVariable(String name, Double value){
        this.myVariables.put(name, value);
        notifyObserver();
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
    public List getData(){
        ArrayList<Variable> data = new ArrayList<>();
        for(String var: this.myVariables.keySet()){
            Variable variable = new Variable(var, Double.toString(this.myVariables.get(var)));
            // System.out.println("add to returning datalist "+var+" = "+this.myVariables.get(var));
            data.add(variable);
        }
        return data;
    }
}
