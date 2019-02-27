package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class PendownNode extends TurtleCommandNode{
   private static int PEN_PARAMS = 0;

   public PendownNode(CommandHandlerInterface inHandler){
      super(inHandler);
      this.setMyNumParams(PEN_PARAMS);
   }

   public PendownNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler, inParent);
      this.setMyNumParams(PEN_PARAMS);
   }

   public void execute(){
      this.parseParameters();
      this.myHandler.penDown();
   }

   protected void parseParameters(){
   }
}
