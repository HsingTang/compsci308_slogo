package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class RepeatNode extends CommandNode {


   public RepeatNode(CommandHandlerInterface inHandler){
      super(inHandler);
   }

   public RepeatNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler, inParent);
   }

   public void execute(){
   }

   public boolean childrenFilled(){
      for(CommandNode c: this.getMyChildren()){
         if(c instanceof RightBracketNode){
            this.parseParameters();
            return true;
         }
      }
      return false;
   }

   public void parseParameters(){
      this.setMyNumRepeat(this.getNextDouble());
   }

}
