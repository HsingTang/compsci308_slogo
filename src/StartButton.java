import javafx.scene.control.Button;

public class StartButton extends Button {

    public static final String ENTER_TEXT = "Start SLogo IDE";
    public static final double BUTTON_WIDTH = 150;

    public StartButton() {
        super(ENTER_TEXT);
        this.setWidth(BUTTON_WIDTH);
    }

}
