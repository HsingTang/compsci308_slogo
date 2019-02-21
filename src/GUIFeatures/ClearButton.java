package GUIFeatures;

import javafx.scene.control.Button;

public class ClearButton extends Button {
    public static final String CLEAR_STRING = "Clear";

    public ClearButton(double xPos, double yPos) {
        super(CLEAR_STRING);
        this.setLayoutX(xPos);
        this.setLayoutY(yPos);
        this.getStyleClass().add("clear-button");
    }
}
