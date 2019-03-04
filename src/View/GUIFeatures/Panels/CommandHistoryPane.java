package View.GUIFeatures.Panels;

import Model.CommandPaneModel;
import Model.ModelInterfaces.ModelInterface;
import Model.VariablePaneModel;
import View.ObserverInterfaces.ObserverInterface;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

/**
 * @author Hsingchih Tang
 * Displays previously executed commands
 */
public class CommandHistoryPane extends VBox implements ObserverInterface {
    private final String COMMAND_COL = "Historical Commands";
    private final String COMMAND_CONTENT_FIELD = "myContent";
    private TableView commandTable;
    private TableColumn commandCol;
    private ModelInterface myCommandPaneModel;
    private ObservableList<HistoricalCommand> myCommands = FXCollections.observableArrayList(new HistoricalCommand("Placeholder Command"));

    public CommandHistoryPane(double w, double h){
        super();
        initTable();
        this.setWidth(w);
        this.setHeight(h);
        this.getChildren().addAll(commandTable);
        this.setAlignment(Pos.CENTER);
    }

    private void initTable(){
        commandTable = new TableView();
        commandTable.setMinSize(this.getWidth(),this.getHeight());
        commandCol = new TableColumn(COMMAND_COL);
        commandCol.prefWidthProperty().bind(commandTable.widthProperty());
        commandCol.setCellValueFactory(new PropertyValueFactory<HistoricalCommand, String>(COMMAND_CONTENT_FIELD));
        commandTable.setItems(myCommands);
        commandTable.setEditable(false);
        commandTable.getColumns().addAll(commandCol);
    }

    @Override
    public void setupModel(ModelInterface model){
        myCommandPaneModel = model;
        model.registerObserver(this);
    }

    @Override
    public void updateData() {
        this.myCommands.clear();
        this.myCommands.addAll(myCommandPaneModel.getData());
    }
}
