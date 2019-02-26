package CommandNodes;

import Controller.ControllerInterfaces.CommandControllerInterface;

public class ClearscreenNode extends TurtleCommandNode{
   private static int SCREEN_PARAMS = 0;

   private double distanceMoved;

   public ClearscreenNode(CommandControllerInterface inController){
      super(inController);
      this.setMyNumParams(SCREEN_PARAMS);
   }

   public ClearscreenNode(CommandControllerInterface inController, CommandNode inParent){
      super(inController, inParent);
      this.setMyNumParams(SCREEN_PARAMS);
   }

   public void execute(){
      this.parseParameters();
      this.myController.clearScreen();
   }

   protected void parseParameters(){

   }

}
