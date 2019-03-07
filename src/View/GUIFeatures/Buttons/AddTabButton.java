package View.GUIFeatures.Buttons;

import javafx.scene.control.Button;


public class AddTabButton extends Button {
    public static final String ADD_TAB_STRING = "Add a new tab";

    public AddTabButton() {
        super(ADD_TAB_STRING);
        this.getStyleClass().add("add-button");
    }

}
