package View.GUIFeatures.Panels;

import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

/**
 * @author Hsingchih Tang
 * Displays previously executed commands
 */
public class CommandHistoryPane extends VBox {
    private final String COMMAND_COL = "Historical Commands";
    private TableView commandTable;
    private TableColumn commandCol;

    public CommandHistoryPane(double w, double h){
        super();
        initTable();
        this.setWidth(w);
        this.setHeight(h);
        this.getChildren().addAll(commandTable);
        this.setAlignment(Pos.CENTER);
    }

    private void initTable(){
        commandCol = new TableColumn(COMMAND_COL);
        commandTable = new TableView();
        commandTable.setMinSize(this.getWidth(),this.getHeight());
        commandCol.prefWidthProperty().bind(commandTable.widthProperty());
        commandTable.setEditable(false);
        commandTable.getColumns().addAll(commandCol);
    }
}
