package View.GUIFeatures.Choosers;

import javafx.scene.control.ComboBox;

import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;

/**
 * Chooses language of the parser to understand
 *
 * @author Eric Lin
 */
public class LanguageChooser extends ComboBox {

    public static final String PROMPT_TEXT = "English";

    private final ResourceBundle languageListBundle = ResourceBundle.getBundle("languages/LanguageList");

    /**
     * Creates an instance of the language chooser button
     */
    public LanguageChooser() {
        super();
        this.getStyleClass().add("language-chooser");
        Set<String> languages = new TreeSet<>();
        for (String key : languageListBundle.keySet()) {
            String value = languageListBundle.getString(key);
            languages.add(value);
        }
        this.getItems().addAll(languages);
        this.setPromptText(PROMPT_TEXT);
    }
}
