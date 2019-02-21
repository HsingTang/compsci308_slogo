package GUIFeatures;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class LanguageChooser extends ComboBox {

    public static final String PROMPT_TEXT = "Choose Language";

    public LanguageChooser() {
        super();
        ObservableList<String> languages = FXCollections.observableArrayList(
                "English",
                "Chinese",
                "French",
                "German",
                "Italian",
                "Portuguese",
                "Russian",
                "Spanish",
                "Urdu"
        );
        this.getItems().addAll(languages);
        this.setPromptText(PROMPT_TEXT);
    }
}
