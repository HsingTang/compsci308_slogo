package View.GUIFeatures.Panes;

import javafx.scene.canvas.Canvas;

/**
 * @author Hsingchih Tang
 * Region where the TurtleView moves and draws down its path
 * Extends Javafx.Canvas to enable drawing feature
 */
public class SlogoCanvas extends Canvas {

    /**
     * Instantiates a SlogoCanvas object. There should be one SlogoCanvas per tab.
     * @param w width of the canvas
     * @param h height of the canvas
     */
    public SlogoCanvas(double w, double h) {
        super(w,h);
        this.setWidth(w);
        this.setHeight(h);
        this.getStyleClass().add("canvas");
    }

}
