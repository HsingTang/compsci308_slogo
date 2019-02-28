package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class PenupNode extends TurtleCommandNode{
   private static int PEN_PARAMS = 0;

   public PenupNode(CommandHandlerInterface inHandler){
      super(inHandler);
      this.setMyNumParams(PEN_PARAMS);
   }

   public PenupNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler, inParent);
      this.setMyNumParams(PEN_PARAMS);
   }

   public void execute(){
      this.parseParameters();
      this.setMyReturnValue(this.myHandler.penUp());
   }

   protected void parseParameters(){
   }
}
