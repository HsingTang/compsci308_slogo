package Model;

import View.GUIFeatures.Panes.Variable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;


import java.util.HashMap;


/**
 * @author Mary Gooneratne
 * @author Hsingchih Tang
 * Back-end Model component corresponding to the VariablePane on the front end
 * There should be one VariablePaneModel paired to each VariablePane
 * Concrete subclass extending the abstract PaneModel class, which implements IModel interface
 */
public class VariablePaneModel extends PaneModel {

    private HashMap<String, Double> myVariables;
    private ObservableList<Variable> myVarList;

    /**
     * Instantiates a new VariablePaneModel object
     */
    public VariablePaneModel(){
        super();
        myVariables = new HashMap<>();
        myVarList = FXCollections.observableArrayList();
    }

    /**
     * Records a new variable in the private field and notifies its observer (the VariablePane) about the update
     * @param name of the new variable
     * @param value of the new variable
     */
    public void makeVariable(String name, Double value){
        this.myVariables.put(name, value);
        myVarList.add(new Variable(name, String.valueOf(value)));
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


    @Override
    public void registerObserverData(Object o) {
        ((TableView)(o)).setItems(myVarList);
    }

}
