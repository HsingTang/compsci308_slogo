package CommandNodes.TurtleCommandNodes;

import CommandNodes.CommandNode;
import Controller.ControllerInterfaces.CommandControllerInterface;

public class ForwardNode extends TurtleCommandNode {
   private static int FORWARD_PARAMS = 1;

   private double myPixels;

   public ForwardNode(CommandControllerInterface inController){
      super(inController);
      this.setMyNumParams(FORWARD_PARAMS);
   }

   public ForwardNode(CommandControllerInterface inController, CommandNode inParent){
      super(inController, inParent);
      this.setMyNumParams(FORWARD_PARAMS);
   }

   public void execute(){
      this.parseParameters();
      this.myController.moveForward(this.myPixels);
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
