package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * @author Mary Gooneratne
 * CommandNode that puts turtle pen up so it continues to trace path of turtle
 */
public class PenupNode extends TurtleCommandNode{
   private static final int PEN_PARAMS = 0;

   /**
    * Instantiates PenupNode object
    * @param inHandler handles this command node
    */
   public PenupNode(CommandHandlerInterface inHandler){
      super(inHandler);
      this.setMyNumParams(PEN_PARAMS);
   }

   /**
    * Instantiates PenupNode object
    * @param inHandler handles this command node
    * @param inParent parent of this command node
    */
   public PenupNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler, inParent);
      this.setMyNumParams(PEN_PARAMS);
   }

   /**
    * Parses command parameters and calls appropriate execution method on handler
    */
   public void execute(){
      this.parseParameters();
      this.setMyReturnValue(this.myHandler.penUp());
   }

   protected void parseParameters(){
   }
}
