package View.GUIFeatures.Panes;

import Controller.ControllerInterface;
import View.GUIFeatures.Buttons.AddTabButton;
import View.GUIFeatures.Choosers.CanvasColorChooser;
import View.GUIFeatures.Choosers.LanguageChooser;
import View.GUIFeatures.Choosers.PenColorChooser;
import View.GUIFeatures.Choosers.TurtleChooser;
import View.GUIFeatures.ElementFactory;
import View.SlogoTab;
import View.Turtles.TurtleView;
import View.Window;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
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
    private PaneLayoutManager myLayoutManager;
    private ElementFactory myElementFactory;
    private Stage myStage;

    public TopPane(double height, CanvasPane myCanvasPane, BorderPane myPane, ControllerInterface myController, Window myWindow, TurtleView myTurtle, Stage myStage) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        super();
        this.myHeight = height;
        this.myController = myController;
        this.myCanvasPane = myCanvasPane;
        this.myWindow = myWindow;
        this.myTurtle = myTurtle;
        this.myStage = myStage;
        this.myLayoutManager = new PaneLayoutManager(this);
        this.myElementFactory = new ElementFactory(this);
        myPane.setTop(this);
        setMinHeight(myHeight/10);
        initTopPaneElements();
        setHgap(GRIDPANE_PADDING_X);
        setVgap(GRIDPANE_PADDING_Y);
    }

    private void initTopPaneElements() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        initLanguageChooser();
        initAddTabButton();
        initCanvasColorChooser();
        initPenColorChooser();
        initTurtleChooser();
    }

    private void initLanguageChooser() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        myLanguageChooser =(LanguageChooser)myElementFactory.makeElement("LanguageChooser");
        myLayoutManager.setLayout(myLanguageChooser);
    }

    private void initAddTabButton(){
        myAddTabButton = new AddTabButton();
        myAddTabButton.setOnAction(e-> {
            try {
                this.myWindow.addSlogoTab();
            } catch (Exception exp) {
                exp.printStackTrace();
            }
        });
        StackPane.setAlignment(myAddTabButton, Pos.TOP_RIGHT);
        myLayoutManager.setLayout(myAddTabButton);
    }

    private void initCanvasColorChooser() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        myCanvasColorChooser =(CanvasColorChooser)myElementFactory.makeElement("CanvasColorChooser");
        myLayoutManager.setLayout(myCanvasColorChooser);
        myLayoutManager.setLayout(new Text(CANVAS_TEXT));
    }

    private void initPenColorChooser() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        myPenColorChooser =(PenColorChooser)myElementFactory.makeElement("PenColorChooser");
        myLayoutManager.setLayout(myPenColorChooser);
        myLayoutManager.setLayout(new Text(PEN_TEXT));
    }

    private void initTurtleChooser() {
        myTurtleChooser = new TurtleChooser();
        myTurtleChooser.getButton().setOnAction(e -> changeTurtleImage());
        StackPane.setAlignment(myTurtleChooser.getButton(), Pos.CENTER);
    }

    public void setLanguage(){
        this.myController.setLanguage(myLanguageChooser.getValue().toString());
    }

    public void setCanvasBackground(){
        Color color = myCanvasColorChooser.getValue();
        myCanvasPane.setCanvasColor(color);
    }

    public void setPenColor() {
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
