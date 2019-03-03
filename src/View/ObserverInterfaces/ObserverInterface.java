package View.ObserverInterfaces;

import Model.ModelInterfaces.ModelInterface;

public interface ObserverInterface {
    void updateData();

    void setupModel(ModelInterface model);

}
