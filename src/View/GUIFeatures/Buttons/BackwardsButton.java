package View.GUIFeatures.Buttons;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * BacwkardsButton Class: Button to move turtle backwards
 *
 * @author Eric Lin
 */
public class BackwardsButton extends Button {

    static final double BUTTON_SIZE = 20;

    /**
     * Creates instance of backward button
     */
    public BackwardsButton() {
        super();
        ImageView buttonImage = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("down-button.png")));
        this.setGraphic(buttonImage);
        buttonImage.setFitWidth(BUTTON_SIZE);
        buttonImage.setFitHeight(BUTTON_SIZE);
        this.setId("bk 50");
    }
}
