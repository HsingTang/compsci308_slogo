package GUIFeatures;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Canvas extends Rectangle {

    public static final Color DEFAULT_COLOR = Color.WHITE;

    public Canvas(double width, double height, double xPos, double yPos) {
        super(xPos, yPos, width, height);
        this.setFill(DEFAULT_COLOR);

    }

}
