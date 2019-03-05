package View.GUIFeatures.Buttons;

import javafx.scene.control.Button;

public class HelpButton extends Button {
    public static final String HELP_STRING = "Help";

    public HelpButton() {
        super(HELP_STRING);
        this.getStyleClass().add("help-button");
    }

}
