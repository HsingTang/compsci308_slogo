package View.GUIFeatures.Choosers;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

/**
 * Chooses the color of the canvas
 *
 * @author Eric Lin
 */
public class CanvasColorChooser extends ColorPicker {

    public static final Color DEFAULT_COLOR = Color.BLACK;

    /**
     * Creates an instance of the canvas color chooser
     */
    public CanvasColorChooser() {
        super();
        this.setValue(DEFAULT_COLOR);
    }
}

