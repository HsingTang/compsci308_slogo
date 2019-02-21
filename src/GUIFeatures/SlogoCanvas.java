package GUIFeatures;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class SlogoCanvas extends Canvas {

    public static final Color DEFAULT_COLOR = Color.WHITE;

    public SlogoCanvas() {
        super();
        this.getGraphicsContext2D().setFill(DEFAULT_COLOR);
        this.getStyleClass().add("canvas");
    }

}
