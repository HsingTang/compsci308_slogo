package Controller;

import CommandTree.CommandRoot;
import CommandTree.StringParser;
import Handlers.CommandHandler;
import Handlers.HandlerInterfaces.CommandHandlerInterface;
import Model.TurtleModel;
import View.Turtles.TurtleFactory;
import View.Turtles.TurtleView;

import java.util.ArrayList;
import java.util.HashMap;

public class Controller implements ControllerInterface {
    TurtleModel model;
    HashMap<Integer,TurtleView> myTurtleViews;
    HashMap<Integer,TurtleModel>myTurtleModels;
    TurtleView turtleView;
    ArrayList<CommandHandlerInterface> myCommandHandlers;
    CommandHandlerInterface commandHandler;
    StringParser myParser;
    TurtleFactory myTurtleFactory;
    private int turtleNumber = 0;

    public Controller() {
        this.turtleNumber = 0;
        this.myTurtleFactory = new TurtleFactory();
        this.myTurtleViews = new HashMap<>();
        this.myTurtleModels = new HashMap<>();
        this.myCommandHandlers = new ArrayList<>();
        this.myParser = new StringParser();
    }

    public void initNewTab(){
        TurtleModel addTurtleModel = new TurtleModel();
        TurtleView addTurtleView = myTurtleFactory.makeTurtle(turtleNumber,addTurtleModel);
        CommandHandlerInterface addCommandHandler = new CommandHandler(addTurtleModel);
        myTurtleViews.put(turtleNumber,addTurtleView);
        myTurtleModels.put(turtleNumber,addTurtleModel);
        myCommandHandlers.add(addCommandHandler);
        turtleNumber++;
    }

    public void execute(String command) {
        CommandRoot root = new CommandRoot(this.myParser.parseCommand(command), commandHandler);
        root.execute();
    }

    public void setLanguage(String language) {
        this.myParser.setLanguage(language);
    }

    public TurtleView getTurtleView(int id){
        return myTurtleViews.get(id);
    }

    public TurtleModel getTurtleModel(int id){
        return myTurtleModels.get(id);
    }
}
