package CommandNodes;

import Controller.ControllerInterfaces.CommandControllerInterface;

public class ConstantNode extends CommandNode {
   private static int CONSTANT_PARAMS = 0;
   private static int INIT_VAL = 0;

   private String stringValue;
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

   public ConstantNode(CommandControllerInterface inController, CommandNode inParent, String inValue){
      super(inController);
      this.setMyNumParams(CONSTANT_PARAMS);
      this.stringValue = inValue;
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
      try{
         this.myValue = Double.parseDouble(this.stringValue);
      }
      catch(Exception e){
         /**
          * Error regarding incorrect constant value
          */
      }
   }
}
