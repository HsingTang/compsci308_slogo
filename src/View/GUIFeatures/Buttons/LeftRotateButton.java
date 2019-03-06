package View.GUIFeatures.Buttons;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LeftRotateButton extends Button {

    static final double BUTTON_SIZE = 20;

    public LeftRotateButton(){
        super();
        ImageView buttonImage = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("left-button.png")));
        this.setGraphic(buttonImage);
        buttonImage.setFitWidth(BUTTON_SIZE);
        buttonImage.setFitHeight(BUTTON_SIZE);
        this.setId("lt 45");
    }
}
