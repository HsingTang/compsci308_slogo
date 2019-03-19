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
 * Right-hand section of the GUI for displaying previously entered commands via JavaFX TableView feature
 * There should be one CommandHistoryPane per tab
 */
public class CommandHistoryPane extends StackPane implements IObserver {
    static final String COMMAND_COL = "Historical Commands";
    static final String COMMAND_CONTENT_FIELD = "myContent";
    private TableView commandTable;
    private IModel myCommandPaneModel;

    /**
     * Instantiates an instance of CommandHistoryPane
     * @param w width of the table
     * @param h height of the table
     */
    public CommandHistoryPane(double w, double h){
        super();
        this.setMaxWidth(w);
        this.setHeight(h);
        this.setAlignment(Pos.CENTER);
    }

    /**
     * Sets up the CommandHistoryPane's corresponding back-end Model
     * @param model the Model component to be associated to this CommandHistoryPane
     */
    @Override
    public void setupModel(IModel model){
        myCommandPaneModel = model;
        initTable();
        this.getChildren().addAll(commandTable);
    }

    /**
     * @return the VariablePane's corresponding back-end Model
     */
    @Override
    public IModel getModel() {
        return myCommandPaneModel;
    }


    private void initTable(){
        commandTable = new TableView();
        TableColumn commandCol = new TableColumn(COMMAND_COL);
        commandCol.prefWidthProperty().bind(commandTable.widthProperty());
        commandCol.setCellValueFactory(new PropertyValueFactory<HistoricalCommand, String>(COMMAND_CONTENT_FIELD));
        myCommandPaneModel.registerObserverData(commandTable);
        commandTable.setEditable(false);
        commandTable.getColumns().addAll(commandCol);
    }
}
