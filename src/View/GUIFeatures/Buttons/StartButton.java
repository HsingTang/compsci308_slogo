package View.GUIFeatures.Buttons;

import javafx.scene.control.Button;

/**
 * starts the program from start screen to main screen
 *
 * @author Eric Lin
 */
public class StartButton extends Button {

    public static final String ENTER_TEXT = "Start SLogo IDE";

    /**
     * creates instance of start button
     *
     * @param xPos  x position of button
     * @param yPos  y position of button
     */
    public StartButton(double xPos, double yPos) {
        super(ENTER_TEXT);
        this.setLayoutX(xPos);
        this.setLayoutY(yPos);
        this.getStyleClass().add("start-button");
    }

}