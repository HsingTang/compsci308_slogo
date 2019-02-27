package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class SetpositionNode extends TurtleCommandNode{
   private static int SET_POSITION_PARAMS = 2;

   private double myX;
   private double myY;

   public SetpositionNode(CommandHandlerInterface inHandler){
      super(inHandler);
      this.setMyNumParams(SET_POSITION_PARAMS);
   }

   public SetpositionNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler, inParent);
      this.setMyNumParams(SET_POSITION_PARAMS);
   }

   public void execute(){
      this.parseParameters();
      this.myHandler.goTo(this.myX, this.myY);
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
