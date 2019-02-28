import Model.ModelInterfaces.ModelInterface;
import Model.TurtleModel;
import View.Turtles.TurtleView;
import View.Window;

public class Controller {
    Window myWindow;
    ModelInterface model;
    TurtleView turtleView;

    public Controller() {
    }

    public static void main(String[] args){
        TurtleModel model = new TurtleModel();
        Controller c = new Controller();
        c.myWindow = new Window();
        c.myWindow.launchMaster(args);

    }
}
