package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * CommandNode that compares children and determines if value of left child is less than that of right child
 */
public class LessthanNode extends TurtleCommandNode {
   private static final int LESS_PARAMS = 2;

   /**
    * Instantiates a LessthanNode
    * @param inHandler command handler to execute commands
    */
   public LessthanNode(CommandHandlerInterface inHandler) {
      super(inHandler);
      this.setMyNumParams(LESS_PARAMS);
   }

   /**
    * Instantiates LessthanNode object
    * @param inHandler handler that handles command nodes
    * @param inParent parent of this node
    */
   public LessthanNode(CommandHandlerInterface inHandler, CommandNode inParent) {
      super(inHandler, inParent);
      this.setMyNumParams(LESS_PARAMS);
   }

   /**
    * Parses command parameters and calls appropriate execution method on handler
    */
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