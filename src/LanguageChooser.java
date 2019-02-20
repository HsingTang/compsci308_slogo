import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class LanguageChooser {

    private ComboBox myChooser;

    public LanguageChooser() {
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

    }
}
