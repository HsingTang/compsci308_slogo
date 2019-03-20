package CommandNodes;


import Handlers.HandlerInterfaces.CommandHandlerInterface;
import View.ObserverInterfaces.TurtleObserver;

/**
 * CommandNode that serves as the top-most node of all CommandRoots
 */
public class TreeParentNode extends CommandNode{

   private TurtleObserver tView;

   /**
    * Instantiates TreeParent Node
    * @param Handler handles this root
    * @param o observer assigned to this tree
    */
   public TreeParentNode(CommandHandlerInterface Handler, TurtleObserver o){
      super(Handler);
      tView = o;
   }

   /**
    * Parses command parameters and calls appropriate execution method on handler
    */
   public void execute(){
      tView.updateView();
   }

   public void parseParameters(){}

   /**
    * Checks if all children are filled
    * @return false, tree can always grow
    */
   public boolean childrenFilled(){
      return false;
   }
}
