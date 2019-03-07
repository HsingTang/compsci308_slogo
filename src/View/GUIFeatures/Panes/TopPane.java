package View.GUIFeatures.Panes;

import Controller.ControllerInterface;
import View.GUIFeatures.Buttons.AddTabButton;
import View.GUIFeatures.Choosers.CanvasColorChooser;
import View.GUIFeatures.Choosers.LanguageChooser;
import View.GUIFeatures.Choosers.PenColorChooser;
import View.GUIFeatures.Choosers.TurtleChooser;
import View.SlogoTab;
import View.Turtles.TurtleView;
import View.Window;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;

public class TopPane extends GridPane {

    static final String CANVAS_TEXT = "Choose Canvas Color";
    static final String PEN_TEXT = "Choose Pen Color";
    static final Double GRIDPANE_PADDING_Y = 5.0;
    static final Double GRIDPANE_PADDING_X = 17.0;


    private double myHeight;
    private CanvasPane myCanvasPane;
    private Button myAddTabButton;
    private LanguageChooser myLanguageChooser;
    private TurtleChooser myTurtleChooser;
    private CanvasColorChooser myCanvasColorChooser;
    private PenColorChooser myPenColorChooser;
    private ControllerInterface myController;
    private Window myWindow;
    private TurtleView myTurtle;
    private Stage myStage;

    public TopPane(double height, CanvasPane myCanvasPane, BorderPane myPane, ControllerInterface myController, Window myWindow, TurtleView myTurtle, Stage myStage){
        super();
        this.myHeight = height;
        this.myController = myController;
        this.myCanvasPane = myCanvasPane;
        this.myWindow = myWindow;
        this.myTurtle = myTurtle;
        this.myStage = myStage;
        myPane.setTop(this);
        setMinHeight(myHeight/10);
        initTopPaneElements();
        add(myCanvasColorChooser, SlogoTab.COL_0, SlogoTab.ROW_0);
        add(myPenColorChooser, SlogoTab.COL_1, SlogoTab.ROW_0);
        add(new Text(CANVAS_TEXT), SlogoTab.COL_0, SlogoTab.ROW_1);
        add(new Text(PEN_TEXT), SlogoTab.COL_1, SlogoTab.ROW_1);
        add(myAddTabButton, SlogoTab.COL_2, SlogoTab.ROW_0);
        add(myLanguageChooser, SlogoTab.COL_3, SlogoTab.ROW_0);
        setHgap(GRIDPANE_PADDING_X);
        setVgap(GRIDPANE_PADDING_Y);
    }

    private void initTopPaneElements(){
        initLanguageChooser();
        initAddTabButton();
        initCanvasColorChooser();
        initPenColorChooser();
        initTurtleChooser();
    }

    private void initLanguageChooser() {
        myLanguageChooser = new LanguageChooser();
        myLanguageChooser.setOnAction(e -> setLanguage());
    }

    private void initAddTabButton(){
        myAddTabButton = new AddTabButton();
        myAddTabButton.setOnAction(e->this.myWindow.addSlogoTab());
        StackPane.setAlignment(myAddTabButton, Pos.TOP_RIGHT);
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
    }

    private void setLanguage(){
        this.myController.setLanguage(myLanguageChooser.getValue().toString());
    }

    private void setCanvasBackground(){
        Color color = myCanvasColorChooser.getValue();
        myCanvasPane.setCanvasColor(color);
    }

    private void setPenColor() {
        Color color = myPenColorChooser.getValue();
        myTurtle.getPen().setColor(color);
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
}
