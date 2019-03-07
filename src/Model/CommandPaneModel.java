package Model;

import Model.ModelInterfaces.IModel;
import View.GUIFeatures.Panes.HistoricalCommand;
import View.ObserverInterfaces.IObserver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommandPaneModel implements IModel {


    private ArrayList<IObserver> myObservers;
    private ArrayList<HistoricalCommand> myCommandHistory;

    public CommandPaneModel(){
        myCommandHistory = new ArrayList<>();
        myObservers = new ArrayList<>();
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
