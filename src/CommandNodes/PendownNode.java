package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * @author Mary Gooneratne
 * CommandNode that puts turtle pen down (stops tracing path)
 */
public class PendownNode extends TurtleCommandNode{
   private static final int PEN_PARAMS = 0;

   /**
    * Instantiates PendownNode object
    * @param inHandler
    */
   public PendownNode(CommandHandlerInterface inHandler){
      super(inHandler);
      this.setMyNumParams(PEN_PARAMS);
   }

   /**
    * Instantiates PendownNode object
    * @param inHandler handles this CommandNode and its root
    * @param inParent parent of this command node
    */
   public PendownNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler, inParent);
      this.setMyNumParams(PEN_PARAMS);
   }

   /**
    * Parses command parameters and calls appropriate execution method on handler
    */
   public void execute(){
      this.parseParameters();
      this.setMyReturnValue(this.myHandler.penDown());
   }

   protected void parseParameters(){
   }
}
