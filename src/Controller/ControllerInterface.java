package Controller;

import Model.CommandPaneModel;
import Model.TurtleModel;
import Model.VariablePaneModel;
import View.Turtles.TurtleView;

public interface ControllerInterface {

    void execute(String command, int id);

    void setLanguage(String language);

    void initNewTab();

    TurtleView getTurtleView(int id);

    TurtleModel getTurtleModel(int id);

    VariablePaneModel getVarModel(int id);

    CommandPaneModel getCommandModel(int id);


}
