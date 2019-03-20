package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * @author Mary Gooneratne
 * CommandNode that returns turtle back to home
 */
public class HomeNode extends TurtleCommandNode{
   private static final int SCREEN_PARAMS = 0;

   /**
    * Instantiates HomeNode object
    * @param inHandler CommandHandler that handles CommandNodes
    */
   public HomeNode(CommandHandlerInterface inHandler){
      super(inHandler);
      this.setMyNumParams(SCREEN_PARAMS);
   }

   /**
    * Instantiates HomeNode object
    * @param inHandler CommandHandler that handles this node's tree's commands
    * @param inParent parent of this node
    */
   public HomeNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler, inParent);
      this.setMyNumParams(SCREEN_PARAMS);
   }

   /**
    * Parses command parameters and calls appropriate execution method on handler
    */
   public void execute(){
      this.parseParameters();
      this.setMyReturnValue(this.myHandler.goHome());
   }

   protected void parseParameters(){

   }
}
