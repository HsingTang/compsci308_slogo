package View.GUIFeatures.Panes;


import Model.ModelInterfaces.IModel;
import View.ObserverInterfaces.IObserver;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;

/**
 * @author Hsingchih Tang
 * Left-hand section of the GUI, where created variables and their values are displayed via JavaFX TableView feature
 * There should be one VariablePane per tab
 */
public class VariablePane extends StackPane implements IObserver {

    static final String VAR_NAME_COL = "Variable Name";
    static final String VAR_VAL_COL = "Value";
    static final String VAR_NAME_FIELD = "varName";
    static final String VAR_VAL_FIELD = "varVal";
    static final Double COL_HEIGHT_RATIO = 0.5;

    private TableView<Variable> varTable;
    private TableColumn varName;
    private TableColumn varVal;
    private IModel myVarPaneModel;


    /**
     * Instantiates an instance of the VariablePane.
     * @param w total width of the whole table
     * @param h  height of the table
     */
    public VariablePane(double w, double h){
        super();
        this.setMaxWidth(w);
        this.setHeight(h);
        this.setAlignment(Pos.CENTER);
    }

    /**
     * Sets up the VariablePane's corresponding back-end Model
     * @param model the Model component to be associated to this VariablePane
     */
    @Override
    public void setupModel(IModel model) {
        myVarPaneModel = model;
        initTable();
        this.getChildren().addAll(varTable);

    }


    /**
     * @return the VariablePane's corresponding back-end Model
     */
    @Override
    public IModel getModel() {
        return myVarPaneModel;
    }



    private void initTable(){
        varTable = new TableView();
        varName = new TableColumn(VAR_NAME_COL);
        varName.prefWidthProperty().bind(varTable.widthProperty().multiply(COL_HEIGHT_RATIO));
        varName.setCellValueFactory(new PropertyValueFactory<Variable,String>(VAR_NAME_FIELD));
        varVal = new TableColumn(VAR_VAL_COL);
        varVal.prefWidthProperty().bind(varTable.widthProperty().multiply(COL_HEIGHT_RATIO));
        varVal.setCellValueFactory(new PropertyValueFactory<Variable,String>(VAR_VAL_FIELD));
        myVarPaneModel.registerObserverData(varTable);
        varTable.setEditable(true);
        varTable.getColumns().addAll(varName,varVal);
    }


}
