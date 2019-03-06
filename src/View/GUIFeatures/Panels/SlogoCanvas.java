package View.GUIFeatures.Panels;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

/**
 * @author Hsingchih Tang
 * Region where the TurtleView moves and draws down its path
 * Extends Javafx.Canvas to enable drawing feature
 */
public class SlogoCanvas extends Canvas {

    public static final Color DEFAULT_COLOR = Color.BLACK;

    private Color myColor;

    public SlogoCanvas(double w, double h) {
        super(w,h);
        this.setWidth(w);
        this.setHeight(h);
        myColor = DEFAULT_COLOR;
        this.getGraphicsContext2D().setFill(DEFAULT_COLOR);
        this.getGraphicsContext2D().fillRect(0, 0, this.getWidth(), this.getHeight());
        this.getStyleClass().add("canvas");
    }

    public void setBackgroundColor(Color c){
        this.getGraphicsContext2D().setFill(c);
        this.getGraphicsContext2D().fillRect(0, 0, this.getWidth(), this.getHeight());
        myColor = c;
    }

    public Color getColor() {
        return this.myColor;
    }

}
