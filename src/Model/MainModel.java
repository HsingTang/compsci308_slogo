package Model;

import CommandTree.CommandRoot;
import CommandTree.LoopNode;


public class MainModel {
   private CommandRoot currentRoot;
   private TurtleModel turtleModel;

   public MainModel(){
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
         this.executeLoop(parent);
      }
      else if(parent instanceof TurtleCommandNode){
         turtleModel.execute((TurtleCommandNode) (parent));
      }
   }

   private void executeLoop(CommandNode parent){
      (parent).parseParameters();
      for(int i = 1; i < ((LoopNode) parent).getNumTimes(); i++){
         for(CommandNode c: parent.getChildren())
            this.executeNode(c);
      }
   }


}
