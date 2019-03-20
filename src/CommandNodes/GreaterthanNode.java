package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * @author Mary Gooneratne
 * CommandNode that compares children to see if left child node value is greater than that of right child node value
 */
public class GreaterthanNode extends TurtleCommandNode {
   private static final int GREATER_PARAMS = 2;

   /**
    * Instantiates GreaterthanNode object
    * @param inHandler handler that executes nodes
    */
   public GreaterthanNode(CommandHandlerInterface inHandler) {
      super(inHandler);
      this.setMyNumParams(GREATER_PARAMS);
   }

   /**
    * Instantiates GreaterthanNode object
    * @param inHandler handler that executes commands
    * @param inParent parent ndoe of GreaterthanNode
    */
   public GreaterthanNode(CommandHandlerInterface inHandler, CommandNode inParent) {
      super(inHandler, inParent);
      this.setMyNumParams(GREATER_PARAMS);
   }

   /**
    * Parses command parameters and calls appropriate execution method on handler
    */
   public void execute() {
      this.parseParameters();
      this.setMyReturnValue(this.returnVal());
   }

   /**
    * Gets return value of node
    * @return 1 if greater than and 0 else
    */
   private double returnVal(){
      if(this.getMyChildren().get(0).getMyReturnValue() > this.getMyChildren().get(1).getMyReturnValue())
         return 1.0;
      return 0.0;
   }
   protected void parseParameters() {
   }
}