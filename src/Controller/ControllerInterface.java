package Controller;

import View.Turtles.TurtleView;

public interface ControllerInterface {

    void execute(String command);

    void setLanguage(String language);

    TurtleView getTurtleView();
}
