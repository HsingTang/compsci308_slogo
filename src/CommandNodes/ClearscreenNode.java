package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class ClearscreenNode extends TurtleCommandNode{
   private static final int SCREEN_PARAMS = 0;

   private double distanceMoved;

   public ClearscreenNode(CommandHandlerInterface inHandler){
      super(inHandler);
      this.setMyNumParams(SCREEN_PARAMS);
   }

   public ClearscreenNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler, inParent);
      this.setMyNumParams(SCREEN_PARAMS);
   }

   public void execute(){
      this.parseParameters();
      this.setMyReturnValue(this.myHandler.clearScreen());
   }

   protected void parseParameters(){

   }

}
