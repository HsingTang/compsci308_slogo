import javafx.scene.control.Button;

public class ExecuteButton extends Button {
    public static final String EXECUTE_STRING = "Execute";
    public static final double BUTTON_WIDTH = 180;

    public ExecuteButton() {
        super(EXECUTE_STRING);
        this.setWidth(BUTTON_WIDTH);
    }
}
