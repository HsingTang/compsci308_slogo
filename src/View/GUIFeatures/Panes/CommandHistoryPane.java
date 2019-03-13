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
    private ObservableList<HistoricalCommand> myCommands = FXCollections.observableArrayList();

    /**
     * Instantiates an instance of CommandHistoryPane
     * @param w width of the table
     * @param h height of the table
     */
    public CommandHistoryPane(double w, double h){
        super();
        initTable();
        this.setMaxWidth(w);
        this.setHeight(h);
        this.getChildren().addAll(commandTable);
        this.setAlignment(Pos.CENTER);
    }

    /**
     * Sets up the CommandHistoryPane's corresponding back-end Model
     * @param model the Model component to be associated to this CommandHistoryPane
     */
    @Override
    public void setupModel(IModel model){
        myCommandPaneModel = model;
        model.registerObserver(this);
    }

    /**
     * @return the VariablePane's corresponding back-end Model
     */
    @Override
    public IModel getModel() {
        return myCommandPaneModel;
    }

    /**
     * Retrieves the list of user-entered commands from the Model
     * and displays the data (String command contents)
     */
    @Override
    public void updateData() {
        this.myCommands.clear();
        this.myCommands.addAll(myCommandPaneModel.getData());
    }

    private void initTable(){
        commandTable = new TableView();
        TableColumn commandCol = new TableColumn(COMMAND_COL);
        commandCol.prefWidthProperty().bind(commandTable.widthProperty());
        commandCol.setCellValueFactory(new PropertyValueFactory<HistoricalCommand, String>(COMMAND_CONTENT_FIELD));
        commandTable.setItems(myCommands);
        commandTable.setEditable(false);
        commandTable.getColumns().addAll(commandCol);
    }
}
