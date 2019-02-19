import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class StartButton extends Button {

    public static final String ENTER_TEXT = "Start SLogo Program";
    public static final Color TEXT_COLOR = Color.WHITE;
    public static final double BUTTON_WIDTH = 180;

    public StartButton() {
        super(ENTER_TEXT);
        this.setTextFill(TEXT_COLOR);
        this.setWidth(BUTTON_WIDTH);
    }

}
