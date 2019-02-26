package CommandNodes;

import Controller.ControllerInterfaces.CommandControllerInterface;

public class HomeNode extends TurtleCommandNode{
   private static int SCREEN_PARAMS = 0;

   public HomeNode(CommandControllerInterface inController){
      super(inController);
      this.setMyNumParams(SCREEN_PARAMS);
   }

   public HomeNode(CommandControllerInterface inController, CommandNode inParent){
      super(inController, inParent);
      this.setMyNumParams(SCREEN_PARAMS);
   }

   public void execute(){
      this.parseParameters();
      this.myController.goHome();
   }

   protected void parseParameters(){

   }
}
