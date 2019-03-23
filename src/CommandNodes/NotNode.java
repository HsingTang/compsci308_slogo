package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * CommandNode that checks if child is equal to zero
 */
public class NotNode extends TurtleCommandNode {
   private static final int OR_PARAMS = 1;

   /**
    * Instantiates NotNode object
    * @param inHandler handler to handle commandNodes
    */
   public NotNode(CommandHandlerInterface inHandler) {
      super(inHandler);
      this.setMyNumParams(OR_PARAMS);
   }

   /**
    * Instantiates NotNode object
    * @param inHandler handler to handle commandNodes
    * @param inParent parent of this node
    */
   public NotNode(CommandHandlerInterface inHandler, CommandNode inParent) {
      super(inHandler, inParent);
      this.setMyNumParams(OR_PARAMS);
   }

   /**
    * Parses command parameters and calls appropriate execution method on handler
    */
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