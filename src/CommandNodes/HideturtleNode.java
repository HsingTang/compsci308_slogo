package CommandNodes;

import Controller.ControllerInterfaces.CommandControllerInterface;

public class HideturtleNode extends TurtleCommandNode{
   private static int TOGGLE_TURTLE_PARAMS = 0;

   public HideturtleNode(CommandControllerInterface inController){
      super(inController);
      this.setMyNumParams(TOGGLE_TURTLE_PARAMS);
   }

   public HideturtleNode(CommandControllerInterface inController, CommandNode inParent){
      super(inController, inParent);
      this.setMyNumParams(TOGGLE_TURTLE_PARAMS);
   }

   public void execute(){
      this.parseParameters();
      this.myController.showTurtle();
   }

   protected void parseParameters(){

   }
}
