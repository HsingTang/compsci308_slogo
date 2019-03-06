package View;


import Controller.Controller;
import Controller.ControllerInterface;
import View.GUIFeatures.Buttons.*;
import View.GUIFeatures.Choosers.CanvasColorChooser;
import View.GUIFeatures.Choosers.LanguageChooser;
import View.GUIFeatures.Choosers.PenColorChooser;
import View.GUIFeatures.Choosers.TurtleChooser;
import View.GUIFeatures.Panels.*;
import View.Turtles.TurtleView;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;


/**
 * @author Hsingchih Tang
 * @author Eric Lin
 * An independent tab managing its own Turtle, commands and variables
 */
public class SlogoTab extends Tab implements ViewInterface {
    public static final int BUTTON_BOTTOM_GAP = 3;
    static final String STYLE_SHEET = "stylesheets/StyleWindow.css";
    static final String TAB_STRING = "Tab ";
    static final Double CONSOLE_RATIO = (3.0/5.0);
    static final Double CANVAS_RATIO = (3.0/5.0);
    static final Double DEFAULT_PADDING_Y = 15.0;
    static final Double DEFAULT_PADDING_X = 30.0;
    static final Double CHOOSER_SPACING = 5.0;
    static final Double CHOOSER_GRID_WIDTH = 400.0;
    static final Double BUTTON_GRID_WIDTH = 250.0;
    static final int ROW_0 = 0;
    static final int ROW_1 = 1;
    static final int ROW_2 = 2;
    static final int ROW_3 = 3;
    static final int ROW_4 = 4;
    static final int HELP_BUTTON_ROW = 11;
    static final int COL_0 = 0;
    static final int COL_1 = 1;
    static final int COL_2 = 2;
    static final int COL_3 = 3;
    static final int COL_4 = 4;


    private Stage myStage;
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
    private Button myHelpButton;
    private Button myAddTabButton;
    private Button moveForwardButton;
    private Button moveBackwardsButton;
    private Button turnLeftButton;
    private Button turnRightButton;
    private Button penUp;
    private Button penDown;
    private GridPane topLeftGrid;
    private GridPane topRightGrid;
    private GridPane buttonGrid;
    private GridPane bottomLeftGrid;
    private LanguageChooser myLanguageChooser;
    private TurtleChooser myTurtleChooser;
    private VariablePane myVarPane;
    private CommandHistoryPane myCommandPane;
    private SlogoCanvas myCanvas;
    private CanvasColorChooser myCanvasColorChooser;
    private PenColorChooser myPenColorChooser;
    private TurtleView myTurtle;
    private Label tabTitle;
    private ControllerInterface myController;
    private Window myWindow;

