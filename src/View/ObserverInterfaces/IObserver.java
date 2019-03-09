package View.ObserverInterfaces;

import Model.ModelInterfaces.IModel;

/**
 * @author Hsingchih Tang
 */
public interface IObserver {
    void updateData();

    void setupModel(IModel model);

    IModel getModel();

}
