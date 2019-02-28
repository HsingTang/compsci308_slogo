package View;

import Model.ModelInterfaces.ModelInterface;
import Model.TurtleModel;
import View.Turtles.TurtleView;
import View.Window;

public class Controller {
    Window myMaster;
    ModelInterface model;
    TurtleView turtleView;

    public Controller(ModelInterface model, TurtleView view) {
        this.model = model;
        this.turtleView = view;

    }
}
