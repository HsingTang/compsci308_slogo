package CommandNodes;

import Controller.ControllerInterfaces.CommandControllerInterface;

public class PendownNode extends TurtleCommandNode{
   private static int PEN_PARAMS = 0;

   public PendownNode(CommandControllerInterface inController){
      super(inController);
      this.setMyNumParams(PEN_PARAMS);
   }

   public PendownNode(CommandControllerInterface inController, CommandNode inParent){
      super(inController, inParent);
      this.setMyNumParams(PEN_PARAMS);
   }

   public void execute(){
      this.parseParameters();
      this.myController.penDown();
   }

   protected void parseParameters(){
   }
}
