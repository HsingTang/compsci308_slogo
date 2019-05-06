package View.GUIFeatures.Panes;

import Controller.ControllerInterface;
import Errors.MalformedTurtleImgException;
import View.GUIFeatures.Choosers.TurtleChooser;
import View.Turtles.TurtleView;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;

class TurtleViewThing extends Group {

    private int myID;
    private ControllerInterface myController;
    private TurtleView myTurtle;
    private ImageView newTurtle;
    private TurtleChooser chooser = new TurtleChooser();
    private Stage myStage;


    TurtleViewThing(int tabID, ControllerInterface myController) {
        super();
        myID = tabID;
        this.myController = myController;
        displayTurtles();
    }

    void setStage(Stage stage) {
        myStage = stage;
    }

    private void displayTurtles() {
        myTurtle = myController.getTurtleView(myID);
        newTurtle = new ImageView(myTurtle.getImgView().getImage());
        getChildren().add(newTurtle);
        newTurtle.setOnMousePressed(e -> changeTurtleImage());
    }

    private void changeTurtleImage() throws MalformedTurtleImgException {
        File dataFile = chooser.getTurtleChooser().showOpenDialog(myStage);
        try {
            Image newImage = new Image(dataFile.toURI().toURL().toExternalForm());
            myTurtle.setImgView(newImage);
            newTurtle.setImage(myTurtle.getImgView().getImage());
        } catch (MalformedURLException e) {
            throw new MalformedTurtleImgException(e);
        }
    }
}
