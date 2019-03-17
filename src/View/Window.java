package View;

import Controller.Controller;
import Errors.AlertFactory;
import Errors.SlogoAlert;
import Errors.SlogoException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 * @author Hsingchih Tang
 * Highest-level View component (front-end) class that manages multiple tabs (each controlling own Turtle and commands)
 * and coordinates with main Controller for transferring commands.
 * Main class of the whole program; implements JavaFX TabPane to realize multiple Turtle feature,
 * so that there is only one Window for the whole program that could be in charge of many tabs.
 * All types of Exceptions generated at any point of the whole program will eventually be thrown to Window,
 * where the AlertFactory will be triggered to handle the Exception by displaying alert dialogues to user.
 */
public class Window extends Application {

    public static final String PROJECT_NAME = "SLogo IDE";
    public static final double DEFAULT_HEIGHT = 800;
    public static final double DEFAULT_WIDTH = 1200;

    private Stage myStage;
    private TabPane windowRoot;
    private SlogoTabFactory myViewFactory;
    private AlertFactory myAlertFactory;
    private Controller myController;
    private int tabCount;

    /**
     * Instantiates a new Window for the program
     * Creates the main Controller and Factories
     */
   public Window(){
        super();
        myViewFactory = new SlogoTabFactory();
        myAlertFactory = new AlertFactory();
        myController = new Controller(this);
        tabCount = 0;
    }

    /**
     * Entry point of the JavaFX application
     * @param myStage stage where front-end scene is displayed
     */
    public void start(Stage myStage) {
        this.myStage = myStage;
        myStage.setTitle(PROJECT_NAME);
        displayStartScreen();
    }

    /**
     * Set the stage's scene to the program's opening screen
     */
    public void displayStartScreen(){
        Pane splashRoot = new Pane();
        SplashScreen startScreen = new SplashScreen(splashRoot, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        startScreen.getStartButton().setOnAction(e -> {
            try {
                handleTransition();
            } catch (Exception exp) {
                SlogoAlert alert = myAlertFactory.getAlert(exp);
                alert.showAlert();
                return;
            }
        });
        myStage.setScene(startScreen);
        myStage.show();
    }

    /**
     * Invokes Controller to create models on the back end, and invokes SlogoTabFactory to create a new SlogoTab
     */
    public void addSlogoTab(){
        myController.initNewTab();
        SlogoTab addTab = null;
        try{
            addTab = myViewFactory.getSlogoTab(tabCount,DEFAULT_WIDTH,DEFAULT_HEIGHT,myController, myStage,this);
        }catch (Exception e){
            SlogoAlert alert = myAlertFactory.getAlert(e);
            alert.showAlert();
            myController.removeLastTab();
            return;
        }
        windowRoot.getTabs().add(addTab);
        tabCount++;
    }

    /**
     * Invokes a SlogoAlert by triggering AlertFactory by a specific SlogoException
     * @param e the SlogoException caught by Window
     */
    public void invokeAlert(SlogoException e){
        SlogoAlert alert = myAlertFactory.getAlert(e);
        alert.showAlert();
        return;
    }

    private void handleTransition() throws SlogoException{
        windowRoot = new TabPane();
        Scene mainWindow = new Scene(windowRoot, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        myStage.setScene(mainWindow);
        addSlogoTab();
    }

    /**
     * Main function for launching the program
     */
    public static void main(String[] args){
        launch(args);
    }
}
