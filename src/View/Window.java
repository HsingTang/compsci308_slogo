package View;

import Controller.Controller;
import Errors.AlertFactory;
import Errors.SlogoAlert;
import Errors.SlogoException;
import View.SlogoTab;
import View.SplashScreen;
import View.SlogoTabFactory;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.lang.reflect.InvocationTargetException;


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


   public Window(){
        super();
        myViewFactory = new SlogoTabFactory();
        myAlertFactory = new AlertFactory();
        myController = new Controller();
        tabCount = 0;
    }

    public void start(Stage myStage) {
        this.myStage = myStage;
        myStage.setTitle(PROJECT_NAME);
        displayStartScreen();
    }

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

    public void addSlogoTab(){
       // System.out.println("new tab init");
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

    private void handleTransition() throws SlogoException{
        windowRoot = new TabPane();
        Scene mainWindow = new Scene(windowRoot, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        myStage.setScene(mainWindow);
        addSlogoTab();
    }
    public static void main(String[] args){
        launch(args);
    }
}
