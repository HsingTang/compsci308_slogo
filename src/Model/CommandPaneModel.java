package Model;

import CommandNodes.UserCommandNode;
import Model.ModelInterfaces.IModel;
import View.GUIFeatures.Panes.HistoricalCommand;
import View.ObserverInterfaces.IObserver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CommandPaneModel implements IModel {


    private ArrayList<IObserver> myObservers;
    private ArrayList<HistoricalCommand> myCommandHistory;
    private HashMap<String, CommandInfo> myCommands;


    public CommandPaneModel(){
        myCommandHistory = new ArrayList<>();
        myObservers = new ArrayList<>();
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

    @Override
    public void registerObserver(IObserver o) {
        myObservers.add(o);
    }

    @Override
    public void removeObserver(IObserver o) {
        myObservers.remove(o);
    }

    @Override
    public void notifyObserver() {
        for (IObserver o:myObservers){
            o.updateData();
        }
    }

    @Override
    public List<HistoricalCommand> getData(){
        return Collections.unmodifiableList(myCommandHistory);
    }
}
