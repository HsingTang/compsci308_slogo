package CommandNodes;


import Handlers.HandlerInterfaces.CommandHandlerInterface;
import View.ObserverInterfaces.TurtleObserver;

public class TreeParentNode extends CommandNode{

   private TurtleObserver tView;

   public TreeParentNode(CommandHandlerInterface Handler, TurtleObserver o){
      super(Handler);
      tView = o;
   }

   public void execute(){
      tView.updateView();
   }

   public void parseParameters(){}

   public boolean childrenFilled(){
      return false;
   }
}
