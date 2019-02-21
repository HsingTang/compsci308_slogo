package GUIFeatures;

import javafx.scene.control.Button;

public class ClearButton extends Button {
    public static final String CLEAR_STRING = "Clear";

    public ClearButton() {
        super(CLEAR_STRING);
        this.getStyleClass().add("clear-button");
    }
}