    public SlogoTab(int id, double width, double height, Controller controller, Stage stage, Window window){
        myStage = stage;
        myController = controller;
        myWindow = window;
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
        myPane.setPadding(new Insets(DEFAULT_PADDING_Y, DEFAULT_PADDING_X, DEFAULT_PADDING_Y, DEFAULT_PADDING_X));
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
        initAddTabButton();
        initCanvasColorChooser();
        initPenColorChooser();
        initTurtleChooser();
        initTopLeftGrid();
        initTopRightGrid();
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
        initHelpButton();
        initActionButtons();
        initBottomButtonGrid();
        initBottomLeftGrid();
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

    private void initAddTabButton(){
        myAddTabButton = new AddTabButton();
        myAddTabButton.setOnAction(e->this.myWindow.addSlogoTab());
        StackPane.setAlignment(myAddTabButton,Pos.TOP_RIGHT);
    }

    private void initExecuteButton() {
        myExecuteButton = new ExecuteButton();
        myExecuteButton.setOnAction(e -> this.transferCommands());
    }

    private void initClearButton() {
        myClearButton = new ClearButton();
        myClearButton.setOnAction(e -> this.myConsole.clearText());
    }

    private void initHelpButton() {
        myHelpButton = new HelpButton();
        myHelpButton.setOnAction(e -> this.openHelp());
    }

    private void initBottomButtonGrid() {
        buttonGrid = new GridPane();
        StackPane.setAlignment(buttonGrid, Pos.BOTTOM_RIGHT);
        buttonGrid.setMaxWidth(BUTTON_GRID_WIDTH);
        buttonGrid.setVgap(CHOOSER_SPACING);
        buttonGrid.add(myExecuteButton, COL_0, ROW_0);
        buttonGrid.add(myClearButton, COL_0, ROW_1);
        buttonGrid.add(myHelpButton, COL_0, HELP_BUTTON_ROW);
        myBottomPane.getChildren().add(buttonGrid);

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
    }

    private void initPenColorChooser() {
        myPenColorChooser = new PenColorChooser();
        myPenColorChooser.setOnAction(e -> setPenColor());
    }

    private void initTurtleChooser() {
        myTurtleChooser = new TurtleChooser();
        myTurtleChooser.getButton().setOnAction(e -> changeTurtleImage());
        StackPane.setAlignment(myTurtleChooser.getButton(), Pos.CENTER);
        myTopPane.getChildren().add(myTurtleChooser.getButton());
    }

    private void initActionButtons(){
        moveForwardButton = new ForwardButton();
        moveBackwardsButton = new BackwardsButton();
        turnLeftButton = new LeftRotateButton();
        turnRightButton = new RightRotateButton();
        penDown = new PenDownButton();
        penUp = new PenUpButton();
        moveForwardButton.setOnAction(e -> buttonTransferCommands(moveForwardButton));
        moveBackwardsButton.setOnAction(e -> buttonTransferCommands(moveBackwardsButton));
        turnLeftButton.setOnAction(e -> buttonTransferCommands(turnLeftButton));
        turnRightButton.setOnAction(e -> buttonTransferCommands(turnRightButton));
        penDown.setOnAction(e -> buttonTransferCommands(penDown));
        penUp.setOnAction(e -> buttonTransferCommands(penUp));
    }

    private void initTopLeftGrid() {
        topLeftGrid = new GridPane();
        topLeftGrid.setMaxWidth(CHOOSER_GRID_WIDTH);
        StackPane.setAlignment(topLeftGrid, Pos.TOP_LEFT);
        Text canvasText = new Text("Choose Canvas Color");
        Text penText = new Text("Choose Pen Color");
        topLeftGrid.add(myCanvasColorChooser, COL_0, ROW_0);
        topLeftGrid.add(myPenColorChooser, COL_0, ROW_1);
        topLeftGrid.add(canvasText, COL_1, ROW_0);
        topLeftGrid.add(penText, COL_1, ROW_1);
        topLeftGrid.setHgap(CHOOSER_SPACING);
        topLeftGrid.setVgap(CHOOSER_SPACING);
        myTopPane.getChildren().add(topLeftGrid);
    }


    private void initTopRightGrid(){
        topRightGrid = new GridPane();
        topRightGrid.setMaxWidth(CHOOSER_GRID_WIDTH);
        StackPane.setAlignment(topRightGrid, Pos.TOP_RIGHT);
        topRightGrid.add(myAddTabButton,COL_0,ROW_0);
        topRightGrid.add(myLanguageChooser,COL_0,ROW_1);
        topRightGrid.setVgap(CHOOSER_SPACING);
        topRightGrid.setAlignment(Pos.CENTER_RIGHT);
        myTopPane.getChildren().add(topRightGrid);
        GridPane.setHalignment(myAddTabButton, HPos.RIGHT);
        GridPane.setValignment(myAddTabButton, VPos.TOP);
        GridPane.setHalignment(myLanguageChooser, HPos.RIGHT);
        GridPane.setValignment(myLanguageChooser, VPos.BOTTOM);
    }

    private void initBottomLeftGrid() {
        bottomLeftGrid = new GridPane();
        StackPane.setAlignment(bottomLeftGrid, Pos.TOP_LEFT);
        bottomLeftGrid.setVgap(BUTTON_BOTTOM_GAP);
        bottomLeftGrid.setHgap(BUTTON_BOTTOM_GAP);
        bottomLeftGrid.setMaxWidth(CHOOSER_GRID_WIDTH);
        bottomLeftGrid.add(turnRightButton, COL_3, ROW_1);
        bottomLeftGrid.add(moveForwardButton, COL_2, ROW_0);
        bottomLeftGrid.add(turnLeftButton, COL_1, ROW_1);
        bottomLeftGrid.add(moveBackwardsButton, COL_2, ROW_1);
        bottomLeftGrid.add(penDown, COL_0, ROW_0);
        bottomLeftGrid.add(penUp, COL_0, ROW_1);
        myBottomPane.getChildren().add(bottomLeftGrid);
    }

    private void initLanguageChooser() {
        myLanguageChooser = new LanguageChooser();
        myLanguageChooser.setOnAction(e -> setLanguage());
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

    private void buttonTransferCommands(Button b) {
        String command = b.getId();
        this.myController.receiveCommand(command, myID);
        addToHistory(command);
    }

    private void transferCommands(){
        String commands = myConsole.getText();
        this.myController.receiveCommand(commands,myID);
        addToHistory(commands);
        this.myConsole.clearText();
    }

    private void openHelp() {
        File file = new File("resources/Help_Page.html");
        try {
            Desktop.getDesktop().open(file);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    private void changeTurtleImage() {
        File dataFile = myTurtleChooser.getTurtleChooser().showOpenDialog(myStage);
        try {
            Image newImage = new Image(dataFile.toURI().toURL().toExternalForm());
            myTurtle.setImgView(newImage);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private void addToHistory(String commands) {

    }
}
