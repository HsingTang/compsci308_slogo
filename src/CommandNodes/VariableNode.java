package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class VariableNode extends ConstantNode{
   private String myStringValue = "";

   public VariableNode(CommandHandlerInterface inHandler){
      super(inHandler);
   }

   public VariableNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler, inParent);
   }
   public VariableNode(CommandHandlerInterface inHandler, CommandNode inParent, String s){
      super(inHandler, inParent);
      this.myStringValue = s;
   }


   public void execute(){
      this.parseParameters();
      this.setMyReturnValue(this.getMyValue());
   }

   public String getMyStringValue(){
      return this.myStringValue;
   }

   protected void parseParameters(){
      if (this.myHandler.isVariable(this.myStringValue)) {
         this.setMyValue(this.myHandler.getVariable(this.myStringValue));
      } else {
         this.setMyValue(0.0);
      }
   }
}
