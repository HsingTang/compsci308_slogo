package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * @author Mary Gooneratne
 * CommandNode that checks if both child values are not equal to zero
 */
public class AndNode extends TurtleCommandNode {
   private static final int BOOLEAN_PARAMS = 2;

   /**
    * Instantiates AndNode object
    * @param inHandler handler that handles command nodes
    */
   public AndNode(CommandHandlerInterface inHandler) {
      super(inHandler);
      this.setMyNumParams(BOOLEAN_PARAMS);
   }

   /**
    * Instantiates AndNode object
    * @param inHandler handler that handles command nodes
    * @param inParent parent of this command node
    */
   public AndNode(CommandHandlerInterface inHandler, CommandNode inParent) {
      super(inHandler, inParent);
      this.setMyNumParams(BOOLEAN_PARAMS);
   }

   /**
    * Parses command parameters and calls appropriate execution method on handler
    */
   public void execute() {
      this.parseParameters();
      this.setMyReturnValue(this.returnVal());
   }

   private double returnVal(){
      if(this.getMyChildren().get(0).getMyReturnValue() != 0 && this.getMyChildren().get(1).getMyReturnValue() != 0)
         return 1.0;
      return 0.0;
   }
   protected void parseParameters() {
   }
}