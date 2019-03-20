package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

/** @author Mary Gooneratne
 * CommandNode object that moves turtle backwards a number of pixels
 */
public class BackwardNode extends TurtleCommandNode {
   private static final int BACKWARD_PARAMS = 1;

   private double myPixels;

   /**
    * Instantiates new BackwardNode
    * @param inHandler handler handling command execution
    */
   public BackwardNode(CommandHandlerInterface inHandler){
      super(inHandler);
      this.setMyNumParams(BACKWARD_PARAMS);
   }

   /**
    * Instatiates new BackwardNode
    * @param inHandler handler handling command execution
    * @param inParent parent node of BackwardNode
    */

   public BackwardNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler, inParent);
      this.setMyNumParams(BACKWARD_PARAMS);
   }

   /**
    * Parses command parameters and calls appropriate execution method on handler
    */
   public void execute(){
      this.parseParameters();
      this.setMyReturnValue(this.myHandler.moveBackwards(this.myPixels));
   }

   /**
    * Parses parameters (pixels)
    */
   protected void parseParameters(){
      try {
         this.myPixels = this.getPixels();
      }
      catch(Exception e){
         /**
          * Error regarding parameter parsing
         */
      }
   }
}
