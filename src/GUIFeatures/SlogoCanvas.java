package GUIFeatures;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class SlogoCanvas extends Canvas {

    public static final Color DEFAULT_COLOR = Color.BLACK;


    public SlogoCanvas(double w, double h) {
        super(w,h);
        this.setWidth(w);
        this.setHeight(h);
        this.getGraphicsContext2D().setFill(DEFAULT_COLOR);
        this.getGraphicsContext2D().fillRect(0, 0, this.getWidth(), this.getHeight());
        this.getStyleClass().add("canvas");
    }

    public void setBackgroundColor(Color c){
        this.getGraphicsContext2D().setFill(c);
        this.getGraphicsContext2D().fillRect(0, 0, this.getWidth(), this.getHeight());
    }

}
