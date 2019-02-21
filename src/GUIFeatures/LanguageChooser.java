package GUIFeatures;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class LanguageChooser {

    public static final String PROMPT_TEXT = "Choose Language";

    private ComboBox myChooser;

    public LanguageChooser(double xPos, double yPos) {
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
        myChooser = new ComboBox(languages);
        myChooser.getStyleClass().add("combo-box");
        myChooser.setPromptText(PROMPT_TEXT);
        myChooser.setLayoutX(xPos);
        myChooser.setLayoutY(yPos);
    }

    public ComboBox getMyChooser() {
        return this.myChooser;
    }
}
