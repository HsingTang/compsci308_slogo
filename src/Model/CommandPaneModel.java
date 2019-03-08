package Model;

import View.GUIFeatures.Panes.HistoricalCommand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommandPaneModel extends PaneModel {

    private ArrayList<HistoricalCommand> myCommandHistory;

    public CommandPaneModel(){
        super();
        myCommandHistory = new ArrayList<>();
    }

    public List<HistoricalCommand> getData(){
        return Collections.unmodifiableList(myCommandHistory);
    }
}
