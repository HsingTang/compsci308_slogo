package Scenes;


import GUIFeatures.*;
import Turtles.TurtleView;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.lang.reflect.Field;


/**
 * @author Hsingchih Tang
 * An independent tab managing its own Turtle, commands and variables
 */
public class SlogoTab extends Tab {
    static final Double CONSOLE_RATIO = (4.0/5.0);
    static final Double CANVAS_RATIO = (3.0/5.0);

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
    private SlogoCanvas myCanvas;
    private CanvasColorChooser myCanvasColorChooser;
    private TurtleView myTurtle;
    private TableView myVarPane;

    public SlogoTab(int id, double width, double height, TurtleView t){
        this.myID = id;
        this.myWidth = width;
        this.myHeight = height;
        this.myPane = new BorderPane();
        this.myBottomPane = new StackPane();
        this.myTopPane = new StackPane();
        this.myCanvasPane = new StackPane();
        this.myPane.setBottom(myBottomPane);
        this.myPane.setTop(myTopPane);
        this.myPane.setCenter(myCanvasPane);
        this.myTurtle = t;
        initNodes();
        this.setContent(myPane);
    }


    private void initNodes() {
        initConsole();
        initExecuteButton();
        initClearButton();
        initLanguageChooser();
        initCanvasColorChooser();
        initCanvas();
        initTurtleView();
        // initVarPane();
    }


    private void initConsole() {
        myConsole = new Console(this.myWidth* CONSOLE_RATIO,this.myBottomPane.getPrefHeight());
        StackPane.setAlignment(myConsole.getMyTextArea(), Pos.CENTER);
        this.myBottomPane.getChildren().add(myConsole.getMyTextArea());
    }

    private void initExecuteButton() {
        myExecuteButton = new ExecuteButton();
        myExecuteButton.setOnAction(e -> this.transferCommands());
        StackPane.setAlignment(myExecuteButton,Pos.BOTTOM_RIGHT);
        this.myBottomPane.getChildren().add(myExecuteButton);
    }

    private void initClearButton() {
        myClearButton = new ClearButton();
        myClearButton.setOnAction(e -> this.myConsole.clearText());
        StackPane.setAlignment(myClearButton,Pos.TOP_RIGHT);
        this.myBottomPane.getChildren().add(myClearButton);
    }

    private void initVarPane(){
        myVarPane = new VariablePane();
        myLeftPane.getChildren().add(myVarPane);
        myPane.setLeft(myLeftPane);
    }

    private void initTurtleView(){
        myTurtle.setCanvas(myCanvas);
        myCanvasPane.getChildren().add(myTurtle.getImgView());
    }

    private void initCanvas() {
        myCanvas = new SlogoCanvas(myHeight*CANVAS_RATIO,myHeight*CANVAS_RATIO);
        StackPane.setAlignment(myCanvas,Pos.CENTER);
        this.myCanvasPane.getChildren().add(myCanvas);
    }

    private void initCanvasColorChooser() {
        myCanvasColorChooser = new CanvasColorChooser();
        myCanvasColorChooser.setOnAction(e -> setCanvasBackground());
        StackPane.setAlignment(myCanvasColorChooser,Pos.CENTER_LEFT);
        this.myTopPane.getChildren().add(myCanvasColorChooser);
    }

    private void initLanguageChooser() {
        myLanguageChooser = new LanguageChooser();
        myLanguageChooser.setOnAction(e -> setLanguage());
        StackPane.setAlignment(myLanguageChooser,Pos.CENTER_RIGHT);
        this.myTopPane.getChildren().add(myLanguageChooser);
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
