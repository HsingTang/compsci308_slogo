package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class RightBracketNode extends CommandNode {

   public RightBracketNode(CommandHandlerInterface inHandler){
      super(inHandler);
   }

   public RightBracketNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler, inParent);
   }

   public void execute(){ }

   protected void parseParameters(){}
}
