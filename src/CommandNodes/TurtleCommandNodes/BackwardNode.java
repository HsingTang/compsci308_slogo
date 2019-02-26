package CommandNodes.TurtleCommandNodes;

import CommandNodes.CommandNode;
import Controller.ControllerInterfaces.CommandControllerInterface;

public class BackwardNode extends TurtleCommandNode {
   private static int BACKWARD_PARAMS = 1;

   private double myPixels;

   public BackwardNode(CommandControllerInterface inController){
      super(inController);
      this.setMyNumParams(BACKWARD_PARAMS);
   }

   public BackwardNode(CommandControllerInterface inController, CommandNode inParent){
      super(inController, inParent);
      this.setMyNumParams(BACKWARD_PARAMS);
   }

   public void execute(){
      this.parseParameters();
      this.myController.moveBackwards(this.myPixels);
   }

   protected void parseParameters(){
      try {
         this.myPixels = this.getPixels();
      }
      catch(Exception e){
         /**
          * Error regarding parameter parsing
          */
      }
   }
}
