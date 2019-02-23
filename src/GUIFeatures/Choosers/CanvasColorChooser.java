package GUIFeatures.Choosers;
import javafx.scene.control.ComboBox;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;

public class CanvasColorChooser extends ComboBox {

    public static final String PROMPT_TEXT = "Choose Canvas Color";

    private ResourceBundle colorsBundle = ResourceBundle.getBundle("colors/Colors");

    public CanvasColorChooser() {
        super();
        Set<String> colors = new TreeSet<>();
        for (String key : colorsBundle.keySet()) {
            String value = colorsBundle.getString(key);
            colors.add(value);
        }
        this.getItems().addAll(colors);
        this.setPromptText(PROMPT_TEXT);
    }


}

