import View.SplashScreen;
import View.Window;
import javafx.application.Application;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Master extends Application {

    public static final String PROJECT_NAME = "SLogo IDE";
    public static final double DEFAULT_HEIGHT = 800;
    public static final double DEFAULT_WIDTH = 1200;

    private Pane splashRoot;
    private TabPane windowRoot;
    private Stage myStage;

    public Master(){
        super();
    }

    public void start(Stage myStage) {
        splashRoot = new Pane();
        this.myStage = myStage;
        SplashScreen startScreen = new SplashScreen(splashRoot, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        myStage.setTitle(PROJECT_NAME);
        myStage.setScene(startScreen);
        myStage.show();
        startScreen.getStartButton().setOnAction(e -> handleTransition());
    }

    private void handleTransition() {
        windowRoot = new TabPane();
        Window mainWindow = new Window(windowRoot, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        myStage.setScene(mainWindow);
    }

    /*
    public static void main(String[] args) {
        launch(args);
    }
    */
}
