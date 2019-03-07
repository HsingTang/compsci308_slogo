package View;


import Controller.Controller;
import Controller.ControllerInterface;
import View.GUIFeatures.Panes.*;
import View.Turtles.TurtleView;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Hsingchih Tang
 * @author Eric Lin
 * An independent tab managing its own Turtle, commands and variables
 */
public class SlogoTab extends Tab implements IView {

    static final String STYLE_SHEET = "stylesheets/StyleWindow.css";
    static final String TAB_STRING = "Tab ";
    static final Double CANVAS_RATIO = (3.0/5.0);
    static final Double DEFAULT_PADDING_Y = 15.0;
    static final Double DEFAULT_PADDING_X = 30.0;

    private Stage myStage;
    private Integer myID;
    private BorderPane myPane;
    private CanvasPane myCanvasPane;
    private Double myWidth;
    private Double myHeight;
    private TurtleView myTurtle;
    private ControllerInterface myController;
    private Window myWindow;

    public SlogoTab(int id, double width, double height, Controller controller, Stage stage, Window window) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        myStage = stage;
        myController = controller;
        myWindow = window;
        myID = id;
        myWidth = width;
        myHeight = height;
        myTurtle = this.myController.getTurtleView(id);
        Label tabTitle = new Label(TAB_STRING + id);
        initPanes();
        setContent(myPane);
        setTurtleView(this.myController.getTurtleView(id));
        setGraphic(tabTitle);
        this.myPane.getStylesheets().add(STYLE_SHEET);
        this.myPane.getStyleClass().add("this");
    }

    @Override
    public void notifyConsole() {

    }

    @Override
    public void notifyVariablePane() {

    }

    @Override
    public void notifyCommandHistory() {

    }

    @Override
    public void notifyEnvironment() {

    }

    @Override
    public void notifyTurtleView() {

    }

    public void setTurtleView(TurtleView t){
        myCanvasPane.initTurtleView(t);
    }


    private void initPanes() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        myPane = new BorderPane();
        myPane.setMaxSize(myWidth,myHeight);
        myPane.setPadding(new Insets(DEFAULT_PADDING_Y, DEFAULT_PADDING_X, DEFAULT_PADDING_Y, DEFAULT_PADDING_X));
        initCanvasPane();
        initTopPane();
        initBottomPane();
        initVarPane();
        initCommandPane();
    }


    private void initTopPane() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        myPane.setTop(new TopPane(myHeight, myCanvasPane, myController, myWindow, myTurtle, myStage));
    }

    private void initBottomPane() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        myPane.setBottom(new BottomPane(myHeight, myCanvasPane, myController, myID, myTurtle));
    }

    private void initCanvasPane(){
        myCanvasPane = new CanvasPane(myHeight*CANVAS_RATIO,myHeight*CANVAS_RATIO);
        myPane.setCenter(myCanvasPane);
    }

    private void initVarPane(){
        VariablePane myVarPane = new VariablePane(myWidth/3-myCanvasPane.getCanvasWidth()/3,myHeight);
        myVarPane.setupModel(myController.getVarModel(myID));
        myPane.setLeft(myVarPane);
    }

    private void initCommandPane(){
        CommandHistoryPane myCommandPane = new CommandHistoryPane(myWidth/3-myCanvasPane.getCanvasHeight()/3,myHeight);
        myCommandPane.setupModel(myController.getCommandModel(myID));
        myPane.setRight(myCommandPane);
    }

    private void addToHistory(String commands) {

    }
}
