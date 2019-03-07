package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class ConstantNode extends CommandNode {
   private static final int CONSTANT_PARAMS = 0;
   private static final Double INIT_VAL = 0.0;

   protected double myValue;

   public ConstantNode(CommandHandlerInterface inHandler){
      super(inHandler);
      this.setMyNumParams(CONSTANT_PARAMS);
      this.myValue = INIT_VAL;
      this.setMyValue(INIT_VAL);
   }

   public ConstantNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler);
      this.setMyNumParams(CONSTANT_PARAMS);
      this.setParent(inParent);
      this.myValue = INIT_VAL;
      this.setMyValue(INIT_VAL);
   }

   public ConstantNode(CommandHandlerInterface inHandler, CommandNode inParent, double inValue){
      super(inHandler);
      this.setMyNumParams(CONSTANT_PARAMS);
      this.setMyValue(inValue);
   }

   public double getMyValue(){
      return this.myValue;
   }

   protected void setMyValue(Double value){
      this.myValue = value;

      this.setMyReturnValue(this.myValue);
   }

   public void execute(){
      this.parseParameters();
   }

   protected void parseParameters(){
      this.setMyReturnValue(this.myValue);
   }
}
