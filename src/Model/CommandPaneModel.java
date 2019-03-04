package Model;

import Model.ModelInterfaces.ModelInterface;
import View.GUIFeatures.Panels.HistoricalCommand;
import View.ObserverInterfaces.ObserverInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommandPaneModel implements ModelInterface {


    private ArrayList<ObserverInterface> myObservers;
    private ArrayList<HistoricalCommand> myCommandHistory;

    public CommandPaneModel(){
        myCommandHistory = new ArrayList<>();
        myObservers = new ArrayList<>();
    }

    @Override
    public void registerObserver(ObserverInterface o) {
        myObservers.add(o);
    }

    @Override
    public void removeObserver(ObserverInterface o) {
        myObservers.remove(o);
    }

    @Override
    public void notifyObserver() {
        for (ObserverInterface o:myObservers){
            o.updateData();
        }
    }

    @Override
    public List<HistoricalCommand> getData(){
        return Collections.unmodifiableList(myCommandHistory);
    }
}
