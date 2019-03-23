package CommandNodes;

import Errors.InvalidCommandException;
import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class ForwardNode extends TurtleCommandNode {
   private static final int FORWARD_PARAMS = 1;

   private double myPixels;

   public ForwardNode(CommandHandlerInterface inHandler){
      super(inHandler);
      this.setMyNumParams(FORWARD_PARAMS);
   }

   public ForwardNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler, inParent);
      this.setMyNumParams(FORWARD_PARAMS);
   }

   public void execute() throws InvalidCommandException{
      try{
         this.parseParameters();
      }catch (InvalidCommandException exp){
         throw exp;
      }
      this.setMyReturnValue(this.myHandler.moveForward(this.myPixels));
   }

   protected void parseParameters() throws InvalidCommandException{
      try {
         this.myPixels = this.getPixels();
      }
      catch(Exception e){
         throw new InvalidCommandException();
      }
   }

}
