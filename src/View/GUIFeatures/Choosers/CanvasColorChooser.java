package View.GUIFeatures.Choosers;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

public class CanvasColorChooser extends ColorPicker {

    public static final Color DEFAULT_COLOR = Color.BLACK;

    public CanvasColorChooser() {
        super();
        this.setValue(DEFAULT_COLOR);
    }
}

