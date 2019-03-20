package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * @author Mary Gooneratne
 * CommandNode that sets position of turtle
 */
public class SetpositionNode extends TurtleCommandNode{
   private static final int SET_POSITION_PARAMS = 2;

   private double myX;
   private double myY;

   /**
    * Instantiates SetpositionNode
    * @param inHandler handles this command node
    */
   public SetpositionNode(CommandHandlerInterface inHandler){
      super(inHandler);
      this.setMyNumParams(SET_POSITION_PARAMS);
   }

   /**
    * Instantiates SetpositionNode
    * @param inHandler handles this command node
    * @param inParent parent of this command node
    */
   public SetpositionNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler, inParent);
      this.setMyNumParams(SET_POSITION_PARAMS);
   }

   /**
    * Parses command parameters and calls appropriate execution method on handler
    */

   public void execute(){
      this.parseParameters();
      this.setMyReturnValue(this.myHandler.goTo(this.myX, this.myY));
   }

   protected void parseParameters(){
      try {
         this.myX = this.getX();
         this.myY = this.getY();
      }
      catch(Exception e){
         /**
          * Error regarding parameter parsing
          */
      }
   }
}
