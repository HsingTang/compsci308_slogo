package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * @author Mary Gooneratne
 * CommandNode that checks if either child is not equal to zero
 */
public class OrNode extends TurtleCommandNode {
   private static final int BOOLEAN_PARAMS = 2;

   /**
    * Instantiates OrNode object
    * @param inHandler handles this command node
    */
   public OrNode(CommandHandlerInterface inHandler) {
      super(inHandler);
      this.setMyNumParams(BOOLEAN_PARAMS);
   }

   /**
    * Instantiates OrNode
    * @param inHandler handles this CommandNode
    * @param inParent parent of this commandNode
    */

   public OrNode(CommandHandlerInterface inHandler, CommandNode inParent) {
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
      if(this.getMyChildren().get(0).getMyReturnValue() != 0 || this.getMyChildren().get(1).getMyReturnValue() != 0)
         return 1.0;
      return 0.0;
   }
   protected void parseParameters() {
   }
}