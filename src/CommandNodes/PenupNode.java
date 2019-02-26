package CommandNodes;

import Controller.ControllerInterfaces.CommandControllerInterface;

public class PenupNode extends TurtleCommandNode{
   private static int PEN_PARAMS = 0;

   public PenupNode(CommandControllerInterface inController){
      super(inController);
      this.setMyNumParams(PEN_PARAMS);
   }

   public PenupNode(CommandControllerInterface inController, CommandNode inParent){
      super(inController, inParent);
      this.setMyNumParams(PEN_PARAMS);
   }

   public void execute(){
      this.parseParameters();
      this.myController.penUp();
   }

   protected void parseParameters(){
   }
}
