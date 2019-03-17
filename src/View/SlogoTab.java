package View;


import Controller.Controller;
import Controller.ControllerInterface;
import Errors.SlogoException;
import View.GUIFeatures.Panes.*;
import View.Turtles.TurtleView;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 * @author Hsingchih Tang
 * @author Eric Lin
 * An independent tab managing its own Turtle, console, commands and variables
 * There can be as many tabs as the user desire, and all tabs reside in the same Window
 */
public class SlogoTab extends Tab{

    static final String STYLE_SHEET = "stylesheets/StyleWindow.css";
    static final String TAB_STRING = "Tab ";
    static final Double CANVAS_RATIO = (3.0/5.0);
    static final Double DEFAULT_PADDING_Y = 15.0;
    static final Double DEFAULT_PADDING_X = 30.0;
    static final Double SIDE_PANE_RATIO = (1.0/3.0);

    private Stage myStage;
    private Integer myID;
    private BorderPane myPane;
    private CanvasPane myCanvasPane;
    private Double myWidth;
    private Double myHeight;
    private TurtleView myTurtle;
    private ControllerInterface myController;
    private Window myWindow;

    /**
     * Instantiates a new SlogoTab object
     * @param id ID number of this SlogoTab (ordered starting from 0 in sequence of creation)
     * @param width width of the window
     * @param height height of the window
     * @param controller Main Controller of the program
     * @param stage Main stage of the program
     * @param window Main Window holding all tabs
     * @throws SlogoException on failure of initiating tab elements
     */
    public SlogoTab(int id, double width, double height, Controller controller, Stage stage, Window window) throws SlogoException{
        myStage = stage;
        myController = controller;
        myWindow = window;
        myID = id;
        myWidth = width;
        myHeight = height;
        myTurtle = this.myController.getTurtleView(id);
        Label tabTitle = new Label(TAB_STRING + id);
        try{
            initPanes();
            setContent(myPane);
            setTurtleView(this.myController.getTurtleView(id));
            setGraphic(tabTitle);
            this.myPane.getStylesheets().add(STYLE_SHEET);
            this.myPane.getStyleClass().add("this");
            this.setOnClosed(e->{myController.removeTab(myID);});
        }catch (SlogoException e){
            throw e;
        }
    }

    /**
     * Calls the tab's Center CanvasPane to set up the TurtleView
     * @param t the TurtleView to be tied to the tab's canvas
     */
    public void setTurtleView(TurtleView t){
        myCanvasPane.initTurtleView(t);
    }

    private void initPanes() throws SlogoException{
        myPane = new BorderPane();
        myPane.setMaxSize(myWidth,myHeight);
        myPane.setPadding(new Insets(DEFAULT_PADDING_Y, DEFAULT_PADDING_X, DEFAULT_PADDING_Y, DEFAULT_PADDING_X));
        try{
            initCanvasPane();
            initTopPane();
            initBottomPane();
            initVarPane();
            initCommandPane();
        }catch (SlogoException e){
            throw e;
        }
    }

    private void initTopPane() throws SlogoException {
        try{
            myPane.setTop(new TopPane(myHeight, myCanvasPane, myController, myWindow, myTurtle, myStage));
        }catch (SlogoException e){
            throw e;
        }
    }

    private void initBottomPane() throws SlogoException{
        try{
            myPane.setBottom(new BottomPane(myHeight, myCanvasPane, myController, myID, myTurtle));
        }catch (SlogoException e){
            throw e;
        }
    }

    private void initCanvasPane(){
        myCanvasPane = new CanvasPane(myHeight*CANVAS_RATIO,myHeight*CANVAS_RATIO);
        myPane.setCenter(myCanvasPane);
    }

    private void initVarPane(){
        VariablePane myVarPane = new VariablePane(myWidth*SIDE_PANE_RATIO-myCanvasPane.getCanvasWidth()*SIDE_PANE_RATIO,myHeight);
        myVarPane.setupModel(myController.getVarModel(myID));
        myPane.setLeft(myVarPane);
    }

    private void initCommandPane(){
        CommandHistoryPane myCommandPane = new CommandHistoryPane(myWidth*SIDE_PANE_RATIO-myCanvasPane.getCanvasHeight()*SIDE_PANE_RATIO,myHeight);
        myCommandPane.setupModel(myController.getCommandModel(myID));
        myPane.setRight(myCommandPane);
    }

}
