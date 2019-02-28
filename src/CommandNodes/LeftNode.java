package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class LeftNode extends TurtleCommandNode{
   private static final int LEFT_PARAMS = 1;

   private double myDegrees;

   public LeftNode(CommandHandlerInterface inHandler){
      super(inHandler);
      this.setMyNumParams(LEFT_PARAMS);
   }

   public LeftNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler, inParent);
      this.setMyNumParams(LEFT_PARAMS);
   }

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
