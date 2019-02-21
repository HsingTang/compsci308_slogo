package Scenes;

import GUIFeatures.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.lang.reflect.Field;

public class Window extends Scene {

    public static final String STYLE_SHEET = "stylesheets/StyleWindow.css";
    public static final double CONSOLE_WIDTH = 700;
    public static final double CONSOLE_HEIGHT = 150;
    public static final double CONSOLE_X_POS = 325;
    public static final double CONSOLE_Y_POS = 600;
    public static final double EXECUTE_X_POS = 757;
    public static final double EXECUTE_Y_POS = 755;
    public static final double CLEAR_X_POS = 660;
    public static final double CLEAR_Y_POS = 755;
    public static final double CHOOSER_X_POS = 1035;
    public static final double CHOOSER_Y_POS = 10;
    public static final double CANVAS_WIDTH = 537;
    public static final double CANVAS_HEIGHT = 545;
    public static final double CANVAS_X_POS = 325;
    public static final double CANVAS_Y_POS = 50;
    public static final double CANVAS_CHOOSER_X_POS = CANVAS_X_POS;

    private double width;
    private double height;
    private Pane root;
    private Console myConsole;
    private Button myExecuteButton;
    private Button myClearButton;
    private LanguageChooser myLanguageChooser;
    private Canvas myCanvas;
    private CanvasColorChooser myCanvasColorChooser;

    public Window(Pane root, double width, double height) {
        super(root, width, height);
        this.root = root;
        this.width = width;
        this.height = height;
        this.getStylesheets().add(STYLE_SHEET);
        displayNodes();
        initializeNodes();
    }

    private void displayNodes() {
        displayConsole();
        displayExecuteButton();
        displayClearButton();
        displayChooser();
        displayCanvas();
        displayCanvasColorChooser();
    }

    private void initializeNodes() {
        initializeButton(myExecuteButton);
        initializeButton(myClearButton);
        initializeChooser(myCanvasColorChooser);
    }

    private void displayConsole() {
        myConsole = new Console(CONSOLE_WIDTH, CONSOLE_HEIGHT, CONSOLE_X_POS, CONSOLE_Y_POS);
        root.getChildren().add(myConsole.getMyTextArea());
    }

    private void displayExecuteButton() {
        myExecuteButton = new ExecuteButton(EXECUTE_X_POS, EXECUTE_Y_POS);
        root.getChildren().add(myExecuteButton);
    }

    private void displayClearButton() {
        myClearButton = new ClearButton(CLEAR_X_POS, CLEAR_Y_POS);
        root.getChildren().add(myClearButton);
    }

    private void displayChooser() {
        myLanguageChooser = new LanguageChooser(CHOOSER_X_POS, CHOOSER_Y_POS);
        root.getChildren().add(myLanguageChooser);
    }

    private void displayCanvas() {
        myCanvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT, CANVAS_X_POS, CANVAS_Y_POS);
        root.getChildren().add(myCanvas);
    }

    private void displayCanvasColorChooser() {
        myCanvasColorChooser = new CanvasColorChooser(CANVAS_CHOOSER_X_POS, CHOOSER_Y_POS);
        root.getChildren().add(myCanvasColorChooser);
    }

    private void initializeButton(Button button) {
        button.setOnAction(e -> handlePress(button));
    }

    private void initializeChooser(ComboBox chooser) {
        chooser.setOnAction(e -> handleSelection(chooser));
    }

    private void handlePress(Button button) {
        if (button instanceof ClearButton) {
            myConsole.clearText();
        }
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

}
