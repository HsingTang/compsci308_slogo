package CommandTree;

import java.util.ArrayList;

public class CommandNode {
   private ArrayList<CommandNode> children;
   private CommandNode parent;
   private String type;

   public CommandNode(){
      this.children = new ArrayList<CommandNode>();
      this.type = "parent";
   }

   public void setChildren(ArrayList<CommandNode> newChildren){
      this.children = newChildren;
      for(CommandNode child: newChildren){
         child.setParent(this);
      }
   }

   public void addChild(CommandNode newChild){
      newChild.setParent(this);
      this.children.add(newChild);
   }

   public void setParent(CommandNode newParent){
      this.parent = newParent;
   }

   public CommandNode getParent(){
      return this.parent;
   }

   public ArrayList<CommandNode> getChildren(){
      return this.children;
   }

   public String getType(){
      return this.type;
   }

   public void setType(String type){
      this.type = type;
   }
}
