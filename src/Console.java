import javafx.scene.control.TextArea;
import java.util.List;

public class Console {

    public static final String PROMPT_TEXT = "Enter Commands Here";

    private TextArea myTextArea;
    private List<String> myCommands;

    public Console(double width, double height, double xPos, double yPos) {
        myTextArea = new TextArea();
        myTextArea.setMaxWidth(width);
        myTextArea.setMaxHeight(height);
        myTextArea.setLayoutX(xPos);
        myTextArea.setLayoutY(yPos);
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
