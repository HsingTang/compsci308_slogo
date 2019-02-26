package CommandNodes;

import CommandNodes.CommandNode;
import Controller.ControllerInterfaces.CommandControllerInterface;

public class RightBracketNode extends CommandNode {

   public RightBracketNode(CommandControllerInterface inController){
      super(inController);
   }

   public RightBracketNode(CommandControllerInterface inController, CommandNode inParent){
      super(inController, inParent);
   }

   public void execute(){ }

   protected void parseParameters(){}
}
