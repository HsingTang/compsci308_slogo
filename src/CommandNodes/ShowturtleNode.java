package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * @author Mary Gooneratne
 * CommandNode that shows turtle
 */
public class ShowturtleNode extends TurtleCommandNode{
   private static final int TOGGLE_TURTLE_PARAMS = 0;

   /**
    * Instantiates ShowturtleNode
    * @param inHandler handles this command node
    */
   public ShowturtleNode(CommandHandlerInterface inHandler){
      super(inHandler);
      this.setMyNumParams(TOGGLE_TURTLE_PARAMS);
   }

   /**
    * Instantiates ShowturtleNode
    * @param inHandler handles this node
    * @param inParent parent of this node
    */

   public ShowturtleNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler, inParent);
      this.setMyNumParams(TOGGLE_TURTLE_PARAMS);
   }

   /**
    * Parses command parameters and calls appropriate execution method on handler
    */
   public void execute(){
      this.parseParameters();
      this.setMyReturnValue(this.myHandler.showTurtle());
   }

   protected void parseParameters(){
   }
}
