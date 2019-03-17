package View.GUIFeatures.Panes;

import Controller.ControllerInterface;
import Errors.InvokeHelpPageException;
import Errors.SlogoException;
import View.GUIFeatures.Buttons.*;
import View.GUIFeatures.ElementFactory;
import View.Turtles.TurtleView;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @author Hsingchih Tang
 * @author Eric Lin
 * Bottom section of the GUI, where console, pen buttons, and command execution/clearing buttons reside
 * There should be one BottomPane per tab
 */
public class BottomPane extends GridPane {

    static final Double GRIDPANE_PADDING_Y = 5.0;
    static final Double GRIDPANE_PADDING_X = 20.0;
    static final Double CONSOLE_RATIO = (3.0/5.0);


    private double myHeight;
    private Console myConsole;
    private TurtleView myTurtle;
    private ControllerInterface myController;
    private int myID;
    private PaneLayoutManager myLayoutManager;
    private ElementFactory myElementFactory;

    /**
     * Instantiates an instance of the bottom pane
     * @param height        height of bottom pane
     * @param canvas        canvas object in the same tab
     * @param myController  main Controller
     * @param myID          ID of the tab
     * @param myTurtle      TurtleView of the tab
     * @throws SlogoException error thrown on failure to instantiate bottom pane
     */
    public BottomPane(double height, CanvasPane canvas, ControllerInterface myController, int myID, TurtleView myTurtle) throws SlogoException {
        super();
        this.myElementFactory = new ElementFactory(this);
        this.myLayoutManager = new PaneLayoutManager(this);
        this.myHeight = height;
        this.myController = myController;
        this.myID = myID;
        this.myTurtle = myTurtle;
        setMaxHeight(height-canvas.getPrefHeight()/2);
        try {
            initBottomPaneElements();
        } catch (SlogoException e) {
            throw e;
        }
        setVgap(GRIDPANE_PADDING_Y);
        setHgap(GRIDPANE_PADDING_X);
    }

    /**
     * Transfers commands entered from Console to the Controller. Invoked by ExecuteButton on clicking action.
     */
    public void transferCommands() {
        String commands = myConsole.getText();
        this.myConsole.clearText();
        this.myController.receiveCommand(commands, myID);
        //addToHistory(commands);
    }

    /**
     * Opens the help screen. Invoked by HelpButton on clicking action.
     * @throws InvokeHelpPageException error thrown when unable to find the page
     */
    public void openHelp() throws InvokeHelpPageException{
        File file = new File("resources/Help_Page.html");
        try {
            Desktop.getDesktop().open(file);
        } catch (IOException e1) {
            throw new InvokeHelpPageException(e1);
        }
    }

    /**
     * Transfers pre-instantiated commands when TurtleView-motion-control/pen-control buttons are invoked.
     * @param s command to be transferred to Controller
     */
    public void buttonTransferCommands(String s) {
        this.myController.receiveCommand(s, myID);
        //addToHistory(command);
    }

    /**
     * Clears the text displayed in Console. Invoked by ClearButton on clicking action.
     */
    public void clearConsole(){
        myConsole.clearText();
    }


    private void initBottomPaneElements() throws SlogoException{
        try{
            initConsole();
            initExecuteButton();
            initClearButton();
            initHelpButton();
            initActionButtons();
            initSpring();
        }catch (SlogoException e){
            throw e;
        }

    }

    private void initSpring() throws SlogoException{
        try{
            Pane mySpring = (Pane) myElementFactory.makeElement("Spring");
            mySpring.setMinHeight(GRIDPANE_PADDING_Y);
            myLayoutManager.setLayout(mySpring);
        }catch (SlogoException e){
            throw e;
        }

    }

    private void initConsole() {
        myConsole = new Console(myHeight* CONSOLE_RATIO, this.getMaxHeight());
        myConsole.setupModel(myController.getReturnValModel(myID));
        StackPane.setAlignment(myConsole, Pos.CENTER);
        myLayoutManager.setLayout(myConsole);
    }

    private void initExecuteButton() throws SlogoException{
        try{
            Button myExecuteButton = (ExecuteButton)myElementFactory.makeElement("ExecuteButton");
            myLayoutManager.setLayout(myExecuteButton);
        }catch (SlogoException e){
            throw e;
        }
    }

    private void initClearButton() throws SlogoException{
        try{
            Button myClearButton = (ClearButton)myElementFactory.makeElement("ClearButton");
            myLayoutManager.setLayout(myClearButton);
        }catch (SlogoException e){
            throw e;
        }
    }

    private void initHelpButton() throws SlogoException {
        try{
            Button myHelpButton = (HelpButton)myElementFactory.makeElement("HelpButton");
            myLayoutManager.setLayout(myHelpButton);
        }catch (SlogoException e){
            throw e;
        }

    }

    private void initActionButtons() throws SlogoException{
        try{
            Button moveForwardButton = (ForwardButton)myElementFactory.makeElement("ForwardButton");
            Button moveBackwardsButton = (BackwardsButton)myElementFactory.makeElement("BackwardsButton");
            Button turnLeftButton = (LeftRotateButton)myElementFactory.makeElement("LeftRotateButton");
            Button turnRightButton = (RightRotateButton)myElementFactory.makeElement("RightRotateButton");
            Button penDown = (PenDownButton)myElementFactory.makeElement("PenDownButton");
            Button penUp = (PenUpButton)myElementFactory.makeElement("PenUpButton");
            ThicknessSlider penSlider = (ThicknessSlider)myElementFactory.makeElement("ThicknessSlider");
            penSlider.setOnMousePressed(e -> {
                penSlider.changeThickness(myTurtle.getPen());
                myTurtle.getTurtleTextState().setPenThickness(penSlider.getValue());
            });
            penSlider.valueChangingProperty().addListener((ObservableValue<? extends Boolean> obs, Boolean wasChanging, Boolean isNowChanging) -> {
                if (!isNowChanging) {
                    penSlider.changeThickness(myTurtle.getPen());
                    myTurtle.getTurtleTextState().setPenThickness(penSlider.getValue());
                }
            });
            myLayoutManager.setLayout(moveForwardButton);
            myLayoutManager.setLayout(moveBackwardsButton);
            myLayoutManager.setLayout(turnLeftButton);
            myLayoutManager.setLayout(turnRightButton);
            myLayoutManager.setLayout(penDown);
            myLayoutManager.setLayout(penUp);
            myLayoutManager.setLayout(penSlider);
        }catch (SlogoException e){
            throw e;
        }
    }
}
