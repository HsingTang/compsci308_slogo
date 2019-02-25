package View;


import View.GUIFeatures.Buttons.ClearButton;
import View.GUIFeatures.Buttons.ExecuteButton;
import View.GUIFeatures.Choosers.CanvasColorChooser;
import View.GUIFeatures.Choosers.LanguageChooser;
import View.GUIFeatures.Panels.CommandHistoryPane;
import View.GUIFeatures.Panels.Console;
import View.GUIFeatures.Panels.SlogoCanvas;
import View.GUIFeatures.Panels.VariablePane;
import View.Turtles.TurtleView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.lang.reflect.Field;


/**
 * @author Hsingchih Tang
 * An independent tab managing its own Turtle, commands and variables
 */
public class SlogoTab extends Tab {
    // static final String STYLE_SHEET = "stylesheets/StyleWindow.css";
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
    private TurtleView myTurtle;
    private Label tabTitle;

    public SlogoTab(int id, double width, double height, TurtleView t){
        myID = id;
        myWidth = width;
        myHeight = height;
        myTurtle = t;
        tabTitle = new Label(TAB_STRING + id);
        initPanes();
        setContent(myPane);
        setGraphic(tabTitle);
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
    }

    private void initCanvasPane(){
        myCanvasPane = new StackPane();
        myCanvasPane.setMaxSize(myHeight*CANVAS_RATIO,myHeight*CANVAS_RATIO);
        myPane.setCenter(myCanvasPane);
        initCanvas();
        initTurtleView();
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
        myLeftPane.getChildren().add(myVarPane);
        myPane.setLeft(myLeftPane);
    }

    private void initCommandPane(){
        myCommandPane = new CommandHistoryPane(myWidth/2-myCanvas.getWidth()/2,myHeight);
        myRightPane.getChildren().add(myCommandPane);
        myPane.setRight(myRightPane);
    }

    private void initTurtleView(){
        myTurtle.setCanvas(myCanvas);
        myCanvasPane.getChildren().add(myTurtle.getImgView());
    }

    private void initCanvas() {
        myCanvas = new SlogoCanvas(myHeight*CANVAS_RATIO,myHeight*CANVAS_RATIO);
        StackPane.setAlignment(myCanvas,Pos.CENTER);
        myCanvasPane.getChildren().add(myCanvas);
    }

    private void initCanvasColorChooser() {
        myCanvasColorChooser = new CanvasColorChooser();
        myCanvasColorChooser.setOnAction(e -> setCanvasBackground());
        StackPane.setAlignment(myCanvasColorChooser,Pos.CENTER_LEFT);
        myTopPane.getChildren().add(myCanvasColorChooser);
    }

    private void initLanguageChooser() {
        myLanguageChooser = new LanguageChooser();
        myLanguageChooser.setOnAction(e -> setLanguage());
        StackPane.setAlignment(myLanguageChooser,Pos.CENTER_RIGHT);
        myTopPane.getChildren().add(myLanguageChooser);
    }

    private void setCanvasBackground(){
        Color color;
        try {
            Field field = Class.forName("javafx.scene.paint.Color").getField(myCanvasColorChooser.getValue().toString().replaceAll("\\s+", ""));
            color = (Color)field.get(null);
        } catch (Exception e){
            color = null;
        }
        myCanvas.setBackgroundColor(color);
    }

    private void setLanguage(){

    }

    private void transferCommands(){

    }

}
