package View.GUIFeatures.Choosers;
import javafx.scene.control.ComboBox;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;

public class LanguageChooser extends ComboBox {

    public static final String PROMPT_TEXT = "Choose Language";

    private final ResourceBundle languageListBundle = ResourceBundle.getBundle("languages/LanguageList");

    public LanguageChooser() {
        super();
        Set<String> languages = new TreeSet<>();
        for (String key : languageListBundle.keySet()) {
            String value = languageListBundle.getString(key);
            languages.add(value);
        }
        this.getItems().addAll(languages);
        this.setPromptText(PROMPT_TEXT);
    }
}
