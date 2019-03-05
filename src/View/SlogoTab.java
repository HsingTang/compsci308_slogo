package View;


import Controller.Controller;
import Controller.ControllerInterface;
import View.GUIFeatures.Buttons.ClearButton;
import View.GUIFeatures.Buttons.ExecuteButton;
import View.GUIFeatures.Choosers.CanvasColorChooser;
import View.GUIFeatures.Choosers.LanguageChooser;
import View.GUIFeatures.Choosers.PenColorChooser;
import View.GUIFeatures.Panels.*;
import View.Turtles.TurtleView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;


/**
 * @author Hsingchih Tang
 * An independent tab managing its own Turtle, commands and variables
 */
public class SlogoTab extends Tab implements ViewInterface {
    static final String STYLE_SHEET = "stylesheets/StyleWindow.css";
    static final String TAB_STRING = "Tab ";
    static final Double CONSOLE_RATIO = (3.0/5.0);
    static final Double CANVAS_RATIO = (3.0/5.0);
    static final Double DEFAULT_PADDING = 30.0;

    private Integer myID;
    private BorderPane myPane;
    private StackPane myBottomPane;
    private StackPane myTopPane;
    private StackPane myCanvasPane;
    private StackPane myLeftPane;
    private StackPane myRightPane;
    private Double myWidth;
    private Double myHeight;
    private Console myConsole;
    private Button myExecuteButton;
    private Button myClearButton;
    private LanguageChooser myLanguageChooser;
    private VariablePane myVarPane;
    private CommandHistoryPane myCommandPane;
    private SlogoCanvas myCanvas;
    private CanvasColorChooser myCanvasColorChooser;
    private PenColorChooser myPenColorChooser;
    private TurtleView myTurtle;
    private Label tabTitle;
    private ControllerInterface myController;

    public SlogoTab(int id, double width, double height, Controller controller){
        myController = controller;
        myID = id;
        myWidth = width;
        myHeight = height;
        tabTitle = new Label(TAB_STRING + id);
        initPanes();
        setContent(myPane);
        setGraphic(tabTitle);
        this.myPane.getStylesheets().add(STYLE_SHEET);
        this.myPane.getStyleClass().add("this");
        this.setTurtleView(this.myController.getTurtleView(id));
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
        this.myTurtle = t;
        initTurtleView();
    }


    private void initPanes(){
        myPane = new BorderPane();
        myPane.setMaxSize(myWidth,myHeight);
        myPane.setPadding(new Insets(DEFAULT_PADDING));
        initCanvasPane();
        initTopPane();
        initBottomPane();
        initLeftPane();
        initRightPane();
    }

    private void initTopPane(){
        myTopPane = new StackPane();
        myPane.setTop(myTopPane);
        initLanguageChooser();
        initCanvasColorChooser();
        initPenColorChooser();
    }

    private void initCanvasPane(){
        myCanvasPane = new StackPane();
        myCanvasPane.setMaxSize(myHeight*CANVAS_RATIO,myHeight*CANVAS_RATIO);
        myPane.setCenter(myCanvasPane);
        initCanvas();
    }

    private void initBottomPane(){
        myBottomPane = new StackPane();
        myBottomPane.setMaxSize(myCanvasPane.getPrefWidth(),myHeight-myCanvasPane.getPrefHeight()/2);
        myPane.setBottom(myBottomPane);
        initConsole();
        initExecuteButton();
        initClearButton();
    }

    private void initLeftPane(){
        myLeftPane = new StackPane();
        myLeftPane.setMaxSize(myWidth-myCanvasPane.getPrefWidth(),myHeight);
        myPane.setLeft(myLeftPane);
        initVarPane();
    }

    private void initRightPane(){
        myRightPane = new StackPane();
        myRightPane.setMaxSize(myWidth-myCanvasPane.getPrefWidth(),myHeight);
        myPane.setRight(myRightPane);
        initCommandPane();
    }

    private void initConsole() {
        myConsole = new Console(myHeight* CONSOLE_RATIO,myBottomPane.getMaxHeight());
        StackPane.setAlignment(myConsole, Pos.CENTER);
        myBottomPane.getChildren().add(myConsole);
    }

    private void initExecuteButton() {
        myExecuteButton = new ExecuteButton();
        myExecuteButton.setOnAction(e -> this.transferCommands());
        StackPane.setAlignment(myExecuteButton, Pos.BOTTOM_RIGHT);
        myBottomPane.getChildren().add(myExecuteButton);
    }

    private void initClearButton() {
        myClearButton = new ClearButton();
        myClearButton.setOnAction(e -> this.myConsole.clearText());
        StackPane.setAlignment(myClearButton, Pos.TOP_RIGHT);
        myBottomPane.getChildren().add(myClearButton);
    }

    private void initVarPane(){
        myVarPane = new VariablePane(myWidth/2-myCanvas.getWidth()/2,myHeight);
        myVarPane.setupModel(myController.getVarModel(myID));
        myLeftPane.getChildren().add(myVarPane);
        myPane.setLeft(myLeftPane);
    }

    private void initCommandPane(){
        myCommandPane = new CommandHistoryPane(myWidth/2-myCanvas.getWidth()/2,myHeight);
        myCommandPane.setupModel(myController.getCommandModel(myID));
        myRightPane.getChildren().add(myCommandPane);
        myPane.setRight(myRightPane);
    }

    private void initTurtleView(){
        myTurtle.setCanvas(myCanvas);
        myCanvasPane.getChildren().add(myTurtle.getImgView());
        myTurtle.setPen(new SlogoPen(myCanvas));
    }

    private void initCanvas() {
        myCanvas = new SlogoCanvas(myHeight*CANVAS_RATIO,myHeight*CANVAS_RATIO);
        StackPane.setAlignment(myCanvas,Pos.CENTER);
        myCanvasPane.getChildren().add(myCanvas);
    }

    private void initCanvasColorChooser() {
        myCanvasColorChooser = new CanvasColorChooser();
        myCanvasColorChooser.setOnAction(e -> setCanvasBackground());
        StackPane.setAlignment(myCanvasColorChooser,Pos.BOTTOM_LEFT);
        myTopPane.getChildren().add(myCanvasColorChooser);
    }

    private void initPenColorChooser() {
        myPenColorChooser = new PenColorChooser();
        myPenColorChooser.setOnAction(e -> setPenColor());
        StackPane.setAlignment(myPenColorChooser, Pos.CENTER);
        myTopPane.getChildren().add(myPenColorChooser);

    }

    private void initLanguageChooser() {
        myLanguageChooser = new LanguageChooser();
        myLanguageChooser.setOnAction(e -> setLanguage());
        StackPane.setAlignment(myLanguageChooser,Pos.CENTER_RIGHT);
        myTopPane.getChildren().add(myLanguageChooser);
    }

    private void setCanvasBackground(){
        Color color = myCanvasColorChooser.getValue();
        myCanvas.setBackgroundColor(color);
    }

    private void setPenColor() {
        Color color = myPenColorChooser.getValue();
        myTurtle.getPen().setColor(color);
    }

    private void setLanguage(){
        this.myController.setLanguage(myLanguageChooser.getValue().toString());
    }

    private void transferCommands(){
        String commands = myConsole.getText();
        this.myController.execute(commands,myID);
        addToHistory(commands);
        this.myConsole.clearText();
    }

    private void addToHistory(String commands) {

    }
}
