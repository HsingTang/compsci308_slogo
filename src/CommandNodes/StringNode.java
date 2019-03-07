package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class StringNode extends CommandNode {
   private static final double INIT = 0.0;
   private String myStringValue = "";

   public StringNode(CommandHandlerInterface inHandler){
      super(inHandler);
   }

   public StringNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler, inParent);
   }
   public StringNode(CommandHandlerInterface inHandler, CommandNode inParent, String s){
      super(inHandler, inParent);
      this.myStringValue = s;
   }


   public void execute(){
      this.parseParameters();
      this.setMyReturnValue(INIT);
   }

   public String getMyStringValue(){
      return this.myStringValue;
   }

   protected void parseParameters(){}
}
