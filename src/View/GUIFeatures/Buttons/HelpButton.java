package View.GUIFeatures.Buttons;

import javafx.scene.control.Button;

/**
 * HelpButton class: Button to go to command help page
 *
 * @author Eric Lin
 */
public class HelpButton extends Button {
    public static final String HELP_STRING = "Help";

    /**
     * Creates instance of Help Button
     */
    public HelpButton() {
        super(HELP_STRING);
        this.getStyleClass().add("help-button");
    }

}
