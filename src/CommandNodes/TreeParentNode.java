package CommandNodes;


import Controller.ControllerInterfaces.CommandControllerInterface;

public class TreeParentNode extends CommandNode{

   public TreeParentNode(CommandControllerInterface controller){
      super(controller);
   }

   public void execute(){}

   public void parseParameters(){}

   public boolean childrenFilled(){
      return false;
   }
}
