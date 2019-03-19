package Model;

import View.GUIFeatures.Panes.HistoricalCommand;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.util.*;

/**
 * @author Mary Gooneratne
 * @author Hsingchih Tang
 * Back-end Model component corresponding to the CommandHistoryPane on the front end
 * There should be one CommandPaneModel paired to each CommandHistoryPane
 * Concrete subclass extending the abstract PaneModel class, which implements IModel interface
 */
public class CommandPaneModel extends PaneModel {
    private ObservableList<HistoricalCommand> myCommandList;
    private Map<String, CommandInfo> myCommands;

    /**
     * Instantiates a new CommandPaneModel object
     */
    public CommandPaneModel(){
        super();
        myCommands = new HashMap<>();
        myCommandList = FXCollections.observableArrayList();
    }

    /**
     * Records a new command entered by user and notifies front-end observers of the data update
     * @param info
     */
    public void makeCommand(CommandInfo info){
        this.myCommands.put(info.getName(), info);
    }

    /**
     * @param name String content of the command
     * @return the CommandInfo object associated to this String command
     */
    public CommandInfo getCommand(String name){
        return this.myCommands.get(name);
    }

    /**
     * @param name String content of the command
     * @return boolean value indicating whether the queried command exists in records
     */
    public boolean isCommand(String name){
        return myCommands.keySet().contains(name);
    }

    /**
     * @author Mary Gooneratne
     * @return Commands already recorded by the Model
     */
    public Map getCommands(){
        return this.myCommands;
    }


    @Override
    public void registerObserverData(Object o) {
        ((TableView)(o)).setItems(myCommandList);
    }

    /**
     * Records a new command
     * @param name String content of the new command to record
     */
    public void addToHistory(String name){
        HistoricalCommand hist = new HistoricalCommand(name);
        myCommandList.add(hist);
    }
}
