package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * @author Mary Gooneratne
 * CommandNode that stores constant String Value
 */
public class StringNode extends CommandNode {
   private static final double INIT = 0.0;
   private String myStringValue = "";

   /**
    * Instantiates StringNode object
    * @param inHandler handles this node
    */
   public StringNode(CommandHandlerInterface inHandler){
      super(inHandler);
   }

   /**
    * Instantiates StringNode object
    * @param inHandler handles this node
    * @param inParent parent of this node
    */
   public StringNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler, inParent);
   }
   public StringNode(CommandHandlerInterface inHandler, CommandNode inParent, String s){
      super(inHandler, inParent);
      this.myStringValue = s;
   }

   /**
    * Parses command parameters and calls appropriate execution method on handler
    */
   public void execute(){
      this.parseParameters();
      this.setMyReturnValue(INIT);
   }

   /**
    * @return constant String value of this node
    */
   public String getMyStringValue(){
      return this.myStringValue;
   }

   protected void parseParameters(){}
}
