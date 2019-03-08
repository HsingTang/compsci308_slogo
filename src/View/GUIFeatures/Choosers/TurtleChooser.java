package View.GUIFeatures.Choosers;

import View.GUIFeatures.Buttons.TurtleChooserButton;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

import java.io.File;

public class TurtleChooser {

    private FileChooser turtleChooser;
    private TurtleChooserButton turtleChooserButton;

    public TurtleChooser() {
        turtleChooser = makeChooser();
        turtleChooserButton = new TurtleChooserButton("Choose Turtle Image");
        turtleChooserButton.getStyleClass().add("round-red");
    }

    private FileChooser makeChooser () {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open Image File");
        chooser.setInitialDirectory(new File("resources/Turtles"));
        chooser.getExtensionFilters().setAll(new FileChooser.ExtensionFilter("Image File", "*.png", "*.jpeg", "*.jpg"));
        return chooser;
    }

    public Button getButton() {
        return this.turtleChooserButton;
    }

    public FileChooser getTurtleChooser() {
        return this.turtleChooser;
    }

}
