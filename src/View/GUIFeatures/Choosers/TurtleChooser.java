package View.GUIFeatures.Choosers;

import View.GUIFeatures.Buttons.TurtleChooserButton;
import View.Turtles.TurtleView;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;

/**
 * Chooses image of turtle
 * @author Hsingchih Tang
 * @author Eric Lin
 */
public class TurtleChooser {

    private FileChooser turtleChooser;
    private TurtleChooserButton turtleChooserButton;
    public final double BUTTON_IMAGE_SIZE = 35;

    /**
     * Creates an instance of the turtle chooser
     */
    public TurtleChooser() {
        turtleChooser = makeChooser();
        turtleChooserButton = new TurtleChooserButton("Choose Turtle Image");
        turtleChooserButton.getStyleClass().add("round-red");
    }

    /**
     * Makes the TurtleChooserButton to display the same image as the TurtleView passed in
     * @param turtleView the TurtleView whose image is to be used for setting up the button visualization
     */
    public TurtleChooser(TurtleView turtleView){
        turtleChooser = makeChooser();
        turtleChooserButton = new TurtleChooserButton();
        this.setButtonImage(turtleView.getImgView().getImage());
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

    /**
     * Set the button to display an image instead of pure text and set limits on the button's size
     * @param image the new Image to use for displaying the button
     */
    public void setButtonImage(Image image){
        ImageView imgView = new ImageView(image);
        this.turtleChooserButton.setGraphic(imgView);
        this.turtleChooserButton.setMaxWidth(BUTTON_IMAGE_SIZE);
        this.turtleChooserButton.setMaxHeight(BUTTON_IMAGE_SIZE);
    }

}
