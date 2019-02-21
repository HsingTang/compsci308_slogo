package GUIFeatures;
import javafx.scene.control.ComboBox;
import java.util.ResourceBundle;
import java.util.TreeSet;

public class CanvasColorChooser extends ComboBox {

    public static final String PROMPT_TEXT = "Choose SlogoCanvas Color";

    private ResourceBundle colorsBundle = ResourceBundle.getBundle("colors/Colors");

    public CanvasColorChooser() {
        super();
        TreeSet<String> colors = new TreeSet<>();
        for (String key : colorsBundle.keySet()) {
            String value = colorsBundle.getString(key);
            colors.add(value);
        }
        this.getItems().addAll(colors);
        this.setPromptText(PROMPT_TEXT);
    }


}

