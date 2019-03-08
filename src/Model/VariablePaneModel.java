package Model;

import View.GUIFeatures.Panes.Variable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VariablePaneModel extends PaneModel {

    private HashMap<String, Double> myVariables;

    public VariablePaneModel(){
        super();
        myVariables = new HashMap<>();
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

    public List getData(){
        ArrayList<Variable> data = new ArrayList<>();
        for(Map.Entry<String,Double> entry:myVariables.entrySet()){
            Variable variable = new Variable(entry.getKey(), Double.toString(entry.getValue()));
            // System.out.println("add to returning datalist "+var+" = "+this.myVariables.get(var));
            data.add(variable);
        }
        return data;
    }
}
