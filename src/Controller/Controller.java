package Controller;

import CommandTree.CommandRoot;
import CommandTree.StringParser;
import Handlers.CommandHandler;
import Handlers.HandlerInterfaces.CommandHandlerInterface;
import Model.CommandPaneModel;
import Model.TurtleModel;
import Model.VariablePaneModel;
import View.Turtles.TurtleFactory;
import View.Turtles.TurtleView;

import java.util.ArrayList;
import java.util.HashMap;

public class Controller implements ControllerInterface {
    HashMap<Integer,TurtleView> myTurtleViews;
    HashMap<Integer,TurtleModel>myTurtleModels;
    HashMap<Integer,VariablePaneModel> myVarModels;
    HashMap<Integer, CommandPaneModel> myCommandModels;
    ArrayList<CommandHandlerInterface> myCommandHandlers;
    StringParser myParser;
    TurtleFactory myTurtleFactory;
    private int turtleNumber = 0;
    private String myLanguage = "English";

    public Controller() {
        this.turtleNumber = 0;
        this.myTurtleFactory = new TurtleFactory();
        this.myTurtleViews = new HashMap<>();
        this.myTurtleModels = new HashMap<>();
        this.myVarModels = new HashMap<>();
        this.myCommandModels = new HashMap<>();
        this.myCommandHandlers = new ArrayList<>();
        this.myParser = new StringParser();
    }

    public void initNewTab(){
        VariablePaneModel addVarModel = new VariablePaneModel();
        CommandPaneModel addCommandModel = new CommandPaneModel();
        TurtleModel addTurtleModel = new TurtleModel();
        TurtleView addTurtleView = myTurtleFactory.makeTurtle(turtleNumber,addTurtleModel);
        myTurtleViews.put(turtleNumber,addTurtleView);
        myTurtleModels.put(turtleNumber,addTurtleModel);
        myVarModels.put(turtleNumber,addVarModel);
        myCommandModels.put(turtleNumber,addCommandModel);
        turtleNumber++;
    }

    public void execute(String command, int id) {
        CommandHandlerInterface addCommandHandler = new CommandHandler(myTurtleModels.get(id));
        CommandRoot root = new CommandRoot(this.myParser.parseCommand(command), addCommandHandler);
        root.execute();
    }


    public void setLanguage(String language) {
        myLanguage = language;
        this.myParser.setLanguage(myLanguage);
    }

    public TurtleView getTurtleView(int id){
        return myTurtleViews.get(id);
    }

    public TurtleModel getTurtleModel(int id){
        return myTurtleModels.get(id);
    }

    public VariablePaneModel getVarModel(int id){
        return myVarModels.get(id);
    }

    public CommandPaneModel getCommandModel(int id){
        return myCommandModels.get(id);
    }
}
