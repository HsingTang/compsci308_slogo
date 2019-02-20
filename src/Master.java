import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Master extends Application {

    public static final String PROJECT_NAME = "SLogo IDE";
    public static final double HEIGHT = 800;
    public static final double WIDTH = 1200;

    private Pane root;
    private Stage myStage;
    private Scene mainWindow;
    private SplashScreen startScreen;

    public void start(Stage myStage) {
        root = new Pane();
        this.myStage = myStage;
        startScreen = new SplashScreen(root, WIDTH, HEIGHT);
        myStage.setTitle(PROJECT_NAME);
        myStage.setScene(startScreen);
        myStage.show();
        startScreen.getStartButton().setOnAction(e -> handleTransition());
    }

    private void handleTransition() {
        root = new Pane();
        mainWindow = new Window(root, WIDTH, HEIGHT);
        myStage.setScene(mainWindow);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
