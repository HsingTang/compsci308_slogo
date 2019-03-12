package View.GUIFeatures.Choosers;

import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

/**
 * Chooses the color of the turtles pen
 *
 * @author Eric Lin
 */
public class PenColorChooser extends ColorPicker  {

    public static final Color DEFAULT_COLOR = Color.WHITE;

    /**
     * creates instance of pen color chooser
     */
    public PenColorChooser() {
        super();
        this.setValue(DEFAULT_COLOR);
    }
}
