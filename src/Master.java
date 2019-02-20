import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Master extends Application {

    public static final String PROJECT_NAME = "SLogo IDE";
    public static final Color SPLASH_SCREEN_COLOR = Color.DIMGRAY;
    public static final Color WINDOW_COLOR = Color.LIGHTGRAY;
    public static final double HEIGHT = 800;
    public static final double WIDTH = 1200;

    private Group root;
    private Stage myStage;
    private Scene mainWindow;
    private SplashScreen startScreen;

    public void start(Stage myStage) {
        root = new Group();
        this.myStage = myStage;
        startScreen = new SplashScreen(root, WIDTH, HEIGHT, SPLASH_SCREEN_COLOR);
        myStage.setTitle(PROJECT_NAME);
        myStage.setScene(startScreen);
        myStage.show();
        startScreen.getStartButton().setOnAction(e -> handleTransition());
    }

    private void handleTransition() {
        root = new Group();
        mainWindow = new Window(root, WIDTH, HEIGHT, WINDOW_COLOR);
        myStage.setScene(mainWindow);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
