package View;


import Controller.Controller;
import Controller.ControllerInterface;
import View.GUIFeatures.Buttons.*;
import View.GUIFeatures.Choosers.CanvasColorChooser;
import View.GUIFeatures.Choosers.LanguageChooser;
import View.GUIFeatures.Choosers.PenColorChooser;
import View.GUIFeatures.Choosers.TurtleChooser;
import View.GUIFeatures.Panes.*;
import View.Turtles.TurtleView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author Hsingchih Tang
 * @author Eric Lin
 * An independent tab managing its own Turtle, commands and variables
 */
public class SlogoTab extends Tab implements IView {
    static final int BUTTON_BOTTOM_GAP = 3;
    static final String CANVAS_TEXT = "Choose Canvas Color";
    static final String PEN_TEXT = "Choose Pen Color";
    static final String STYLE_SHEET = "stylesheets/StyleWindow.css";
    static final String TAB_STRING = "Tab ";
    static final Double CONSOLE_RATIO = (3.0/5.0);
    static final Double CANVAS_RATIO = (3.0/5.0);
    static final Double DEFAULT_PADDING_Y = 15.0;
    static final Double DEFAULT_PADDING_X = 30.0;
    static final Double GRIDPANE_PADDING_Y = 5.0;
    static final Double GRIDPANE_PADDING_X = 17.0;
    static final Double CHOOSER_GRID_WIDTH = 400.0;
    static final Double BUTTON_GRID_WIDTH = 250.0;
    public static final int ROW_0 = 0;
    public static final int ROW_1 = 1;
    public static final int ROW_2 = 2;
    public static final int ROW_3 = 3;
    public static final int ROW_4 = 4;
    public static final int COL_0 = 0;
    public static final int COL_1 = 1;
    public static final int COL_2 = 2;
    public static final int COL_3 = 3;
    public static final int COL_4 = 4;
    public static final int COL_5 = 5;


    private Stage myStage;
    private Integer myID;
    private BorderPane myPane;
    private BottomPane myBottomPane;
    private TopPane myTopPane;
    private CanvasPane myCanvasPane;
    private Double myWidth;
    private Double myHeight;
    /*
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
    private ThicknessSlider penSlider;
    private LanguageChooser myLanguageChooser;
    private TurtleChooser myTurtleChooser;
    private CanvasColorChooser myCanvasColorChooser;
    private PenColorChooser myPenColorChooser;
    */
    private TurtleView myTurtle;
    private ControllerInterface myController;
    private Window myWindow;

