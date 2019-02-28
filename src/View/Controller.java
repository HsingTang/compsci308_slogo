package View;

import CommandTree.CommandRoot;
import CommandTree.StringParser;
import Handlers.CommandHandler;
import Handlers.HandlerInterfaces.CommandHandlerInterface;
import Model.ModelInterfaces.ModelInterface;
import Model.TurtleModel;
import View.Turtles.TurtleFactory;
import View.Turtles.TurtleView;
import View.Window;

public class Controller {
    Window myMaster;
    TurtleModel model;
    TurtleView turtleView;
    CommandHandlerInterface commandHandler;
    StringParser myParser;
    TurtleFactory myTurtleFactory;
    private int turtleNumber = 0;

    public Controller() {
        this.myTurtleFactory = new TurtleFactory();
        this.model = new TurtleModel();
        this.turtleView = this.myTurtleFactory.makeTurtle(turtleNumber,this.model);
        this.model.registerTurtleObserver(this.turtleView);
        this.commandHandler = new CommandHandler(model);
        this.myParser = new StringParser();
    }

    public void execute(String command) {
        CommandRoot root = new CommandRoot(this.myParser.parseCommand(command), commandHandler);
        root.execute();
    }

    public TurtleView getTurtleView(){
        return this.turtleView;
    }
}
