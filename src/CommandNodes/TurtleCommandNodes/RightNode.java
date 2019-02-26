package CommandNodes.TurtleCommandNodes;

import CommandNodes.CommandNode;
import Controller.ControllerInterfaces.CommandControllerInterface;

public class RightNode extends TurtleCommandNode {
   private static int RIGHT_PARAMS = 1;

   private double myDegrees;

   public RightNode(CommandControllerInterface inController){
      super(inController);
      this.setMyNumParams(RIGHT_PARAMS);
   }

   public RightNode(CommandControllerInterface inController, CommandNode inParent){
      super(inController, inParent);
      this.setMyNumParams(RIGHT_PARAMS);
   }

   public void execute(){
      this.parseParameters();
      this.myController.turnRight(this.myDegrees);
   }

   protected void parseParameters(){
      try {
         this.myDegrees = this.getDegrees();
      }
      catch(Exception e){
         /**
          * Error regarding parameter parsing
          */
      }
   }
}
