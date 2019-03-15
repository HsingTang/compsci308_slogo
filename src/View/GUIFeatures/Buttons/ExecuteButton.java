package View.GUIFeatures.Buttons;

import javafx.scene.control.Button;

/**
 * ExecuteButton: Button to transfer commands to parser
 *
 * @author Eric Lin
 */
public class ExecuteButton extends Button {
    public static final String EXECUTE_STRING = "Execute";

    public ExecuteButton() {
        super(EXECUTE_STRING);
        this.getStyleClass().add("execute-button");
    }
}
