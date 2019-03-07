package View.GUIFeatures.Panes;


import Model.ModelInterfaces.IModel;
import View.ObserverInterfaces.IObserver;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * @author Hsingchih Tang
 * Displays variables and associated values
 */
public class VariablePane extends StackPane implements IObserver {

    private final String VAR_NAME_COL = "Variable Name";
    private final String VAR_VAL_COL = "Value";
    private final String VAR_NAME_FIELD = "varName";
    private final String VAR_VAL_FIELD = "varVal";
    private TableView<Variable> varTable;

    private IModel myVarPaneModel;
    private ObservableList<Variable> myVars = FXCollections.observableArrayList(new Variable("name0","val0"));


    public VariablePane(double w, double h){
        super();
        initTable();
        this.setMaxWidth(w);
        this.setHeight(h);
        this.getChildren().addAll(varTable);
        this.setAlignment(Pos.CENTER);
    }

    private void initTable(){
        varTable = new TableView();
        TableColumn varName = new TableColumn(VAR_NAME_COL);
        varName.prefWidthProperty().bind(varTable.widthProperty().multiply(0.5));
        varName.setCellValueFactory(new PropertyValueFactory<Variable,String>(VAR_NAME_FIELD));
        TableColumn varVal = new TableColumn(VAR_VAL_COL);
        varVal.prefWidthProperty().bind(varTable.widthProperty().multiply(0.5));
        varVal.setCellValueFactory(new PropertyValueFactory<Variable,String>(VAR_VAL_FIELD));
        varTable.setItems(myVars);
        varTable.setEditable(true);
        varTable.getColumns().addAll(varName,varVal);
    }

    @Override
    public void updateData(){
        myVars.clear();
        myVars.addAll(myVarPaneModel.getData());
    }

    @Override
    public void setupModel(IModel model) {
        myVarPaneModel = model;
        model.registerObserver(this);
    }

    @Override
    public IModel getModel() {
        return myVarPaneModel;
    }
}
