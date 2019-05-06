package View.GUIFeatures.Panes;

import Controller.ControllerInterface;
import View.GUIFeatures.Choosers.TurtleChooser;
import View.Turtles.TurtleView;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;

public class ViewAllTurtles extends Group {
   private ControllerInterface controller;
   private TurtleView turtle;
   private ImageView addTurtle;
   private TurtleChooser turtleChooser;
   private int tabId;
   private Stage stage;

   ViewAllTurtles(int id, ControllerInterface controller) {
      super();
      this.turtleChooser = new TurtleChooser();
      this.controller = controller;
      this.tabId = id;
      viewTurtles();
   }

   private void viewTurtles(){
      addTurtle = new ImageView(controller.getTurtleView(this.tabId).getImgView().getImage());
      this.getChildren().add(addTurtle);
      addTurtle.setOnMousePressed(e -> switchImage());
   }

   private void switchImage(){
      File turtleImage = turtleChooser.getTurtleChooser().showOpenDialog(stage);
      try {
         turtle.setImgView(new Image(turtleImage.toURI().toURL().toExternalForm()));
      }
      catch(MalformedURLException e){}
      addTurtle.setImage(turtle.getImgView().getImage());

   }

   public void setStage(Stage inStage){
      stage = inStage;
   }
}
