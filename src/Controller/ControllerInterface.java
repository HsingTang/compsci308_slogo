package Controller;

import Model.TurtleModel;
import View.Turtles.TurtleView;

public interface ControllerInterface {

    void execute(String command, int id);

    void setLanguage(String language);

    TurtleView getTurtleView(int id);

    TurtleModel getTurtleModel(int id);
}
