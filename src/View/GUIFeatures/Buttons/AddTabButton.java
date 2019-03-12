package View.GUIFeatures.Buttons;

import javafx.scene.control.Button;

/**
 * AddTabButton Class: Button to add tabs/workspaces
 *
 * @author Eric Lin
 */
public class AddTabButton extends Button {

    public static final String ADD_TAB_STRING = "Add a new tab";

    /**
     * Constructs an instance of a tab button
     */
    public AddTabButton() {
        super(ADD_TAB_STRING);
        this.getStyleClass().add("add-button");
    }

}
