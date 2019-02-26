package CommandNodes;

import Controller.ControllerInterfaces.CommandControllerInterface;

public class ConstantNode extends CommandNode {
   private static int CONSTANT_PARAMS = 0;
   private static int INIT_VAL = 0;

   private double myValue;

   public ConstantNode(CommandControllerInterface inController){
      super(inController);
      this.setMyNumParams(CONSTANT_PARAMS);
      this.myValue = INIT_VAL;
   }

   public ConstantNode(CommandControllerInterface inController, CommandNode inParent){
      super(inController);
      this.setMyNumParams(CONSTANT_PARAMS);
      this.setParent(inParent);
      this.myValue = INIT_VAL;
   }

   public ConstantNode(CommandControllerInterface inController, CommandNode inParent, double inValue){
      super(inController);
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
   }
}
