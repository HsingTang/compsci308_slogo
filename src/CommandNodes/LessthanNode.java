package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class LessthanNode extends TurtleCommandNode {
   private static final int LESS_PARAMS = 2;


   public LessthanNode(CommandHandlerInterface inHandler) {
      super(inHandler);
      this.setMyNumParams(LESS_PARAMS);
   }

   public LessthanNode(CommandHandlerInterface inHandler, CommandNode inParent) {
      super(inHandler, inParent);
      this.setMyNumParams(LESS_PARAMS);
   }

   public void execute() {
      this.parseParameters();
      this.setMyReturnValue(this.returnVal());
   }

   private double returnVal(){
      if(this.getMyChildren().get(0).getMyReturnValue() < this.getMyChildren().get(1).getMyReturnValue())
         return 1.0;
      return 0.0;
   }
   protected void parseParameters() {
   }
}