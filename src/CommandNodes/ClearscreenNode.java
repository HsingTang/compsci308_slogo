package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * @author Mary Gooneratne
 * CommandNode that clears turtle screen of pen
 */
public class ClearscreenNode extends TurtleCommandNode{
   private static final int SCREEN_PARAMS = 0;

   private double distanceMoved;

   /**
    * Instantiates ClearscreenNode
    * @param inHandler handler to execute commands
    */
   public ClearscreenNode(CommandHandlerInterface inHandler){
      super(inHandler);
      this.setMyNumParams(SCREEN_PARAMS);
   }

   /**
    * Instantiates ClearscreenNode
    * @param inHandler handler to execute commands
    * @param inParent parent of ClearscreenNode
    */
   public ClearscreenNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler, inParent);
      this.setMyNumParams(SCREEN_PARAMS);
   }

   /**
    * Parses command parameters and calls appropriate execution method on handler
    */
   public void execute(){
      this.parseParameters();
      this.setMyReturnValue(this.myHandler.clearScreen());
   }

   protected void parseParameters(){

   }

}
