package View;

import View.GUIFeatures.Buttons.StartButton;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class SplashScreen extends Scene {

    public static final String STYLE_SHEET = "stylesheets/StyleStartScreen.css";
    public static final double BUTTON_X_OFFSET = 530;
    public static final double BUTTON_Y_OFFSET = 710;
    public static final double IMAGE_Y_OFFSET = 150;
    public static final double TEXT_Y_OFFSET = 100;
    public static final double TEXT_X_OFFSET = 210;
    public static final int FONT_SIZE = 70;
    public static final double STROKE_WIDTH = 2;
    public static final String TITLE_TEXT = "SLogo IDE";

    private double width;
    private double height;
    private Button startButton;
    private Pane root;

    public SplashScreen(Pane root, double width, double height) {
        super(root, width, height);
        this.root = root;
        this.width = width;
        this.height = height;
        this.getStylesheets().add(STYLE_SHEET);
        displayNodes();
    }

    private void displayNodes() {
        displayButton();
        displayImage();
        displayText();
    }

    public Button getStartButton() {
        return this.startButton;
    }

    private void displayButton() {
        startButton = new StartButton(BUTTON_X_OFFSET, BUTTON_Y_OFFSET);
        root.getChildren().add(startButton);
    }

    private void displayText() {
        Text startText = new Text(TITLE_TEXT);
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
       Image startImage = new Image("torus.png");
       ImageView startImageView = new ImageView(startImage);
       startImageView.setX(width/2 - startImage.getWidth()/2);
       startImageView.setY(IMAGE_Y_OFFSET);
       startImageView.setPreserveRatio(true);
       root.getChildren().add(startImageView);
    }

}
