import javafx.scene.control.Button;

public class StartButton extends Button {

    public static final String ENTER_TEXT = "Start SLogo IDE";

    public StartButton(double xPos, double yPos) {
        super(ENTER_TEXT);
        this.setLayoutX(xPos);
        this.setLayoutY(yPos);
        this.getStyleClass().add("start-button");
    }

}
