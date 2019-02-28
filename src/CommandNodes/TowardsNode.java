package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class TowardsNode extends TurtleCommandNode{
   private static int TOWARDS_PARAMS = 2;

   private double myX;
   private double myY;

   public TowardsNode(CommandHandlerInterface inHandler){
      super(inHandler);
      this.setMyNumParams(TOWARDS_PARAMS);
   }

   public TowardsNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler, inParent);
      this.setMyNumParams(TOWARDS_PARAMS);
   }

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
