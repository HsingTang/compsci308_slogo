package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * @author Mary Gooneratne
 * CommandNode that compares left and right children to determine if equal
 */
public class EqualNode extends TurtleCommandNode {
   private static final int EQUAL_PARAMS = 2;

   /**
    * Instantiates EqualNode object
    * @param inHandler handler to execute nodes
    */
   public EqualNode(CommandHandlerInterface inHandler) {
      super(inHandler);
      this.setMyNumParams(EQUAL_PARAMS);
   }

   /**
    * Instantiates EqualNode object
    * @param inHandler handler to execute nodes
    * @param inParent parent node
    */
   public EqualNode(CommandHandlerInterface inHandler, CommandNode inParent) {
      super(inHandler, inParent);
      this.setMyNumParams(EQUAL_PARAMS);
   }

   /**
    * Parses command parameters and calls appropriate execution method on handler
    */
   public void execute() {
      this.parseParameters();
      this.setMyReturnValue(this.returnVal());
   }

   private double returnVal(){
      if(this.getMyChildren().get(0).getMyReturnValue() == this.getMyChildren().get(1).getMyReturnValue())
         return 1.0;
      return 0.0;
   }
   protected void parseParameters() {
   }
}