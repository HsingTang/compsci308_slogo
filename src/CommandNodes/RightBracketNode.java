package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class RightBracketNode extends CommandNode {
   private static Double INIT = 0.0;

   public RightBracketNode(CommandHandlerInterface inHandler){
      super(inHandler);
   }

   public RightBracketNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler, inParent);
   }

   public void execute(){
      this.setMyReturnValue(INIT);
   }

   protected void parseParameters(){}
}
