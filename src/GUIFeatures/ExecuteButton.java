package GUIFeatures;

import javafx.scene.control.Button;

public class ExecuteButton extends Button {
    public static final String EXECUTE_STRING = "Execute";

    public ExecuteButton(double xPos, double yPos) {
        super(EXECUTE_STRING);
        this.setLayoutX(xPos);
        this.setLayoutY(yPos);
        this.getStyleClass().add("execute-button");
    }
}
