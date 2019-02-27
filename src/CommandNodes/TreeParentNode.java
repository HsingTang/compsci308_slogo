package CommandNodes;


import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class TreeParentNode extends CommandNode{

   public TreeParentNode(CommandHandlerInterface Handler){
      super(Handler);
   }

   public void execute(){}

   public void parseParameters(){}

   public boolean childrenFilled(){
      return false;
   }
}
