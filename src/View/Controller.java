package View;

import CommandTree.CommandRoot;
import CommandTree.StringParser;
import Handlers.CommandHandler;
import Handlers.HandlerInterfaces.CommandHandlerInterface;
import Model.ModelInterfaces.ModelInterface;
import Model.TurtleModel;
import View.Turtles.TurtleView;
import View.Window;

public class Controller {
    Window myMaster;
    ModelInterface model;
    TurtleView turtleView;
    CommandHandlerInterface commandHandler;
    StringParser myParser;

    public Controller(ModelInterface model, TurtleView view) {
        this.model = model;
        this.turtleView = view;
        this.commandHandler = new CommandHandler(model);
        this.myParser = new StringParser();


    }

    public void execute(String command) {
        CommandRoot root = new CommandRoot(this.myParser.parseCommand(command), commandHandler);
        root.execute();
    }
}
