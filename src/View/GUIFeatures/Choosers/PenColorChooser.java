package View.GUIFeatures.Choosers;

import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

public class PenColorChooser extends ColorPicker  {

    public static final Color DEFAULT_COLOR = Color.WHITE;

    public PenColorChooser() {
        super();
        this.setValue(DEFAULT_COLOR);
    }
}
