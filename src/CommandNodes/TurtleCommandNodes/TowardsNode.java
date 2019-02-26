package CommandNodes.TurtleCommandNodes;

import CommandNodes.CommandNode;
import Controller.ControllerInterfaces.CommandControllerInterface;

public class TowardsNode extends TurtleCommandNode{
   private static int TOWARDS_PARAMS = 2;

   private double myX;
   private double myY;

   public TowardsNode(CommandControllerInterface inController){
      super(inController);
      this.setMyNumParams(TOWARDS_PARAMS);
   }

   public TowardsNode(CommandControllerInterface inController, CommandNode inParent){
      super(inController, inParent);
      this.setMyNumParams(TOWARDS_PARAMS);
   }

   public void execute(){
      this.parseParameters();
      this.myController.turnTowards(this.myX, this.myY);
   }

   protected void parseParameters(){
      try {
         this.myX = this.getX();
         this.myY = this.getY();
      }
      catch(Exception e){
         /**
          * Error regarding parameter parsing
          */
      }
   }
}
