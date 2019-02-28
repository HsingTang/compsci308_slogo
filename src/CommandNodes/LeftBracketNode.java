package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class LeftBracketNode extends CommandNode {
   private static double INIT = 0.0;

   public LeftBracketNode(CommandHandlerInterface inHandler){
      super(inHandler);
   }

   public LeftBracketNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler, inParent);
   }

   public void execute(){
      this.parseParameters();
      this.setMyReturnValue(INIT);
   }

   protected void parseParameters(){}
}
