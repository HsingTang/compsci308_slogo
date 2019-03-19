package Model;

import Model.ModelInterfaces.IModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Abstract class that is extended by VariablePaneModel and CommandHistoryModel to realize Model/View interactions
 */
public abstract class PaneModel implements IModel {

    /**
     * Instantiates a new PaneModel object and set up necessary field
     */
    public PaneModel(){
    }


    @Override
    public abstract void registerObserverData(Object o);

}
