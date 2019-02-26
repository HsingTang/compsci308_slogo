package CommandNodes;

import CommandTree.CommandRoot;
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
   public double getNumRepeat(){
      return this.numRepeat;
   }
}
