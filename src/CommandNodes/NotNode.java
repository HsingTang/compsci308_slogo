package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class NotNode extends TurtleCommandNode {
   private static final int OR_PARAMS = 1;


   public NotNode(CommandHandlerInterface inHandler) {
      super(inHandler);
      this.setMyNumParams(OR_PARAMS);
   }

   public NotNode(CommandHandlerInterface inHandler, CommandNode inParent) {
      super(inHandler, inParent);
      this.setMyNumParams(OR_PARAMS);
   }

   public void execute() {
      this.parseParameters();
      this.setMyReturnValue(this.returnVal());
   }

   private double returnVal(){
      if(this.getMyChildren().get(0).getMyReturnValue() == 0)
         return 1.0;
      return 0.0;
   }
   protected void parseParameters() {
   }
}