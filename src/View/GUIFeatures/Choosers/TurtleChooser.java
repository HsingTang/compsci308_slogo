package View.GUIFeatures.Choosers;

import View.GUIFeatures.Buttons.TurtleChooserButton;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

import java.io.File;

/**
 * Chooses image of turtle
 *
 * @author Eric Lin
 */
public class TurtleChooser {

    private FileChooser turtleChooser;
    private TurtleChooserButton turtleChooserButton;

    /**
     * Creates an instance of the turtle chooser
     */
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

    /**
     * gets the button in the file chooser
     *
     * @return file chooser button
     */
    public Button getButton() {
        return this.turtleChooserButton;
    }

    /**
     * gets the file chooser
     *
     * @return file chooser
     */
    public FileChooser getTurtleChooser() {
        return this.turtleChooser;
    }

}
