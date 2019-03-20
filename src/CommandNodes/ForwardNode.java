package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * @author Mary Gooneratne
 * CommandNode that moves turtle forward certain number of pixels
 */
public class ForwardNode extends TurtleCommandNode {
   private static final int FORWARD_PARAMS = 1;

   private double myPixels;

   /**
    * Instantiates ForwardNode object
    * @param inHandler handler to execute commands
    */
   public ForwardNode(CommandHandlerInterface inHandler){
      super(inHandler);
      this.setMyNumParams(FORWARD_PARAMS);
   }

   /**
    * Instantiates ForwardNode object
    * @param inHandler handler to execute commands
    * @param inParent parent node of ForwardNode
    */
   public ForwardNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler, inParent);
      this.setMyNumParams(FORWARD_PARAMS);
   }
   /**
    * Parses command parameters and calls appropriate execution method on handler
    */
   public void execute(){
      this.parseParameters();
      this.setMyReturnValue(this.myHandler.moveForward(this.myPixels));
   }

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
