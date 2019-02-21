package GUIFeatures;


import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * @author Hsingchih Tang
 * Displays variables and associated values
 */
public class VariablePane extends TableView {

    TableColumn varName;
    TableColumn varVal;

    public VariablePane(){
        super();
        this.setEditable(true);
        varName = new TableColumn("Variable Name");
        varVal = new TableColumn("Value");
        this.getColumns().addAll(varName,varVal);
    }
}
