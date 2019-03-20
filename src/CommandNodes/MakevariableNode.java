package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * @author Mary Gooneratne
 * CommandNode to create user-defined variables
 */
public class MakevariableNode extends CommandNode{

   private static int PARAMS = 2;
   private String varName = "";

   /**
    * Instantiates MakevariableNode
    * @param inHandler handler that handles commandNodes
    */
   public MakevariableNode(CommandHandlerInterface inHandler) {
      super(inHandler);
      this.setMyNumParams(PARAMS);
   }

   /**
    * Instantiates MakevariableNode
    * @param inHandler handler that handles commandNodes
    * @param inParent parent of this commandNode
    */
   public MakevariableNode(CommandHandlerInterface inHandler, CommandNode inParent) {
      super(inHandler, inParent);
      this.setMyNumParams(PARAMS);
   }
   /**
    * Parses command parameters and calls appropriate execution method on handler
    */
   public void execute() {
      this.parseParameters();
      this.setMyReturnValue(this.getMyChildren().get(1).getMyReturnValue());
      this.myHandler.makeVariable(varName, this.getMyChildren().get(1).getMyReturnValue());
   }
   protected void parseParameters() {
     this.varName = ((StringNode)(this.getMyChildren().get(0))).getMyStringValue();
   }
}
