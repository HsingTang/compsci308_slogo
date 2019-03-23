package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * @author Mary Gooneratne
 * CommandNode that moves turtle a certain number of pixels to the right
 */
public class RightNode extends TurtleCommandNode {
   private static final int RIGHT_PARAMS = 1;

   private double myDegrees;

   /**
    * Instantiates RightNode object
    * @param inHandler handles this command node
    */
   public RightNode(CommandHandlerInterface inHandler){
      super(inHandler);
      this.setMyNumParams(RIGHT_PARAMS);
   }

   /**
    * Instantiates RightNode object
    * @param inHandler handles this command node
    * @param inParent parent of this command node
    */
   public RightNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler, inParent);
      this.setMyNumParams(RIGHT_PARAMS);
   }

   /**
    * Parses command parameters and calls appropriate execution method on handler
    */
   public void execute(){
      this.parseParameters();
      this.setMyReturnValue(this.myHandler.turnRight(this.myDegrees));
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
