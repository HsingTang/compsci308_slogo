package Model;

import View.GUIFeatures.Panes.HistoricalCommand;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author Hsingchih Tang
 */
public class CommandPaneModel extends PaneModel {
    private List<HistoricalCommand> commandHistory;
    private Map<String, CommandInfo> myCommands;


    public CommandPaneModel(){
        super();
        commandHistory = new ArrayList<>();
        myCommands = new HashMap<>();
    }

    public void makeCommand(CommandInfo info){
        this.myCommands.put(info.getName(), info);
        notifyObserver();
    }

    public CommandInfo getCommand(String name){
        return this.myCommands.get(name);
    }


    public boolean isCommand(String name){
        return myCommands.keySet().contains(name);
    }

    public Map getCommands(){
        return this.myCommands;
    }

    public List<HistoricalCommand> getData(){
        return Collections.unmodifiableList(commandHistory);
    }

    @Override
    public void ObserverUpdateModel(Object o) {

    }

    public void addToHistory(String name){
        HistoricalCommand hist = new HistoricalCommand(name);
        commandHistory.add(hist);
        notifyObserver();
    }
}
