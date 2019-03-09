package Controller;

import CommandTree.CommandRoot;
import CommandTree.StringParser;
import Errors.SlogoException;
import Handlers.CommandHandler;
import Handlers.HandlerInterfaces.CommandHandlerInterface;
import Model.CommandPaneModel;
import Model.ReturnValModel;
import Model.TurtleModel;
import Model.VariablePaneModel;
import View.Turtles.TurtleFactory;
import View.Turtles.TurtleView;
import View.Window;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Controller implements ControllerInterface {
    HashMap<Integer,TurtleView> myTurtleViews;
    HashMap<Integer,TurtleModel>myTurtleModels;
    HashMap<Integer,VariablePaneModel> myVarModels;
    HashMap<Integer, CommandPaneModel> myCommandModels;
    HashMap<Integer,ReturnValModel> myReturnValModels;
    HashMap<CommandHandlerInterface, String> myCommandHandlerMap;
    Queue<CommandHandlerInterface> myCommandHandlers;
    StringParser myParser;
    TurtleFactory myTurtleFactory;
    private int turtleNumber = 0;
    private String myLanguage = "English";
    private Window myWindow;
    // private boolean executing = false;

    public Controller(Window window) {
        this.turtleNumber = 0;
        this.myTurtleFactory = new TurtleFactory();
        this.myTurtleViews = new HashMap<>();
        this.myTurtleModels = new HashMap<>();
        this.myVarModels = new HashMap<>();
        this.myCommandModels = new HashMap<>();
        this.myReturnValModels = new HashMap<>();
        this.myCommandHandlers = new LinkedList<>();
        this.myCommandHandlerMap = new HashMap<>();
        this.myParser = new StringParser();
        this.myWindow = window;
    }

    public void initNewTab(){
        VariablePaneModel addVarModel = new VariablePaneModel();
        CommandPaneModel addCommandModel = new CommandPaneModel();
        ReturnValModel addReturnValModel = new ReturnValModel();
        TurtleModel addTurtleModel = new TurtleModel();
        TurtleView addTurtleView = myTurtleFactory.makeTurtle(turtleNumber,addTurtleModel);
        myTurtleViews.put(turtleNumber,addTurtleView);
        myTurtleModels.put(turtleNumber,addTurtleModel);
        myVarModels.put(turtleNumber,addVarModel);
        myCommandModels.put(turtleNumber,addCommandModel);
        myReturnValModels.put(turtleNumber,addReturnValModel);
        turtleNumber++;
    }

    public void removeLastTab(){
        myTurtleViews.remove(myTurtleViews.get(turtleNumber-1));
        myTurtleModels.remove(myTurtleModels.get(turtleNumber-1));
        myVarModels.remove(myVarModels.get(turtleNumber-1));
        myCommandModels.remove(myCommandModels.get(turtleNumber-1));
        myReturnValModels.remove(myReturnValModels.get(turtleNumber-1));
    }

    public void removeTab(int id){
        myTurtleViews.remove(myTurtleViews.get(id));
        myTurtleModels.remove(myTurtleModels.get(id));
        myVarModels.remove(myVarModels.get(id));
        myCommandModels.remove(myCommandModels.get(id));
    }

    public void receiveCommand(String command, int id) {
        System.out.println("command received: "+command);
        System.out.println("parsing result: ");
        for (String s: myParser.parseCommand(command)){
            System.out.println(s);
        }
        CommandHandlerInterface addCommandHandler;
        try{
            addCommandHandler = new CommandHandler(myTurtleModels.get(id), myVarModels.get(id), myCommandModels.get(id), myReturnValModels.get(id));
            myCommandHandlerMap.put(addCommandHandler,command);
            myCommandHandlers.add(addCommandHandler);
            executeCommands(id);
        }catch (SlogoException e){
            myWindow.invokeAlert(e);
        }
    }

    private void executeCommands(int id){
        while(!myCommandHandlers.isEmpty()){
            CommandHandlerInterface currHandler = myCommandHandlers.poll();
            try{
                CommandRoot root = new CommandRoot(this.myParser.parseCommand(myCommandHandlerMap.get(currHandler)), currHandler, myTurtleViews.get(id));
                root.execute();
            }catch (SlogoException e){
                myWindow.invokeAlert(e);
            }
        }
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

    public ReturnValModel getReturnValModel(int id){
        return myReturnValModels.get(id);
    }
}
