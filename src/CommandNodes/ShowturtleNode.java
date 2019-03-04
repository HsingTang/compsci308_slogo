package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class ShowturtleNode extends TurtleCommandNode{
   private static final int TOGGLE_TURTLE_PARAMS = 0;

   public ShowturtleNode(CommandHandlerInterface inHandler){
      super(inHandler);
      this.setMyNumParams(TOGGLE_TURTLE_PARAMS);
   }

   public ShowturtleNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler, inParent);
      this.setMyNumParams(TOGGLE_TURTLE_PARAMS);
   }

   public void execute(){
      this.parseParameters();
      this.setMyReturnValue(this.myHandler.showTurtle());
   }

   protected void parseParameters(){
   }
}
