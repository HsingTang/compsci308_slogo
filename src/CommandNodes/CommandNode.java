package CommandNodes;

import Controller.ControllerInterfaces.CommandControllerInterface;

import java.util.ArrayList;

public abstract class CommandNode {
   private static int INIT_PARAMS = 0;

   protected CommandControllerInterface myController;
   private ArrayList<CommandNode> myChildren;
   private CommandNode myParent;
   private int myNumParams;

   public CommandNode(CommandControllerInterface inController) {
      this.myChildren = new ArrayList<CommandNode>();
      this.myController = inController;
      this.myNumParams = INIT_PARAMS;
   }

   public CommandNode(CommandControllerInterface inController, CommandNode inParent){
      this.myChildren = new ArrayList<CommandNode>();
      this.myController = inController;
      this.myNumParams = INIT_PARAMS;
      this.myParent = inParent;

}

   public void setChildren(ArrayList<CommandNode> newChildren){
      this.myChildren = newChildren;
      for(CommandNode child: newChildren){
         child.setParent(this);
      }
   }

   public void addChild(CommandNode newChild){
      newChild.setParent(this);
      this.myChildren.add(newChild);
   }

   public ArrayList<CommandNode> getMyChildren(){
      return this.myChildren;
   }

   public void setParent(CommandNode newParent){
      this.myParent = newParent;
   }

   public CommandNode getParent(){
      return this.myParent;
   }

   protected void setMyNumParams(int num){
      this.myNumParams = num;
   }

   protected abstract void execute();

   protected abstract void parseParameters();

}
