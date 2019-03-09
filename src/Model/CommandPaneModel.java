package Model;

import View.GUIFeatures.Panes.HistoricalCommand;

import java.util.*;

/**
 * @author Hsingchih Tang
 */
public class CommandPaneModel extends PaneModel {
    private ArrayList<HistoricalCommand> commandHistory;
    private HashMap<String, CommandInfo> myCommands;


    public CommandPaneModel(){
        super();
        commandHistory = new ArrayList<>();
        myCommands = new HashMap<>();
    }

    public void makeCommand(CommandInfo info){
        this.myCommands.put(info.getName(), info);
        System.out.println("**********: " + info.getName() + ", " + info.getCommandVariables() + ", " + info.getCommandChildren());
        notifyObserver();
    }

    public CommandInfo getCommand(String name){
        return this.myCommands.get(name);
    }


    public boolean isCommand(String name){
        System.out.println("********** " + this.myCommands);
        return myCommands.keySet().contains(name);
    }

    public HashMap getCommands(){
        return this.myCommands;
    }

    public List<HistoricalCommand> getData(){
        this.toData();
        return Collections.unmodifiableList(commandHistory);
    }

    @Override
    public void ObserverUpdateModel(Object o) {

    }

    private void toData(){
        for(String s: myCommands.keySet()){
            HistoricalCommand hist = new HistoricalCommand(s);
            commandHistory.add(hist);
        }
    }
}
