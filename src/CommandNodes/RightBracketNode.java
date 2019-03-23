package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * @author Mary Gooneratne
 * CommandNode that indicates the end of a block of commands
 */
public class RightBracketNode extends CommandNode {
   private static final Double INIT = 0.0;

   /**
    * Instantiates RightBracketNode
    * @param inHandler handles this command ndoe
    */
   public RightBracketNode(CommandHandlerInterface inHandler){
      super(inHandler);
   }

   /**
    * Instantiates RightBracket Node
    * @param inHandler handles this command node
    * @param inParent parent of this command node
    */
   public RightBracketNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler, inParent);
   }

   /**
    * Parses command parameters and calls appropriate execution method on handler
    */
   public void execute(){
      this.setMyReturnValue(INIT);
   }

   protected void parseParameters(){}
}
