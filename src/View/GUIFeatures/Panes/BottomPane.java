package View.GUIFeatures.Panes;
import Controller.ControllerInterface;
import View.GUIFeatures.Buttons.*;
import View.SlogoTab;
import View.Turtles.TurtleView;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BottomPane extends GridPane {

    static final Double GRIDPANE_PADDING_Y = 5.0;
    static final Double GRIDPANE_PADDING_X = 17.0;
    static final Double CONSOLE_RATIO = (3.0/5.0);


    private double myHeight;
    private Button turnRightButton;
    private Button moveForwardButton;
    private Button turnLeftButton;
    private Button moveBackwardsButton;
    private Button penDown;
    private Button penUp;
    private ThicknessSlider penSlider;
    private Console myConsole;
    private Button myExecuteButton;
    private Button myClearButton;
    private Button myHelpButton;
    private TurtleView myTurtle;
    private ControllerInterface myController;
    private int myID;

    public BottomPane(double height, CanvasPane canvas, BorderPane myPane, ControllerInterface myController, int myID, TurtleView myTurtle){
        super();
        this.myHeight = height;
        this.myController = myController;
        this.myID = myID;
        this.myTurtle = myTurtle;
        setMaxHeight(height-canvas.getPrefHeight()/2);
        myPane.setBottom(this);
        initBottomPaneElements();
        setVgap(GRIDPANE_PADDING_Y);
        setHgap(GRIDPANE_PADDING_X);
        add(turnRightButton, SlogoTab.COL_3, SlogoTab.ROW_1);
        add(moveForwardButton, SlogoTab.COL_2, SlogoTab.ROW_0);
        add(turnLeftButton, SlogoTab.COL_1, SlogoTab.ROW_1);
        add(moveBackwardsButton, SlogoTab.COL_2, SlogoTab.ROW_1);
        add(penDown, SlogoTab.COL_0, SlogoTab.ROW_0);
        add(penUp, SlogoTab.COL_0, SlogoTab.ROW_1);
        add(penSlider, SlogoTab.COL_0, SlogoTab.ROW_2);
        add(penSlider.getSliderText(), SlogoTab.COL_0, SlogoTab.ROW_3);
        add(myConsole, SlogoTab.COL_4, SlogoTab.ROW_0, 1, 3);
        add(myExecuteButton, SlogoTab.COL_5, SlogoTab.ROW_0);
        add(myClearButton, SlogoTab.COL_5, SlogoTab.ROW_1);
        add(myHelpButton, SlogoTab.COL_5, SlogoTab.ROW_2);
        setMargin(myConsole,new Insets(10));
        setMargin(myExecuteButton,new Insets(5));
        setMargin(myClearButton,new Insets(5));
        setMargin(myHelpButton,new Insets(5));

    }

    private void initBottomPaneElements() {
        initConsole();
        initExecuteButton();
        initClearButton();
        initHelpButton();
        initActionButtons();
    }

    private void initConsole() {
        myConsole = new Console(myHeight* CONSOLE_RATIO, this.getMaxHeight());
        StackPane.setAlignment(myConsole, Pos.CENTER);
    }

    private void initExecuteButton() {
        myExecuteButton = new ExecuteButton();
        myExecuteButton.setOnAction(e -> transferCommands());
    }

    private void initClearButton() {
        myClearButton = new ClearButton();
        myClearButton.setOnAction(e -> this.myConsole.clearText());
    }

    private void initHelpButton() {
        myHelpButton = new HelpButton();
        myHelpButton.setOnAction(e -> this.openHelp());
    }

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
    }

    private void transferCommands() {
        String commands = myConsole.getText();
        this.myController.receiveCommand(commands, myID);
        //addToHistory(commands);
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

    private void buttonTransferCommands(Button b) {
        String command = b.getId();
        this.myController.receiveCommand(command, myID);
        //addToHistory(command);
    }


}
