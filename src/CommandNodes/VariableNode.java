package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * @author Mary Gooneratne
 * CommandNode that extends ConstantNode that is storage object for variable command
 */
public class VariableNode extends ConstantNode{
   private String myStringValue = "";

   /**
    * Instantiates VariableNode object
    * @param inHandler handles this node
    * @param inParent parent of this node
    * @param s name of this variable
    */
   public VariableNode(CommandHandlerInterface inHandler, CommandNode inParent, String s){
      super(inHandler, inParent);
      this.myStringValue = s;
   }

   /**
    * Parses command parameters and calls appropriate execution method on handler
    */
   public void execute(){
      this.parseParameters();
      this.setMyReturnValue(this.getMyValue());
   }

   /**
    * @return name of variable
    */
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
