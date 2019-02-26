package CommandNodes.TurtleCommandNodes;

import CommandNodes.CommandNode;
import Controller.ControllerInterfaces.CommandControllerInterface;

public class SetpositionNode extends TurtleCommandNode{
   private static int SET_POSITION_PARAMS = 2;

   private double myX;
   private double myY;

   public SetpositionNode(CommandControllerInterface inController){
      super(inController);
      this.setMyNumParams(SET_POSITION_PARAMS);
   }

   public SetpositionNode(CommandControllerInterface inController, CommandNode inParent){
      super(inController, inParent);
      this.setMyNumParams(SET_POSITION_PARAMS);
   }

   public void execute(){
      this.parseParameters();
      this.myController.goTo(this.myX, this.myY);
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
