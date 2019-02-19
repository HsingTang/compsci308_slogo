import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class Window extends Scene {

    private double width;
    private double height;
    private Group root;

    public Window(Group root, double width, double height, Color background) {
        super(root, width, height, background);
        this.root = root;
        this.width = width;
        this.height = height;

    }
}
