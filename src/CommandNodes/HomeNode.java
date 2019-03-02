package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class HomeNode extends TurtleCommandNode{
   private static final int SCREEN_PARAMS = 0;

   public HomeNode(CommandHandlerInterface inHandler){
      super(inHandler);
      this.setMyNumParams(SCREEN_PARAMS);
   }

   public HomeNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler, inParent);
      this.setMyNumParams(SCREEN_PARAMS);
   }

   public void execute(){
      this.parseParameters();
      this.setMyReturnValue(this.myHandler.goHome());
   }

   protected void parseParameters(){

   }
}
