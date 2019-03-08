package View.GUIFeatures.Panes;

import Controller.ControllerInterface;
import Errors.MalformedTurtleImgException;
import Errors.SlogoException;
import Errors.SlogoTabSetupElementException;
import View.GUIFeatures.Buttons.AddTabButton;
import View.GUIFeatures.Choosers.CanvasColorChooser;
import View.GUIFeatures.Choosers.LanguageChooser;
import View.GUIFeatures.Choosers.PenColorChooser;
import View.GUIFeatures.Choosers.TurtleChooser;
import View.GUIFeatures.ElementFactory;
import View.Turtles.TurtleView;
import View.Window;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
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
    static final Double MIN_HEIGHT_RATIO = (1/10.0);


    private double myHeight;
    private CanvasPane myCanvasPane;
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

    public TopPane(double height, CanvasPane myCanvasPane, ControllerInterface myController, Window myWindow, TurtleView myTurtle, Stage myStage) throws SlogoException {
        super();
        this.myHeight = height;
        this.myController = myController;
        this.myCanvasPane = myCanvasPane;
        this.myWindow = myWindow;
        this.myTurtle = myTurtle;
        this.myStage = myStage;
        this.myLayoutManager = new PaneLayoutManager(this);
        this.myElementFactory = new ElementFactory(this);
        setMinHeight(myHeight*MIN_HEIGHT_RATIO);
        initTopPaneElements();
        setHgap(GRIDPANE_PADDING_X);
        setVgap(GRIDPANE_PADDING_Y);
    }

    private void initTopPaneElements() throws SlogoException {
        initLanguageChooser();
        initAddTabButton();
        initCanvasColorChooser();
        initPenColorChooser();
        initTurtleChooser();
    }

    private void initLanguageChooser() throws SlogoException {
        myLanguageChooser =(LanguageChooser)myElementFactory.makeElement("LanguageChooser");
        myLayoutManager.setLayout(myLanguageChooser);
    }

    private void initAddTabButton() throws SlogoException{
        Button myAddTabButton = new AddTabButton();
        myAddTabButton.setOnAction(e-> {
            try {
                this.myWindow.addSlogoTab();
            } catch (Exception exp) {
                System.out.println("exception in AddTabButton");
                throw new SlogoTabSetupElementException(exp);
            }
        });
        myLayoutManager.setLayout(myAddTabButton);
    }

    private void initCanvasColorChooser() throws SlogoException {
        myCanvasColorChooser =(CanvasColorChooser)myElementFactory.makeElement("CanvasColorChooser");
        myLayoutManager.setLayout(myCanvasColorChooser);
        myLayoutManager.setLayout(new Text(CANVAS_TEXT));
    }

    private void initPenColorChooser() throws SlogoException {
        myPenColorChooser =(PenColorChooser)myElementFactory.makeElement("PenColorChooser");
        myLayoutManager.setLayout(myPenColorChooser);
        myLayoutManager.setLayout(new Text(PEN_TEXT));
    }

    private void initTurtleChooser() {
        myTurtleChooser = new TurtleChooser();
        myTurtleChooser.getButton().setOnAction(e -> changeTurtleImage());
        StackPane.setAlignment(myTurtleChooser.getButton(), Pos.CENTER);
        myLayoutManager.setLayout(myTurtleChooser.getButton());
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

    private void changeTurtleImage() throws MalformedTurtleImgException{
        File dataFile = myTurtleChooser.getTurtleChooser().showOpenDialog(myStage);
        try {
            Image newImage = new Image(dataFile.toURI().toURL().toExternalForm());
            myTurtle.setImgView(newImage);
        } catch (MalformedURLException e) {
            throw new MalformedTurtleImgException(e);
        }
    }
}
