import javafx.scene.control.Button;

public class StartButton extends Button {

    public static final String ENTER_TEXT = "Start SLogo Program";
    public static final double BUTTON_WIDTH = 180;

    public StartButton() {
        super(ENTER_TEXT);
        this.setWidth(BUTTON_WIDTH);
    }

}
