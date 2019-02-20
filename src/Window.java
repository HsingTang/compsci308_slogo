import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;

public class Window extends Scene {

    public static final String STYLE_SHEET = "StyleWindow.css";
    public static final double CONSOLE_WIDTH = 500;
    public static final double CONSOLE_HEIGHT = 300;

    private double width;
    private double height;
    private Group root;
    private Console myConsole;

    public Window(Group root, double width, double height, Color background) {
        super(root, width, height, background);
        this.root = root;
        this.width = width;
        this.height = height;
        this.getStylesheets().add(STYLE_SHEET);
        displayConsole();

    }

    private void displayConsole() {
        myConsole = new Console(CONSOLE_WIDTH, CONSOLE_HEIGHT);
        TextArea consoleTextArea = myConsole.getMyTextArea();
        consoleTextArea.getStyleClass().add("console-text-area");
        root.getChildren().add(myConsole.getMyTextArea());
    }
}
