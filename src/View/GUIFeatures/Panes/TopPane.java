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


/**
 * @author Hsingchih Tang
 * @author Eric Lin
 * Top section of the GUI, where TurtleView's image file chooser, pen/canvas color chooser, language chooser
 * and the StatePane for displaying TurtleView and pen's current states reside
 * There should be one TopPane per tab
 */
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
    private TurtleText turtleTextState;

    /**
     * instantiates instance of the top pane
     *
     * @param height        height of the top pane
     * @param myCanvasPane  CanvasPane in the same tab
     * @param myController  main Controller
     * @param myWindow      main Window that holds the tab
     * @param myTurtle      TurtleView of the tab
     * @param myStage       stage of the program
     * @throws SlogoException   exception on failure to initialize top tab
     */
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
        try{
            initTopPaneElements();
        }catch (SlogoException e){
            throw e;
        }
        setHgap(GRIDPANE_PADDING_X);
        setVgap(GRIDPANE_PADDING_Y);
    }

    /**
     * Updates the language in which commands are parsed. Invoked by LanguageChooser on user action.
     */
    public void setLanguage(){
        this.myController.setLanguage(myLanguageChooser.getValue().toString());
    }

    /**
     * Updates background color of the canvas. Invoked by CanvasColorChooser on user action.
     */
    public void setCanvasBackground(){
        Color color = myCanvasColorChooser.getValue();
        myCanvasPane.setCanvasColor(color);
    }

    /**
     * Updates the pen color. Invoked by PenColorChooser on user action.
     */
    public void setPenColor() {
        Color color = myPenColorChooser.getValue();
        myTurtle.getPen().setColor(color);
        myTurtle.getTurtleTextState().setPenColor(color);
    }

    private void initTopPaneElements() throws SlogoException {
        try{
            initLanguageChooser();
            initAddTabButton();
            initCanvasColorChooser();
            initPenColorChooser();
            initTurtleChooser();
            initTurtleTextState();
        }catch (SlogoException e){
            throw e;
        }
    }

    private void initLanguageChooser() throws SlogoException {
        try{
            myLanguageChooser =(LanguageChooser)myElementFactory.makeElement("LanguageChooser");
            myLayoutManager.setLayout(myLanguageChooser);
        }catch (SlogoException e){
            throw e;
        }

    }

    private void initAddTabButton() throws SlogoException{
        Button myAddTabButton = new AddTabButton();
        myLayoutManager.setLayout(myAddTabButton);
        myAddTabButton.setOnAction(e-> {
            try {
                this.myWindow.addSlogoTab();
            } catch (Exception exp) {
                throw new SlogoTabSetupElementException(exp);
            }
        });
    }

    private void initCanvasColorChooser() throws SlogoException {
        try{
            myCanvasColorChooser =(CanvasColorChooser)myElementFactory.makeElement("CanvasColorChooser");
            myLayoutManager.setLayout(myCanvasColorChooser);
            myLayoutManager.setLayout(new Text(CANVAS_TEXT));
        }catch (SlogoException e){
            throw e;
        }
    }

    private void initPenColorChooser() throws SlogoException {
        try{
            myPenColorChooser =(PenColorChooser)myElementFactory.makeElement("PenColorChooser");
            myLayoutManager.setLayout(myPenColorChooser);
            myLayoutManager.setLayout(new Text(PEN_TEXT));
        }catch(SlogoException e){
            throw e;
        }
    }

    private void initTurtleChooser() {
        myTurtleChooser = new TurtleChooser();
        myTurtleChooser.getButton().setOnAction(e -> changeTurtleImage());
        StackPane.setAlignment(myTurtleChooser.getButton(), Pos.CENTER);
        myLayoutManager.setLayout(myTurtleChooser.getButton());
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

    private void initTurtleTextState() {
        turtleTextState = myTurtle.getTurtleTextState();
        Text[] turtleLabels = turtleTextState.getTurtleLabels();
        Text[] turtleStates = turtleTextState.getTurtleStates();
        Text[] penLabels = turtleTextState.getPenLabels();
        Text[] penStates = turtleTextState.getPenStates();
        StatePane stateGrid = new StatePane();
        stateGrid.addTurtleLabel(turtleLabels);
        stateGrid.addTurtleState(turtleStates);
        stateGrid.addPenLabel(penLabels);
        stateGrid.addPenState(penStates);
        myLayoutManager.setLayout(stateGrid);
    }
}
