package View;

import Models.TurtleModel;
import View.Turtles.TurtleFactory;
import View.Turtles.TurtleView;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;

/**
 * @author Hsingchih Tang, Eric Lin
 * Major front end class
 * Might be able to upport multiple tabs where Turtle, commands and variables are managed separately
 */
public class Window extends Scene {

    public static final String STYLE_SHEET = "stylesheets/StyleWindow.css";
    /*
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
    */

    private double windowWidth;
    private double windowHeight;
    TurtleFactory myTurtleFactory;
    private TabPane root;
    private int turtleId = 0;
    private int tabCount = 1;


    public Window(TabPane root, double width, double height) {
        super(root, width, height);
        this.root = root;
        this.windowWidth = width;
        this.windowHeight = height;
        this.getStylesheets().add(STYLE_SHEET);
        myTurtleFactory = new TurtleFactory();
        initializeTab();
    }

    private void initializeTab(){
        TurtleModel newTurtleModel = new TurtleModel();
        TurtleView newTurtle = this.myTurtleFactory.makeTurtle(turtleId,newTurtleModel);
        newTurtleModel.registerTurtleObserver(newTurtle);
        this.root.getTabs().add(new SlogoTab(tabCount,windowWidth,windowHeight,newTurtle));
    }




}
