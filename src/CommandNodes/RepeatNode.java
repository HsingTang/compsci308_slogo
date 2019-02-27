package CommandNodes;

import CommandTree.CommandRoot;
import Controller.ControllerInterfaces.CommandControllerInterface;

import java.util.ArrayList;

public class RepeatNode extends CommandNode {


   public RepeatNode(CommandControllerInterface inController){
      super(inController);
   }

   public RepeatNode(CommandControllerInterface inController, CommandNode inParent){
      super(inController, inParent);
   }

   public void execute(){
   }

   public boolean childrenFilled(){
      for(CommandNode c: this.getMyChildren()){
         if(c instanceof RightBracketNode){
            this.parseParameters();
            return true;
         }
      }
      return false;
   }

   public void parseParameters(){
      this.setMyNumRepeat(this.getNextDouble());
   }

}
