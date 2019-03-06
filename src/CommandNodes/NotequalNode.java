package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class NotequalNode extends TurtleCommandNode {
   private static final int NOTEQUAL_PARAMS = 2;


   public NotequalNode(CommandHandlerInterface inHandler) {
      super(inHandler);
      this.setMyNumParams(NOTEQUAL_PARAMS);
   }

   public NotequalNode(CommandHandlerInterface inHandler, CommandNode inParent) {
      super(inHandler, inParent);
      this.setMyNumParams(NOTEQUAL_PARAMS);
   }

   public void execute() {
      this.parseParameters();
      this.setMyReturnValue(this.returnVal());
   }

   private double returnVal(){
      if(this.getMyChildren().get(0).getMyReturnValue() != this.getMyChildren().get(1).getMyReturnValue())
         return 1.0;
      return 0.0;
   }
   protected void parseParameters() {
   }
}