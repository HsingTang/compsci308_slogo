package Model;

import View.GUIFeatures.Panes.HistoricalCommand;

import java.util.*;

/**
 * @author Mary Gooneratne
 * @author Hsingchih Tang
 * Back-end Model component corresponding to the CommandHistoryPane on the front end
 * There should be one CommandPaneModel paired to each CommandHistoryPane
 * Concrete subclass extending the abstract PaneModel class, which implements IModel interface
 */
public class CommandPaneModel extends PaneModel {
    private List<HistoricalCommand> commandHistory;
    private Map<String, CommandInfo> myCommands;

    /**
     * Instantiates a new CommandPaneModel object
     */
    public CommandPaneModel(){
        super();
        commandHistory = new ArrayList<>();
        myCommands = new HashMap<>();
    }

    /**
     * Records a new command entered by user and notifies front-end observers of the data update
     * @param info
     */
    public void makeCommand(CommandInfo info){
        this.myCommands.put(info.getName(), info);
        notifyObserver();
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

    /**
     * @return recorded commands in an unmodifiable list of HistoricalCommand objects
     */
    public List<HistoricalCommand> getData(){
        return Collections.unmodifiableList(commandHistory);
    }

    /**
     * Empty method that doesn't need to be implemented on CommandHistoryPane/CommandPaneModel pair
     * since only one-way (back to front end) data transfer is expected for this View/Model pair
     */
    @Override
    public void ObserverUpdateModel(Object o) {

    }

    /**
     * Records a new command
     * @param name String content of the new command to record
     */
    public void addToHistory(String name){
        HistoricalCommand hist = new HistoricalCommand(name);
        commandHistory.add(hist);
        notifyObserver();
    }
}
