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
import java.util.Map;
import java.util.Queue;

/**
 * Main controller that bridges View and Model components. Controller is notified by Window (front end) each time
 * a new tab is created, and then invokes Model classes to be associated with the new View components via ID number.
 * There is only one instance of Controller for the whole program, which manages multiple View/Model pairs.
 * @author Hsingchih Tang
 * @author Eric Lin
 */
public class Controller implements ControllerInterface {
    private Map<Integer,TurtleView> myTurtleViews;
    private Map<Integer,TurtleModel> myTurtleModels;
    private Map<Integer,VariablePaneModel> myVarModels;
    private Map<Integer, CommandPaneModel> myCommandModels;
    private Map<Integer,ReturnValModel> myReturnValModels;
    private Map<CommandHandlerInterface, String> myCommandHandlerMap;
    private Queue<CommandHandlerInterface> myCommandHandlers;
    private StringParser myParser;
    private TurtleFactory myTurtleFactory;
    private int turtleNumber = 0;
    private Window myWindow;

    /**
     * Creates an instance of the controller
     * @param window the Window which invokes the Controller's constructor
     */
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

    /**
     * Initializes the new Model components to be connected with front-end View components in the new tab
     * This function is invoked by Window each time a new tab is created
     */
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

    /**
     * Removes the Model components for the last tab created
     */
    public void removeLastTab(){
        myTurtleViews.remove(myTurtleViews.get(turtleNumber-1));
        myTurtleModels.remove(myTurtleModels.get(turtleNumber-1));
        myVarModels.remove(myVarModels.get(turtleNumber-1));
        myCommandModels.remove(myCommandModels.get(turtleNumber-1));
        myReturnValModels.remove(myReturnValModels.get(turtleNumber-1));
    }

    /**
     * Removes the Model components for the tab indicated by the id number
     * @param id the tab's id number which maps to corresponding Model components in the map
     */
    public void removeTab(int id){
        myTurtleViews.remove(myTurtleViews.get(id));
        myTurtleModels.remove(myTurtleModels.get(id));
        myVarModels.remove(myVarModels.get(id));
        myCommandModels.remove(myCommandModels.get(id));
    }

    /**
     * Receives a new command from one of the tabs on the front end
     * @param command the command to be processed in String format
     * @param id the id of the tab which transfers current command
     */
    public void receiveCommand(String command, int id) {
//        System.out.println("command received: "+command);
//        System.out.println("parsing result: ");
//        for (String s: myParser.parseCommand(command)){
//            System.out.println(s);
//        }
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

    /**
     * Invoke the CommandHandler for command execution
     * @param id of the caller tab which transferred this command
     */
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

    /**
     * Sets language of the parser
     * @param language  language to set the parser to
     */
    public void setLanguage(String language) {
        String myLanguage = language;
        this.myParser.setLanguage(myLanguage);
    }

    /**
     * @param id of the tab whose View component triggers this function
     * @return the corresponding TurtleView object mapped by the tab id for GUI display
     */
    public TurtleView getTurtleView(int id){
        return myTurtleViews.get(id);
    }

    /**
     * @param id of the tab whose View component triggers this function
     * @return the TurtleModel object associated to the TurtleView held by the caller tab
     */
    public TurtleModel getTurtleModel(int id){
        return myTurtleModels.get(id);
    }

    /**
     * @param id of the tab whose View component triggers this function
     * @return the VariablePaneModel object associated to the VariablePane held by the caller tab
     */
    public VariablePaneModel getVarModel(int id){
        return myVarModels.get(id);
    }

    /**
     * @param id of the tab whose View component triggers this function
     * @return the CommandPaneModel object associated to the CommandHistoryPane held by the caller tab
     */
    public CommandPaneModel getCommandModel(int id){
        return myCommandModels.get(id);
    }

    /**
     * @param id of the tab whose View component triggers this function
     * @return the ReturnValModel object associated to the Console held by the caller tab
     */
    public ReturnValModel getReturnValModel(int id){
        return myReturnValModels.get(id);
    }
}
