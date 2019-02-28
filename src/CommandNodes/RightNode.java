package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class RightNode extends TurtleCommandNode {
   private static final int RIGHT_PARAMS = 1;

   private double myDegrees;

   public RightNode(CommandHandlerInterface inHandler){
      super(inHandler);
      this.setMyNumParams(RIGHT_PARAMS);
   }

   public RightNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler, inParent);
      this.setMyNumParams(RIGHT_PARAMS);
   }

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
