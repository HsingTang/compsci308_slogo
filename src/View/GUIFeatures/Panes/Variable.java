package View.GUIFeatures.Panes;

import javafx.beans.property.SimpleStringProperty;

public class Variable {
    private SimpleStringProperty varName;
    private SimpleStringProperty varVal;

    public Variable(String name, String val){
        this.varName = new SimpleStringProperty(name);
        this.varVal = new SimpleStringProperty(val);
    }

    public void setVarVal(String newVal){
        this.varVal.setValue(newVal);
    }

    public String getVarVal(){
        return this.varVal.get();
    }

    public String getVarName(){
        return this.varName.get();
    }
}
