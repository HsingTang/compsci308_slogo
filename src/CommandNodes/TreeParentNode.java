package CommandNodes;


import Handlers.HandlerInterfaces.CommandHandlerInterface;
import View.ObserverInterfaces.TurtleObserver;

/**
 * CommandNode that serves as the top-most node of all CommandRoots. I've also added this to my masterpiece
 * because it shows that when all the commands have finished executing, the update method is called onto the
 * turtle observer. The update method will get all the necessary new model states and change them in order!
 *
 * @author Mary
 * @author Eric Lin
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
