package View.ObserverInterfaces;

import Model.ModelInterfaces.IModel;

/**
 * @author Hsingchih Tang
 * Front-end Observer interface implemented by CommandHistoryPane, VariablePane, etc.,
 * so that they may interact with their back-end Model components.
 */
public interface IObserver {
    void updateData();

    void setupModel(IModel model);

    IModel getModel();

}
