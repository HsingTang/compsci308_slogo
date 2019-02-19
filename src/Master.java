import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Master extends Application {

    public static final String PROJECT_NAME = "SLogo IDE";
    public static final Color SPLASH_SCREEN_COLOR = Color.GRAY;
    public static final double HEIGHT = 800;
    public static final double WIDTH = 1200;

    private Group root;
    private Scene myScene;

    public void start(Stage myStage) {
        root = new Group();
        myScene = new SplashScreen(root, WIDTH, HEIGHT, SPLASH_SCREEN_COLOR);
        myStage.setTitle(PROJECT_NAME);
        myStage.setScene(myScene);
        myStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
