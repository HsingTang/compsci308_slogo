package Controller;

import CommandTree.CommandRoot;
import CommandTree.StringParser;
import Handlers.CommandHandler;
import Handlers.HandlerInterfaces.CommandHandlerInterface;
import Model.TurtleModel;
import View.Turtles.TurtleFactory;
import View.Turtles.TurtleView;

public class Controller implements ControllerInterface {
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
        this.commandHandler = new CommandHandler(model);
        this.myParser = new StringParser();
    }

    public void execute(String command) {
        CommandRoot root = new CommandRoot(this.myParser.parseCommand(command), commandHandler);
        root.execute();
    }

    public void setLanguage(String language) {
        this.myParser.setLanguage(language);
    }

    public TurtleView getTurtleView(){
        return this.turtleView;
    }
}
