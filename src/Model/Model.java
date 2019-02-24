package Model;

import CommandTree.CommandNode;
import CommandTree.CommandRoot;
import CommandTree.LoopNode;
import CommandTree.TurtleCommandNode;
import Models.TurtleModel;

public class Model {
   private CommandRoot currentRoot;
   private TurtleModel turtleModel;

   public Model(){
      this.turtleModel = new TurtleModel();
   }

   public void setCurrentRoot(CommandRoot newRoot){
      this.currentRoot = newRoot;
   }

   public void execute(){
      this.executeNode(this.currentRoot.getParent());
   }

   private void executeNode(CommandNode parent){
      for(CommandNode c: parent.getChildren()){
         this.executeNode(c);
      }
      if(parent instanceof LoopNode){
         for(int i = 1; i < ((LoopNode) parent).getNumTimes(); i++){
            for(CommandNode c: parent.getChildren())
               this.executeNode(c);
            }
         }
      else if(parent instanceof TurtleCommandNode){
         turtleModel.execute((TurtleCommandNode) (parent));
      }
   }
}
