package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class BackwardNode extends TurtleCommandNode {
   private static int BACKWARD_PARAMS = 1;

   private double myPixels;

   public BackwardNode(CommandHandlerInterface inHandler){
      super(inHandler);
      this.setMyNumParams(BACKWARD_PARAMS);
   }

   public BackwardNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler, inParent);
      this.setMyNumParams(BACKWARD_PARAMS);
   }

   public void execute(){
      this.parseParameters();
      this.myHandler.moveBackwards(this.myPixels);
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
