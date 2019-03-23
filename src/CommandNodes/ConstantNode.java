package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * @author Mary Gooneratne
 * CommandNode that holds a constant numerical value
 */
public class ConstantNode extends CommandNode {
   private static final int CONSTANT_PARAMS = 0;
   private static final Double INIT_VAL = 0.0;

   protected double myValue;

   /**
    * Instantiates new ConstantNode
    * @param inHandler the handler that executes commands of the tree the node belongs to
    */
   public ConstantNode(CommandHandlerInterface inHandler){
      super(inHandler);
      this.setMyNumParams(CONSTANT_PARAMS);
      this.myValue = INIT_VAL;
      this.setMyValue(INIT_VAL);
   }

   /**
    * Instantiates new ConstantNode
    * @param inHandler CommandHandler of the node
    * @param inParent parent of the node
    */
   public ConstantNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler);
      this.setMyNumParams(CONSTANT_PARAMS);
      this.setParent(inParent);
      this.myValue = INIT_VAL;
      this.setMyValue(INIT_VAL);
   }

   /**
    * Instantiates new ConstantNode
    * @param inHandler handler that executes commands of corresponding node tree
    * @param inParent parent of node
    * @param inValue constant value of node
    */
   public ConstantNode(CommandHandlerInterface inHandler, CommandNode inParent, double inValue){
      super(inHandler);
      this.setMyNumParams(CONSTANT_PARAMS);
      this.setMyValue(inValue);
   }

   /**
    * @return value of ConstantNode
    */
   public double getMyValue(){
      return this.myValue;
   }

   protected void setMyValue(Double value){
      this.myValue = value;

      this.setMyReturnValue(this.myValue);
   }

   /**
    * Parses command parameters and calls appropriate execution method on handler
    */
   public void execute(){
      this.parseParameters();
   }

   /**
    * Parses command children to parameters
    */
   protected void parseParameters(){
      this.setMyReturnValue(this.myValue);
   }
}
