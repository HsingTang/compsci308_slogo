import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class Window extends Scene {

    public static final String STYLE_SHEET = "StyleWindow.css";
    public static final double CONSOLE_WIDTH = 700;
    public static final double CONSOLE_HEIGHT = 150;
    public static final double CONSOLE_X_POS = 325;
    public static final double CONSOLE_Y_POS = 600;
    public static final double EXECUTE_X_POS = 757;
    public static final double EXECUTE_Y_POS = 755;
    public static final double CLEAR_X_POS = 660;
    public static final double CLEAR_Y_POS = 755;
    public static final double CHOOSER_X_POS = 1035;
    public static final double CHOOSER_Y_POS = 10;

    private double width;
    private double height;
    private Pane root;
    private Console myConsole;
    private Button myExecuteButton;
    private Button myClearButton;
    private LanguageChooser myLanguageChooser;

    public Window(Pane root, double width, double height) {
        super(root, width, height);
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
        displayChooser();
    }

    private void initializeNodes() {
        initializeButton(myExecuteButton);
        initializeButton(myClearButton);
    }

    private void displayConsole() {
        myConsole = new Console(CONSOLE_WIDTH, CONSOLE_HEIGHT, CONSOLE_X_POS, CONSOLE_Y_POS);
        root.getChildren().add(myConsole.getMyTextArea());
    }

    private void displayExecuteButton() {
        myExecuteButton = new ExecuteButton(EXECUTE_X_POS, EXECUTE_Y_POS);
        root.getChildren().add(myExecuteButton);
    }

    private void displayClearButton() {
        myClearButton = new ClearButton(CLEAR_X_POS, CLEAR_Y_POS);
        root.getChildren().add(myClearButton);
    }

    private void displayChooser() {
        myLanguageChooser = new LanguageChooser(CHOOSER_X_POS, CHOOSER_Y_POS);
        root.getChildren().add(myLanguageChooser.getMyChooser());
    }

    private void initializeButton(Button button) {
        button.setOnAction(e -> handlePress(button));
    }

    private void handlePress(Button button) {
        if (button instanceof ClearButton) {
            myConsole.clearText();
        }
    }

}
