import Model.ModelInterfaces.ModelInterface;
import Model.TurtleModel;
import View.Turtles.TurtleView;
import View.Window;

public class Controller {
    Window myMaster;
    ModelInterface model;
    TurtleView turtleView;

    public Controller() {
    }

    public static void main(String[] args){
        TurtleModel model = new TurtleModel();
        Controller c = new Controller();
        c.myMaster = new Window();
        c.myMaster.launchMaster(args);

    }
}
