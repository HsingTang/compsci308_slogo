package CommandNodes.StructureNodes;

import CommandNodes.CommandNode;
import Controller.ControllerInterfaces.CommandControllerInterface;

public class RepeatNode extends CommandNode {

   private double numRepeat;

   public RepeatNode(CommandControllerInterface inController){
      super(inController);
   }

   public RepeatNode(CommandControllerInterface inController, CommandNode inParent){
      super(inController, inParent);
   }

   public void execute(){
      this.parseParameters();
      for(int i = 1; i < numRepeat; i++){
         CommandNode currentNode = this.getNextNode();
         currentNode.execute();
      }
   }

   public boolean childrenFilled(){
      for(CommandNode c: this.getMyChildren()){
         if(c instanceof RightBracketNode){
            return true;
         }
      }
      return false;
   }

   public void parseParameters(){
      this.numRepeat = this.getNextDouble();
   }
}
