package Model;

import View.GUIFeatures.Panes.Variable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mary Gooneratne
 * @author Hsingchih Tang
 * Back-end Model component corresponding to the VariablePane on the front end
 * There should be one VariablePaneModel paired to each VariablePane
 * Concrete subclass extending the abstract PaneModel class, which implements IModel interface
 */
public class VariablePaneModel extends PaneModel {

    private HashMap<String, Double> myVariables;

    /**
     * Instantiates a new VariablePaneModel object
     */
    public VariablePaneModel(){
        super();
        myVariables = new HashMap<>();
    }

    /**
     * Records a new variable in the private field and notifies its observer (the VariablePane) about the update
     * @param name of the new variable
     * @param value of the new variable
     */
    public void makeVariable(String name, Double value){
        this.myVariables.put(name, value);
        notifyObserver();
    }

    /**
     * @param name of the variable being queried
     * @return value of the variable specified by the name
     */
    public Double getVariable(String name){
        return this.myVariables.get(name);
    }

    /**
     * @param name of the variable being queried
     * @return boolean value indicating whether the queried variable exists in records
     */
    public boolean isVariable(String name){
        return myVariables.keySet().contains(name);
    }

    /**
     * @author Mary Gooneratne
     * @return variables recorded by the model
     */
    public HashMap getVars(){
        return this.myVariables;
    }

    /**
     * @return recorded variable name/value pairs in a list of Variable objects
     */
    @Override
    public List getData(){
        ArrayList<Variable> data = new ArrayList<>();
        for(Map.Entry<String,Double> entry:myVariables.entrySet()){
            Variable variable = new Variable(entry.getKey(), Double.toString(entry.getValue()));
            data.add(variable);
        }
        return data;
    }

    /**
     * Updates a variable value that has been updated on the front-end by user action
     * @param o the variable that is being updated
     */
    @Override
    public void ObserverUpdateModel(Object o) {
        Variable newVar = (Variable) o;
        myVariables.put(newVar.getVarName(),Double.valueOf(newVar.getVarVal()));
    }
}
