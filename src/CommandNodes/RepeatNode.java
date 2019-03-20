package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * @author Mary Gooneratne
 * CommandNode that indicates a command block is to be repeated more than once
 */
public class RepeatNode extends CommandNode {
   /**
    * Instantiates RepeatNode object
    * @param inHandler handles this command node
    */
   public RepeatNode(CommandHandlerInterface inHandler){
      super(inHandler);
   }

   /**
    * Instantiates RepeatNode object
    * @param inHandler handles this command node
    * @param inParent parent of this command ndoe
    */
   public RepeatNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler, inParent);
   }

   /**
    * Parses command parameters and calls appropriate execution method on handler
    */
   public void execute(){
      this.parseParameters();
   }

   /**
    * Checks if children are filled by checking if brackets are closed
    * @return true if brackets are closed, false else
    */
   public boolean childrenFilled(){
      for(CommandNode c: this.getMyChildren()){
         if(c instanceof RightBracketNode){
            return true;
         }
      }
      return false;
   }
   protected void parseParameters(){
      this.setMyNumRepeat(this.getNextDouble());
   }

}
