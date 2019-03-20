package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * @author Mary Gooneratne
 * ComamndNode that moves turtle to set x y position
 */
public class TowardsNode extends TurtleCommandNode{
   private static final int TOWARDS_PARAMS = 2;

   private double myX;
   private double myY;

   /**
    * Instantiates TowardsNode
    * @param inHandler handles this command node
    */
   public TowardsNode(CommandHandlerInterface inHandler){
      super(inHandler);
      this.setMyNumParams(TOWARDS_PARAMS);
   }

   /**
    * Instantiates TowardsNode
    * @param inHandler handles this command node
    * @param inParent parent of this node
    */
   public TowardsNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler, inParent);
      this.setMyNumParams(TOWARDS_PARAMS);
   }

   /**
    * Parses command parameters and calls appropriate execution method on handler
    */
   public void execute(){
      this.parseParameters();
      this.setMyReturnValue(this.myHandler.turnTowards(this.myX, this.myY));
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
