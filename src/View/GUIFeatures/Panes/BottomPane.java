package View.GUIFeatures.Panes;
import Controller.ControllerInterface;
import Errors.InvokeHelpPageException;
import Errors.SlogoException;
import View.GUIFeatures.Buttons.ExecuteButton;
import View.GUIFeatures.Buttons.ClearButton;
import View.GUIFeatures.Buttons.HelpButton;
import View.GUIFeatures.Buttons.ForwardButton;
import View.GUIFeatures.Buttons.BackwardsButton;
import View.GUIFeatures.Buttons.LeftRotateButton;
import View.GUIFeatures.Buttons.RightRotateButton;
import View.GUIFeatures.Buttons.PenUpButton;
import View.GUIFeatures.Buttons.PenDownButton;
import View.GUIFeatures.Buttons.ThicknessSlider;
import View.GUIFeatures.ElementFactory;
import View.Turtles.TurtleView;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;


public class BottomPane extends GridPane {

    static final Double GRIDPANE_PADDING_Y = 10.0;
    static final Double GRIDPANE_PADDING_X = 20.0;
    static final Double CONSOLE_RATIO = (3.0/5.0);


    private double myHeight;
    private Console myConsole;
    private TurtleView myTurtle;
    private ControllerInterface myController;
    private int myID;
    private PaneLayoutManager myLayoutManager;
    private ElementFactory myElementFactory;

    public BottomPane(double height, CanvasPane canvas, ControllerInterface myController, int myID, TurtleView myTurtle) throws SlogoException {
        super();
        this.myElementFactory = new ElementFactory(this);
        this.myLayoutManager = new PaneLayoutManager(this);
        this.myHeight = height;
        this.myController = myController;
        this.myID = myID;
        this.myTurtle = myTurtle;
        setMaxHeight(height-canvas.getPrefHeight()/2);
        initBottomPaneElements();
        setVgap(GRIDPANE_PADDING_Y);
        setHgap(GRIDPANE_PADDING_X);

    }

    private void initBottomPaneElements() throws SlogoException{
        initConsole();
        initExecuteButton();
        initClearButton();
        initHelpButton();
        initActionButtons();
        initSpring();
    }

    private void initSpring() throws SlogoException{
        Pane mySpring = (Pane) myElementFactory.makeElement("Spring");
        mySpring.setMinHeight(GRIDPANE_PADDING_Y);
        myLayoutManager.setLayout(mySpring);
    }

    private void initConsole() {
        myConsole = new Console(myHeight* CONSOLE_RATIO, this.getMaxHeight());
        myConsole.setupModel(myController.getReturnValModel(myID));
        StackPane.setAlignment(myConsole, Pos.CENTER);
        myLayoutManager.setLayout(myConsole);
    }

    private void initExecuteButton() throws SlogoException{
        Button myExecuteButton = (ExecuteButton)myElementFactory.makeElement("ExecuteButton");
        myLayoutManager.setLayout(myExecuteButton);
    }

    private void initClearButton() throws SlogoException{
        Button myClearButton = (ClearButton)myElementFactory.makeElement("ClearButton");
        myLayoutManager.setLayout(myClearButton);
    }

    public void clearConsole(){
        myConsole.clearText();
    }

    private void initHelpButton() throws SlogoException {
        Button myHelpButton = (HelpButton)myElementFactory.makeElement("HelpButton");
        myLayoutManager.setLayout(myHelpButton);
    }

    private void initActionButtons() throws SlogoException{
        Button moveForwardButton = (ForwardButton)myElementFactory.makeElement("ForwardButton");
        Button moveBackwardsButton = (BackwardsButton)myElementFactory.makeElement("BackwardsButton");
        Button turnLeftButton = (LeftRotateButton)myElementFactory.makeElement("LeftRotateButton");
        Button turnRightButton = (RightRotateButton)myElementFactory.makeElement("RightRotateButton");
        Button penDown = (PenDownButton)myElementFactory.makeElement("PenDownButton");
        Button penUp = (PenUpButton)myElementFactory.makeElement("PenUpButton");
        ThicknessSlider penSlider = (ThicknessSlider)myElementFactory.makeElement("ThicknessSlider");
        penSlider.setOnMousePressed(e -> penSlider.changeThickness(myTurtle.getPen()));
        penSlider.valueChangingProperty().addListener((ObservableValue<? extends Boolean> obs, Boolean wasChanging, Boolean isNowChanging) -> {
            if (!isNowChanging) {
                penSlider.changeThickness(myTurtle.getPen());
            }
        });
        myLayoutManager.setLayout(moveForwardButton);
        myLayoutManager.setLayout(moveBackwardsButton);
        myLayoutManager.setLayout(turnLeftButton);
        myLayoutManager.setLayout(turnRightButton);
        myLayoutManager.setLayout(penDown);
        myLayoutManager.setLayout(penUp);
        myLayoutManager.setLayout(penSlider);
    }

    public void transferCommands() {
        String commands = myConsole.getText();
        this.myController.receiveCommand(commands, myID);
        //addToHistory(commands);
        this.myConsole.clearText();
    }

    public void openHelp() throws InvokeHelpPageException{
        File file = new File("resources/Help_Page.html");
        try {
            Desktop.getDesktop().open(file);
        } catch (IOException e1) {
            throw new InvokeHelpPageException(e1);
        }
    }

    public void buttonTransferCommands(String s) {
        this.myController.receiveCommand(s, myID);
        //addToHistory(command);
    }


}
