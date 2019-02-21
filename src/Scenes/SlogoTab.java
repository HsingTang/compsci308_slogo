package Scenes;


import GUIFeatures.*;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.lang.reflect.Field;

public class SlogoTab extends Tab {
    public static final String STYLE_SHEET = "stylesheets/StyleWindow.css";
    private final Double myConsoleRatio = (4.0/5.0);
    private BorderPane myPane;
    private StackPane myBottomPane;
    private StackPane myTopPane;
    private StackPane myCenterPane;
    private Double myWidth;
    private Double myHeight;
    private Console myConsole;
    private Button myExecuteButton;
    private Button myClearButton;
    private LanguageChooser myLanguageChooser;
    private SlogoCanvas myCanvas;
    private CanvasColorChooser myCanvasColorChooser;

    public SlogoTab(Double width, Double height){
        this.myWidth = width;
        this.myHeight = height;
        this.myPane = new BorderPane();
        this.myBottomPane = new StackPane();
        this.myTopPane = new StackPane();
        this.myCenterPane = new StackPane();
        this.myPane.setBottom(myBottomPane);
        this.myPane.setTop(myTopPane);
        initNodes();
        this.setContent(myPane);
    }


    private void initNodes() {
        initConsole();
        initExecuteButton();
        initClearButton();
        initLanguageChooser();
        initCanvas();
        initCanvasColorChooser();
    }


    private void setupChooser(ComboBox chooser) {
        chooser.setOnAction(e -> handleSelection(chooser));
    }


    private void handleSelection(ComboBox chooser) {
        if (chooser instanceof CanvasColorChooser) {
            Color color;
            try {
                Field field = Class.forName("javafx.scene.paint.Color").getField(myCanvasColorChooser.getValue().toString().replaceAll("\\s+", ""));
                color = (Color)field.get(null);
            } catch (Exception e){
                color = null;
            }
            myCanvas.setFill(color);
        }
    }

    private void initConsole() {
        myConsole = new Console(this.myWidth*myConsoleRatio,this.myBottomPane.getPrefHeight());
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

    private void initLanguageChooser() {
        myLanguageChooser = new LanguageChooser();
        myLanguageChooser.setOnAction(e -> handleSelection(myLanguageChooser));
        StackPane.setAlignment(myLanguageChooser,Pos.CENTER_RIGHT);
        this.myTopPane.getChildren().add(myLanguageChooser);
    }

    private void initCanvasColorChooser() {
        myCanvasColorChooser = new CanvasColorChooser();
        StackPane.setAlignment(myCanvasColorChooser,Pos.CENTER_LEFT);
        this.myTopPane.getChildren().add(myCanvasColorChooser);
    }

    private void initCanvas() {
        myCanvas = new SlogoCanvas();
        StackPane.setAlignment(myCanvas,Pos.CENTER);
        this.myCenterPane.getChildren().add(myCanvas);
    }

    private void transferCommands(){

    }

}
