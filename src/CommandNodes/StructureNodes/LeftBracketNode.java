package CommandNodes.StructureNodes;

import CommandNodes.CommandNode;
import Controller.ControllerInterfaces.CommandControllerInterface;

public class LeftBracketNode extends CommandNode {

   public LeftBracketNode(CommandControllerInterface inController){
      super(inController);
   }

   public LeftBracketNode(CommandControllerInterface inController, CommandNode inParent){
      super(inController, inParent);
   }

   public void execute(){
      this.parseParameters();
   }

   protected void parseParameters(){}
}
