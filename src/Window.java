import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Window extends Scene {

    public static final String STYLE_SHEET = "StyleWindow.css";
    public static final double CONSOLE_WIDTH = 700;
    public static final double CONSOLE_HEIGHT = 300;
    public static final double EXECUTE_X_POS = 757;
    public static final double EXECUTE_Y_POS = 755;
    public static final double CLEAR_X_POS = 660;
    public static final double CLEAR_Y_POS = 755;

    private double width;
    private double height;
    private Group root;
    private Console myConsole;
    private Button myExecuteButton;
    private Button myClearButton;

    public Window(Group root, double width, double height, Color background) {
        super(root, width, height, background);
        this.root = root;
        this.width = width;
        this.height = height;
        this.getStylesheets().add(STYLE_SHEET);
        displayNodes();
        initializeNodes();
    }

    private void displayNodes() {
        displayConsole();
        displayExecuteButton();
        displayClearButton();
    }

    private void initializeNodes() {
        initializeButton(myExecuteButton);
        initializeButton(myClearButton);
    }

    private void displayConsole() {
        myConsole = new Console(CONSOLE_WIDTH, CONSOLE_HEIGHT);
        TextArea consoleTextArea = myConsole.getMyTextArea();
        consoleTextArea.getStyleClass().add("console-text-area");
        root.getChildren().add(myConsole.getMyTextArea());
    }

    private void displayExecuteButton() {
        myExecuteButton = new ExecuteButton();
        myExecuteButton.getStyleClass().add("execute-button");
        myExecuteButton.setLayoutX(EXECUTE_X_POS);
        myExecuteButton.setLayoutY(EXECUTE_Y_POS);
        root.getChildren().add(myExecuteButton);
    }

    private void displayClearButton() {
        myClearButton = new ClearButton();
        myClearButton.getStyleClass().add("clear-button");
        myClearButton.setLayoutX(CLEAR_X_POS);
        myClearButton.setLayoutY(CLEAR_Y_POS);
        root.getChildren().add(myClearButton);

    }

    private void initializeButton(Button button) {
        button.addEventHandler(MouseEvent.MOUSE_ENTERED, e-> handleHover(button));
        button.addEventHandler(MouseEvent.MOUSE_EXITED, e-> handleLeave(button));
        button.setOnAction(e -> handlePress(button));
    }

    private void handleHover(Button button) {
        button.setStyle("-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );");
    }

    private void handleLeave(Button button) {
        button.setStyle("-fx-effect: none");
    }

    private void handlePress(Button button) {
        if (button instanceof ClearButton) {
            myConsole.clearText();
        }
    }

}
