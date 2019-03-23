package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * @author Mary Gooneratne
 * CommandNode that compares children to see if they are equal
 */
public class NotequalNode extends TurtleCommandNode {
   private static final int NOTEQUAL_PARAMS = 2;

   /**
    * Instantiates NotequalNode
    * @param inHandler handler to handle commands
    */
   public NotequalNode(CommandHandlerInterface inHandler) {
      super(inHandler);
      this.setMyNumParams(NOTEQUAL_PARAMS);
   }

   /**
    * Instantiates NotequalNode
    * @param inHandler handler to handle commands
    * @param inParent parent of this node
    */
   public NotequalNode(CommandHandlerInterface inHandler, CommandNode inParent) {
      super(inHandler, inParent);
      this.setMyNumParams(NOTEQUAL_PARAMS);
   }

   /**
    * Parses command parameters and calls appropriate execution method on handler
    */
   public void execute() {
      this.parseParameters();
      this.setMyReturnValue(this.returnVal());
   }

   private double returnVal(){
      if(this.getMyChildren().get(0).getMyReturnValue() != this.getMyChildren().get(1).getMyReturnValue())
         return 1.0;
      return 0.0;
   }
   protected void parseParameters() {
   }
}