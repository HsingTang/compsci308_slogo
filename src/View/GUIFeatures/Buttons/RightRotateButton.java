package View.GUIFeatures.Buttons;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Rotates the turtle right
 *
 * @author Eric Lin
 */
public class RightRotateButton extends Button {

    static final double BUTTON_SIZE = 20;

    /**
     * creates instance of the right rotate button
     */
    public RightRotateButton() {
        super();
        ImageView buttonImage = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("right-button.png")));
        this.setGraphic(buttonImage);
        buttonImage.setFitWidth(BUTTON_SIZE);
        buttonImage.setFitHeight(BUTTON_SIZE);
        this.setId("rt 45");
    }
}