    public SlogoTab(int id, double width, double height, Controller controller, Stage stage, Window window){
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


    private void initPanes(){
        myPane = new BorderPane();
        myPane.setMaxSize(myWidth,myHeight);
        myPane.setPadding(new Insets(DEFAULT_PADDING_Y, DEFAULT_PADDING_X, DEFAULT_PADDING_Y, DEFAULT_PADDING_X));
        initCanvasPane();
        //initTopPane();
        //initBottomPane();
        myTopPane = new TopPane(myHeight, myCanvasPane, myPane, myController, myWindow, myTurtle, myStage);
        myBottomPane = new BottomPane(myHeight, myCanvasPane, myPane, myController, myID, myTurtle);
        initVarPane();
        initCommandPane();
    }

    /*
    private void initTopPane(){
        // TODO: Refactor w/ reflection and lambda funcs, and migrate codes to TopPane
        myTopPane = new TopPane();
        myPane.setTop(myTopPane);
        myTopPane.setMinHeight(myHeight/10);
        initTopPaneElements();
        myTopPane.add(myCanvasColorChooser, COL_0, ROW_0);
        myTopPane.add(myPenColorChooser, COL_1, ROW_0);
        myTopPane.add(new Text(CANVAS_TEXT), COL_0, ROW_1);
        myTopPane.add(new Text(PEN_TEXT), COL_1, ROW_1);
        myTopPane.add(myAddTabButton,COL_2, ROW_0);
        myTopPane.add(myLanguageChooser,COL_3,ROW_0);
        myTopPane.setHgap(GRIDPANE_PADDING_X);
        myTopPane.setVgap(GRIDPANE_PADDING_Y);
    }
    */

    /*
    private void initTopPaneElements(){
        initLanguageChooser();
        initAddTabButton();
        initCanvasColorChooser();
        initPenColorChooser();
        initTurtleChooser();
    }*/


    private void initCanvasPane(){
        myCanvasPane = new CanvasPane(myHeight*CANVAS_RATIO,myHeight*CANVAS_RATIO);
        myPane.setCenter(myCanvasPane);
    }

    /*
    private void initBottomPane(){
        // TODO: Refactor w/ reflection and lambda funcs, and migrate codes to BottomPane
        myBottomPane = new BottomPane();
        myBottomPane.setMaxHeight(myHeight-myCanvasPane.getPrefHeight()/2);
        myPane.setBottom(myBottomPane);
        initBottomPaneElements();
        myBottomPane.setVgap(GRIDPANE_PADDING_Y);
        myBottomPane.setHgap(GRIDPANE_PADDING_X);
        myBottomPane.add(turnRightButton, COL_3, ROW_1);
        myBottomPane.add(moveForwardButton, COL_2, ROW_0);
        myBottomPane.add(turnLeftButton, COL_1, ROW_1);
        myBottomPane.add(moveBackwardsButton, COL_2, ROW_1);
        myBottomPane.add(penDown, COL_0, ROW_0);
        myBottomPane.add(penUp, COL_0, ROW_1);
        myBottomPane.add(penSlider, COL_0, ROW_2);
        myBottomPane.add(penSlider.getSliderText(), COL_0, ROW_3);
        myBottomPane.add(myConsole,COL_4,ROW_0, 1, 3);
        myBottomPane.add(myExecuteButton, COL_5, ROW_0);
        myBottomPane.add(myClearButton, COL_5, ROW_1);
        myBottomPane.add(myHelpButton, COL_5, ROW_2);
        myBottomPane.setMargin(myConsole,new Insets(10));
        myBottomPane.setMargin(myExecuteButton,new Insets(5));
        myBottomPane.setMargin(myClearButton,new Insets(5));
        myBottomPane.setMargin(myHelpButton,new Insets(5));
    }*/

    /*private void initBottomPaneElements(){
        initConsole();
        initExecuteButton();
        initClearButton();
        initHelpButton();
        //initActionButtons();
    }*/

    /*
    private void initConsole() {
        myConsole = new Console(myHeight* CONSOLE_RATIO,myBottomPane.getMaxHeight());
        StackPane.setAlignment(myConsole, Pos.CENTER);
    }*/

    /*
    private void initAddTabButton(){
        myAddTabButton = new AddTabButton();
        myAddTabButton.setOnAction(e->this.myWindow.addSlogoTab());
        StackPane.setAlignment(myAddTabButton,Pos.TOP_RIGHT);
    }
    */

    /*
    private void initExecuteButton() {
        myExecuteButton = new ExecuteButton();
        myExecuteButton.setOnAction(e -> this.transferCommands());
    }*/

    /*
    private void initClearButton() {
        myClearButton = new ClearButton();
        myClearButton.setOnAction(e -> this.myConsole.clearText());
    }*/

    /*
    private void initHelpButton() {
        myHelpButton = new HelpButton();
        myHelpButton.setOnAction(e -> this.openHelp());
    }*/

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


    /*
    private void initCanvasColorChooser() {
        myCanvasColorChooser = new CanvasColorChooser();
        myCanvasColorChooser.setOnAction(e -> setCanvasBackground());
    }*/

    /*
    private void initPenColorChooser() {
        myPenColorChooser = new PenColorChooser();
        myPenColorChooser.setOnAction(e -> setPenColor());
    }*/

    /*
    private void initTurtleChooser() {
        myTurtleChooser = new TurtleChooser();
        myTurtleChooser.getButton().setOnAction(e -> changeTurtleImage());
        StackPane.setAlignment(myTurtleChooser.getButton(), Pos.CENTER);
    }*/

    /*
    private void initActionButtons(){
        moveForwardButton = new ForwardButton();
        moveBackwardsButton = new BackwardsButton();
        turnLeftButton = new LeftRotateButton();
        turnRightButton = new RightRotateButton();
        penDown = new PenDownButton();
        penUp = new PenUpButton();
        penSlider = new ThicknessSlider();
        moveForwardButton.setOnAction(e -> buttonTransferCommands(moveForwardButton));
        moveBackwardsButton.setOnAction(e -> buttonTransferCommands(moveBackwardsButton));
        turnLeftButton.setOnAction(e -> buttonTransferCommands(turnLeftButton));
        turnRightButton.setOnAction(e -> buttonTransferCommands(turnRightButton));
        penDown.setOnAction(e -> buttonTransferCommands(penDown));
        penUp.setOnAction(e -> buttonTransferCommands(penUp));
        penSlider.setOnMousePressed(e -> penSlider.changeThickness(myTurtle.getPen()));
        penSlider.valueChangingProperty().addListener((ObservableValue<? extends Boolean> obs, Boolean wasChanging, Boolean isNowChanging) -> {
            if (!isNowChanging) {
                penSlider.changeThickness(myTurtle.getPen());
            }
        });
    }*/

    /*
    private void initLanguageChooser() {
        myLanguageChooser = new LanguageChooser();
        myLanguageChooser.setOnAction(e -> setLanguage());
    }

    private void setCanvasBackground(){
        Color color = myCanvasColorChooser.getValue();
        myCanvasPane.setCanvasColor(color);
    }

    private void setPenColor() {
        Color color = myPenColorChooser.getValue();
        myTurtle.getPen().setColor(color);
    }

    private void setLanguage(){
        this.myController.setLanguage(myLanguageChooser.getValue().toString());
    }*/

    /*
    private void buttonTransferCommands(Button b) {
        String command = b.getId();
        this.myController.receiveCommand(command, myID);
        addToHistory(command);
    }*/

    /*
    private void transferCommands(){
        String commands = myConsole.getText();
        this.myController.receiveCommand(commands,myID);
        addToHistory(commands);
        this.myConsole.clearText();
    }*/

    /*
    private void openHelp() {
        File file = new File("resources/Help_Page.html");
        try {
            Desktop.getDesktop().open(file);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }*/

    /*
    private void changeTurtleImage() {
        File dataFile = myTurtleChooser.getTurtleChooser().showOpenDialog(myStage);
        try {
            Image newImage = new Image(dataFile.toURI().toURL().toExternalForm());
            myTurtle.setImgView(newImage);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    */

    private void addToHistory(String commands) {

    }
}
