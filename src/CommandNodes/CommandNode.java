package CommandNodes;

import Controller.ControllerInterfaces.CommandControllerInterface;

import java.util.ArrayList;

public abstract class CommandNode {
   private static int INIT = 0;


   protected CommandControllerInterface myController;
   private ArrayList<CommandNode> myChildren;
   private CommandNode myParent;
   private int myNumParams;
   private Double myReturnValue;
   private int myChildrenIndex;

   public CommandNode(CommandControllerInterface inController) {
      this.myChildren = new ArrayList<CommandNode>();
      this.myController = inController;
      this.myNumParams = INIT;
      this.myChildrenIndex = 0;
   }

   public CommandNode(CommandControllerInterface inController, CommandNode inParent){
      this.myChildren = new ArrayList<CommandNode>();
      this.myController = inController;
      this.myNumParams = INIT;
      this.myParent = inParent;
      this.myChildrenIndex = 0;

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
      this.myNumParams--;
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

   public int getMyChildrenIndex(){
      return this.myChildrenIndex;
   }

   protected CommandNode getNextNode(){
      CommandNode nextNode = null;
      try{
         nextNode = (CommandNode)(this.getMyChildren().get(this.myChildrenIndex));
         this.myChildrenIndex++;
      }
      catch(Exception e){
         /**
          * Error regarding incorrect node type
          */
      }

      return nextNode;
   }

   protected double getNextDouble(){
      double value = 0;
      try{
         ConstantNode nextNode = (ConstantNode)(this.getNextNode());
         value = nextNode.getMyValue();
      }
      catch(Exception e){
         /**
          * Error regarding incorrect parameter
          */
      }
      return value;
   }

   public boolean childrenFilled() {
      return this.myNumParams == 0;
   }

   /* public CommandNode getNewNode(){
      ConstantNode newNode = new ConstantNode(this.myController, this.myParent);
      newNode.setMyValue(this.myReturnValue);
      return newNode;
   }

   private Double getMyReturnValue(){
      return this.myReturnValue;
   }*/

   protected void setMyNumParams(int num){
      this.myNumParams = num;
   }

   protected void resetIndex(){
      this.myChildrenIndex = 0;
   }

  /* protected void setReturnValue(Double returnValue){
      this.myReturnValue = returnValue;
   }*/

   public void fullExecute(){
      this.execute();
      this.resetIndex();
   }

   public abstract void execute();

   protected abstract void parseParameters();


}
