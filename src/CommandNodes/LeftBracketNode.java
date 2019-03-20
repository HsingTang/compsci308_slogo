package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * @author Mary Gooneratne
 * CommandNode signaling the start of a block of commands
 */
public class LeftBracketNode extends CommandNode {
   private static final double INIT = 0.0;

   /**
    * Instantiates left bracket node object
    * @param inHandler handler to handle command nodes
    */
   public LeftBracketNode(CommandHandlerInterface inHandler){
      super(inHandler);
   }

   /**
    * Instantiates left bracket command node
    * @param inHandler handler to handle command nodes
    * @param inParent parent of CommandNode
    */
   public LeftBracketNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler, inParent);
   }

   /**
    * Parses command parameters and calls appropriate execution method on handler
    */
   public void execute(){
      this.parseParameters();
      this.setMyReturnValue(INIT);
   }

   protected void parseParameters(){}
}
