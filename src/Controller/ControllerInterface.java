package Controller;

import Model.CommandPaneModel;
import Model.TurtleModel;
import Model.VariablePaneModel;
import View.Turtles.TurtleView;

public interface ControllerInterface {

    void execute(String command, int id);

    void setLanguage(String language);

    TurtleView getTurtleView(int id);

    TurtleModel getTurtleModel(int id);

    public VariablePaneModel getVarModel(int id);

    public CommandPaneModel getCommandModel(int id);
}
