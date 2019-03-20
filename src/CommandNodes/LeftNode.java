package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * CommandNode that turns turtle left a certain number of degrees
 */
public class LeftNode extends TurtleCommandNode{
   private static final int LEFT_PARAMS = 1;

   private double myDegrees;

   /**
    * Instantiates LeftNode object
    * @param inHandler handler to handle CommandNodes
    */
   public LeftNode(CommandHandlerInterface inHandler){
      super(inHandler);
      this.setMyNumParams(LEFT_PARAMS);
   }

   /**
    * Instantiates LeftNode object
    * @param inHandler handler to handle CommandNodes
    * @param inParent parent of this CommandNode
    */
   public LeftNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler, inParent);
      this.setMyNumParams(LEFT_PARAMS);
   }
   /**
    * Parses command parameters and calls appropriate execution method on handler
    */
   public void execute(){
      this.parseParameters();
      this.setMyReturnValue(this.myHandler.turnLeft(this.myDegrees));
   }

   protected void parseParameters(){
      try {
         this.myDegrees = this.getDegrees();
      }
      catch(Exception e){
         /**
          * Error regarding parameter parsing
          */
      }
   }
}
