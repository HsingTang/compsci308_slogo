package View.GUIFeatures.Buttons;

import javafx.scene.control.Button;

/**
 * ClearButton Class: Button to clear the console
 *
 * @author Eric Lin
 */
public class ClearButton extends Button {
    public static final String CLEAR_STRING = "Clear";

    /**
     * Creates an instance of clear button
     */
    public ClearButton() {
        super(CLEAR_STRING);
        this.getStyleClass().add("clear-button");
    }
}
