import javafx.scene.control.Button;

public class ClearButton extends Button {
    public static final String CLEAR_STRING = "Clear";
    public static final double BUTTON_WIDTH = 180;

    public ClearButton() {
        super(CLEAR_STRING);
        this.setWidth(BUTTON_WIDTH);
    }
}
