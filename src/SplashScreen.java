import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class SplashScreen extends Scene {

    public static final String STYLE_SHEET = "StyleStartScreen.css";
    public static final double BUTTON_OFFSET = 200;

    private double width;
    private double height;
    private Button startButton;
    private Group root;

    public SplashScreen(Group root, double width, double height, Color background) {
        super(root, width, height, background);
        this.root = root;
        this.width = width;
        this.height = height;
        this.getStylesheets().add(STYLE_SHEET);
        displayButton();
    }

    private void displayButton() {
        startButton = new StartButton();
        startButton.setLayoutX(width/2 - startButton.getWidth()/2);
        System.out.println(startButton.getWidth());
        startButton.setLayoutY(height - BUTTON_OFFSET);
        startButton.getStyleClass().add("start-button");
        root.getChildren().add(startButton);

    }


}
