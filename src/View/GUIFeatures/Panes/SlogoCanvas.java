package View.GUIFeatures.Panes;

import javafx.scene.canvas.Canvas;

/**
 * @author Hsingchih Tang
 * Region where the TurtleView moves and draws down its path
 * Extends Javafx.Canvas to enable drawing feature
 */
public class SlogoCanvas extends Canvas {



    public SlogoCanvas(double w, double h) {
        super(w,h);
        this.setWidth(w);
        this.setHeight(h);
        this.getStyleClass().add("canvas");
    }




}
