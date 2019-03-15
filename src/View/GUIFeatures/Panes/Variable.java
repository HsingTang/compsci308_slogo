package View.GUIFeatures.Panes;

import javafx.beans.property.SimpleStringProperty;

/**
 * @author Hsingchih Tang
 * Structure designed to store user-created variables and to interact with JavaFX TableView feature
 */
public class Variable {
    private SimpleStringProperty varName;
    private SimpleStringProperty varVal;

    /**
     * Instantiates a Variable object
     * @param name the String content of the variable name
     * @param val the String content of the variable value
     */
    public Variable(String name, String val){
        this.varName = new SimpleStringProperty(name);
        this.varVal = new SimpleStringProperty(val);
    }

    /**
     * Update the variable value
     * @param newVal new value of this Variable
     */
    public void setVarVal(String newVal){
        this.varVal.setValue(newVal);
    }

    /**
     * @return value of this Variable in String format
     */
    public String getVarVal(){
        return this.varVal.get();
    }

    /**
     * @return name of this Variable in String format
     */
    public String getVarName(){
        return this.varName.get();
    }
}
