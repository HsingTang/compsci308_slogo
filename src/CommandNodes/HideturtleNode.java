package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * CommandNode that hides turtle
 */
public class HideturtleNode extends TurtleCommandNode{
   private static final int TOGGLE_TURTLE_PARAMS = 0;

   /**
    * Instantiates HideturtleNode
    * @param inHandler
    */
   public HideturtleNode(CommandHandlerInterface inHandler){
      super(inHandler);
      this.setMyNumParams(TOGGLE_TURTLE_PARAMS);
   }

   /**
    * Instantiate HideturtleNode
    * @param inHandler handler to execute commands
    * @param inParent parent of node
    */
   public HideturtleNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler, inParent);
      this.setMyNumParams(TOGGLE_TURTLE_PARAMS);
   }
   /**
    * Parses command parameters and calls appropriate execution method on handler
    */
   public void execute(){
      this.parseParameters();
      this.setMyReturnValue(this.myHandler.hideTurtle());
   }

   protected void parseParameters(){

   }
}
