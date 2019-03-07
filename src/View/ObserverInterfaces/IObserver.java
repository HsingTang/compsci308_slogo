package View.ObserverInterfaces;

import Model.ModelInterfaces.IModel;

public interface IObserver {
    void updateData();

    void setupModel(IModel model);

    IModel getModel();

}
