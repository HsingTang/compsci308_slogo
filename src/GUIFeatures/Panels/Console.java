package GUIFeatures.Panels;

import javafx.scene.control.TextArea;
import java.util.List;

public class Console {

    public static final String PROMPT_TEXT = "Enter Commands Here";

    private TextArea myTextArea;
    private List<String> myCommands;

    public Console(double w, double h) {
        myTextArea = new TextArea();
        myTextArea.setMaxSize(w,h);
        myTextArea.setPromptText(PROMPT_TEXT);
        myTextArea.setFocusTraversable(false);
        myTextArea.setWrapText(true);
        myTextArea.getStyleClass().add("console-text-area");
    }

    public void clearText() {
        myTextArea.clear();
    }

    public TextArea getMyTextArea() {
        return this.myTextArea;
    }

}
