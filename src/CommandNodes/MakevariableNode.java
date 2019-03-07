package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class MakevariableNode extends CommandNode{

   private static int PARAMS = 2;
   private String varName = "";
   public MakevariableNode(CommandHandlerInterface inHandler) {
      super(inHandler);
      this.setMyNumParams(PARAMS);
   }

   public MakevariableNode(CommandHandlerInterface inHandler, CommandNode inParent) {
      super(inHandler, inParent);
      this.setMyNumParams(PARAMS);
   }

   public void execute() {
      this.parseParameters();
      this.setMyReturnValue(this.getMyChildren().get(1).getMyReturnValue());
      this.myHandler.makeVariable(varName, this.getMyChildren().get(1).getMyReturnValue());
   }
   protected void parseParameters() {
     this.varName = ((StringNode)(this.getMyChildren().get(0))).getMyStringValue();
   }
}
