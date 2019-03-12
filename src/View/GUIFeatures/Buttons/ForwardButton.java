package View.GUIFeatures.Buttons;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * ForwardButton Class: moves turtle forward
 *
 * @author Eric Lin
 */
public class ForwardButton extends Button {

    static final double BUTTON_SIZE = 20;

    /**
     * Creates instance of forward button
     */
    public ForwardButton() {
        super();
        ImageView buttonImage = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("up-button.png")));
        this.setGraphic(buttonImage);
        buttonImage.setFitWidth(BUTTON_SIZE);
        buttonImage.setFitHeight(BUTTON_SIZE);
        this.setId("fd 50");
    }

}
