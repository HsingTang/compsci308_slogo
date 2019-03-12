package View.GUIFeatures.Buttons;

import javafx.scene.control.Button;

/**
 * Puts the pen down for the turtle
 *
 * @author Eric Lin
 */
public class PenDownButton extends Button {

    /**
     * creates instance of pen down button
     */
    public PenDownButton() {
        super();
        this.setText("Pen Down");
        this.setId("pendown");
    }
}
