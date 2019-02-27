package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class LeftBracketNode extends CommandNode {

   public LeftBracketNode(CommandHandlerInterface inHandler){
      super(inHandler);
   }

   public LeftBracketNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler, inParent);
   }

   public void execute(){
      this.parseParameters();
   }

   protected void parseParameters(){}
}
