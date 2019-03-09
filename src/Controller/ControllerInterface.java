package Controller;

import Model.CommandPaneModel;
import Model.ReturnValModel;
import Model.TurtleModel;
import Model.VariablePaneModel;
import View.Turtles.TurtleView;

public interface ControllerInterface {

    void receiveCommand(String command, int id);

    void setLanguage(String language);

    void initNewTab();

    void removeLastTab();

    void removeTab(int id);

    TurtleView getTurtleView(int id);

    TurtleModel getTurtleModel(int id);

    VariablePaneModel getVarModel(int id);

    CommandPaneModel getCommandModel(int id);

    ReturnValModel getReturnValModel(int id);

}
