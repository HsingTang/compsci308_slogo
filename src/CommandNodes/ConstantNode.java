package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class ConstantNode extends CommandNode {
   private static int CONSTANT_PARAMS = 0;
   private static int INIT_VAL = 0;

   private double myValue;

   public ConstantNode(CommandHandlerInterface inHandler){
      super(inHandler);
      this.setMyNumParams(CONSTANT_PARAMS);
      this.myValue = INIT_VAL;
   }

   public ConstantNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler);
      this.setMyNumParams(CONSTANT_PARAMS);
      this.setParent(inParent);
      this.myValue = INIT_VAL;
   }

   public ConstantNode(CommandHandlerInterface inHandler, CommandNode inParent, double inValue){
      super(inHandler);
      this.setMyNumParams(CONSTANT_PARAMS);
      this.myValue = inValue;
   }

   public double getMyValue(){
      return this.myValue;
   }

   protected void setMyValue(Double value){
      this.myValue = value;
   }

   public void execute(){
      this.parseParameters();
   }

   protected void parseParameters(){
      this.setMyReturnValue(this.myValue);
   }
}
