import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class SplashScreen extends Scene {

    public static final String STYLE_SHEET = "StyleStartScreen.css";
    public static final double BUTTON_Y_OFFSET = 100;
    public static final double IMAGE_Y_OFFSET = 150;
    public static final double TEXT_Y_OFFSET = 100;
    public static final double TEXT_X_OFFSET = 210;
    public static final int FONT_SIZE = 70;
    public static final double STROKE_WIDTH = 2;
    public static final String TITLE_TEXT = "SLogo IDE";

    private double width;
    private double height;
    private Button startButton;
    private Group root;
    private Image startImage;
    private ImageView startImageView;
    private Text startText;

    public SplashScreen(Group root, double width, double height, Color background) {
        super(root, width, height, background);
        this.root = root;
        this.width = width;
        this.height = height;
        this.getStylesheets().add(STYLE_SHEET);
        displayButton();
        displayImage();
        displayText();
        initializeButton();
    }

    public Button getStartButton() {
        return this.startButton;
    }

    private void displayButton() {
        startButton = new StartButton();
        startButton.setLayoutX(width/2 - startButton.getWidth()/2);
        startButton.setLayoutY(height - BUTTON_Y_OFFSET);
        startButton.getStyleClass().add("start-button");
        root.getChildren().add(startButton);
    }

    private void displayText() {
        startText = new Text(TITLE_TEXT);
        startText.setX(width/2 - TEXT_X_OFFSET);
        startText.setY(TEXT_Y_OFFSET);
        startText.setFill(Color.WHITE);
        startText.setStroke(Color.BLACK);
        startText.setStrokeWidth(STROKE_WIDTH);
        startText.setTextAlignment(TextAlignment.CENTER);
        startText.setFont(Font.font("Verdana", FontWeight.BOLD, FONT_SIZE));
        root.getChildren().add(startText);

    }

    private void displayImage(){
       startImage = new Image("torus.png");
       startImageView = new ImageView(startImage);
       startImageView.setX(width/2 - startImage.getWidth()/2);
       startImageView.setY(IMAGE_Y_OFFSET);
       startImageView.setPreserveRatio(true);
       root.getChildren().add(startImageView);
    }

    private void initializeButton() {
        startButton.addEventHandler(MouseEvent.MOUSE_ENTERED, e-> handleHover());
        startButton.addEventHandler(MouseEvent.MOUSE_EXITED, e-> handleLeave());
    }

    private void handleHover() {
        startButton.setStyle("-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );");
    }

    private void handleLeave() {
        startButton.setStyle("-fx-effect: none");
    }

}
