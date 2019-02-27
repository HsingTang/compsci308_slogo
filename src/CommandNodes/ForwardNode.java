package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class ForwardNode extends TurtleCommandNode {
   private static int FORWARD_PARAMS = 1;

   private double myPixels;

   public ForwardNode(CommandHandlerInterface inHandler){
      super(inHandler);
      this.setMyNumParams(FORWARD_PARAMS);
   }

   public ForwardNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler, inParent);
      this.setMyNumParams(FORWARD_PARAMS);
   }

   public void execute(){
      this.parseParameters();
      this.myHandler.moveForward(this.myPixels);
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
