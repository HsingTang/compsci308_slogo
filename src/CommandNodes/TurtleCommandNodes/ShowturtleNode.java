package CommandNodes.TurtleCommandNodes;

import CommandNodes.CommandNode;
import Controller.ControllerInterfaces.CommandControllerInterface;

public class ShowturtleNode extends TurtleCommandNode{
   private static int TOGGLE_TURTLE_PARAMS = 0;

   public ShowturtleNode(CommandControllerInterface inController){
      super(inController);
      this.setMyNumParams(TOGGLE_TURTLE_PARAMS);
   }

   public ShowturtleNode(CommandControllerInterface inController, CommandNode inParent){
      super(inController, inParent);
      this.setMyNumParams(TOGGLE_TURTLE_PARAMS);
   }

   public void execute(){
      this.parseParameters();
      this.myController.showTurtle();
   }

   protected void parseParameters(){
   }
}
