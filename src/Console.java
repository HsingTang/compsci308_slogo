import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import java.util.List;

public class Console {
    public static final double CONSOLE_X_POS = 350;
    public static final double CONSOLE_Y_POS = 610;


    private TextArea myTextArea;
    private Button myExecuteButton;
    private Button myClearButton;
    private List<String> myCommands;

    public Console(double width, double height) {
        myTextArea = new TextArea();
        myTextArea.setMaxWidth(width);
        myTextArea.setMaxHeight(height);
        myTextArea.setLayoutX(CONSOLE_X_POS);
        myTextArea.setLayoutY(CONSOLE_Y_POS);
        myTextArea.setWrapText(true);
    }

    public TextArea getMyTextArea() {
        return this.myTextArea;
    }

}
