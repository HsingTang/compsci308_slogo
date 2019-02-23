package GUIFeatures;


import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

/**
 * @author Hsingchih Tang
 * Displays variables and associated values
 */
public class VariablePane extends VBox {

    private final String VAR_NAME_COL = "Variable Name";
    private final String VAR_VAL_COL = "Value";
    private TableView varTable;
    private TableColumn varName;
    private TableColumn varVal;


    public VariablePane(double w, double h){
        super();
        initTable();
        this.setWidth(w);
        this.setHeight(h);
        this.getChildren().addAll(varTable);
        this.setAlignment(Pos.CENTER);
    }

    private void initTable(){
        varName = new TableColumn(VAR_NAME_COL);
        varVal = new TableColumn(VAR_VAL_COL);
        varTable = new TableView();
        varTable.setMinSize(this.getWidth(),this.getHeight());
        varName.prefWidthProperty().bind(varTable.widthProperty().multiply(0.5));
        varVal.prefWidthProperty().bind(varTable.widthProperty().multiply(0.5));
        varTable.setEditable(true);
        varTable.getColumns().addAll(varName,varVal);
    }

    private void updateVar(String varName, double varVal){

    }
}
