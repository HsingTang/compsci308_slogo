import CommandTree.CommandRoot;
import Controller.Controller;
import Model.TurtleModel;
import View.SlogoTab;
import View.SplashScreen;
import View.Turtles.TurtleFactory;
import View.Turtles.TurtleView;
import View.ViewFactory;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Window extends Application {

    public static final String PROJECT_NAME = "SLogo IDE";
    public static final double DEFAULT_HEIGHT = 800;
    public static final double DEFAULT_WIDTH = 1200;

    private Stage myStage;
    private Pane splashRoot;
    private TabPane windowRoot;
    private ViewFactory myViewFactory;
    private Controller myController;
    private int tabCount;

    public Window(){
        super();
        myViewFactory = new ViewFactory();
        myController = new Controller();
        tabCount = 0;
    }

    public void start(Stage myStage) {
        this.myStage = myStage;
        myStage.setTitle(PROJECT_NAME);
        displayStartScreen();
    }

    public void displayStartScreen(){
        splashRoot = new Pane();
        SplashScreen startScreen = new SplashScreen(splashRoot, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        startScreen.getStartButton().setOnAction(e -> handleTransition());
        myStage.setScene(startScreen);
        myStage.show();
    }

    public void addSlogoTab(){
        myController.initNewTab();
        SlogoTab addTab = myViewFactory.getSlogoTab(tabCount,DEFAULT_WIDTH,DEFAULT_HEIGHT,myController);
        windowRoot.getTabs().add(addTab);
        tabCount++;
    }

    private void handleTransition() {
        windowRoot = new TabPane();
        Scene mainWindow = new Scene(windowRoot, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        myStage.setScene(mainWindow);
        addSlogoTab();
    }

    public static void main(String[] args){
        launch(args);
    }
}
