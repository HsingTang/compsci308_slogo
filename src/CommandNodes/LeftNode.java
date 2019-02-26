package CommandNodes;

import Controller.ControllerInterfaces.CommandControllerInterface;

public class LeftNode extends TurtleCommandNode{
   private static int LEFT_PARAMS = 1;

   private double myDegrees;

   public LeftNode(CommandControllerInterface inController){
      super(inController);
      this.setMyNumParams(LEFT_PARAMS);
   }

   public LeftNode(CommandControllerInterface inController, CommandNode inParent){
      super(inController, inParent);
      this.setMyNumParams(LEFT_PARAMS);
   }

   public void execute(){
      this.parseParameters();
      this.myController.turnLeft(this.myDegrees);
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
