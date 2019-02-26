package CommandNodes.StructureNodes;

import CommandNodes.CommandNode;
import Controller.ControllerInterfaces.CommandControllerInterface;

public class RepeatNode extends CommandNode {

   private double numRepeat;

   public RepeatNode(CommandControllerInterface inController){
      super(inController);
   }

   public void execute(){
      this.parseParameters();
      for(int i = 1; i < numRepeat; i++){
         CommandNode currentNode = this.getNextNode();
         currentNode.execute();
      }
   }

   public void parseParameters(){
      this.numRepeat = this.getNextDouble();
   }
}
