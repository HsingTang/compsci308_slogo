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
    HashMap<Integer,TurtleView> myTurtleViews;
    HashMap<Integer,TurtleModel>myTurtleModels;
    ArrayList<CommandHandlerInterface> myCommandHandlers;
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
        myTurtleViews.put(turtleNumber,addTurtleView);
        myTurtleModels.put(turtleNumber,addTurtleModel);
        turtleNumber++;
    }

    public void execute(String command, int id) {
        CommandHandlerInterface addCommandHandler = new CommandHandler(myTurtleModels.get(id));
        CommandRoot root = new CommandRoot(this.myParser.parseCommand(command), addCommandHandler);
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
