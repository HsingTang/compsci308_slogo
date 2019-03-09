package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

import java.util.ArrayList;
import java.util.List;

public abstract class CommandNode {

   private static final int INIT = 0;

   protected final CommandHandlerInterface myHandler;
   private List<CommandNode> myChildren;
   private CommandNode myParent;
   private int myNumParams;
   private Double myReturnValue;
   private int myChildrenIndex;
   private double myNumRepeat;


   public CommandNode(CommandHandlerInterface inHandler) {
      this.myChildren = new ArrayList<CommandNode>();
      this.myHandler = inHandler;
      this.myNumParams = INIT;
      this.myChildrenIndex = 0;
      this.myNumRepeat = 1;
   }

   public CommandNode(CommandHandlerInterface inHandler, CommandNode inParent){
      this.myChildren = new ArrayList<CommandNode>();
      this.myHandler = inHandler;
      this.myNumParams = INIT;
      this.myParent = inParent;
      this.myChildrenIndex = 0;
      this.myNumRepeat = 1;

}

   public void setChildren(List<CommandNode> newChildren){
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

   public List<CommandNode> getMyChildren(){
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
         nextNode = this.getMyChildren().get(this.myChildrenIndex);
         this.myChildrenIndex++;
      }
      catch(Exception e){
         /**
          * Error regarding no child
          */
      }
      return nextNode;
   }

   protected double getNextDouble(){
      double value = 0;
      CommandNode nextNode = (this.getNextNode());
      return nextNode.getMyReturnValue();
   }

   public boolean childrenFilled() {
      return this.myNumParams == 0;
   }

   public double getMyNumRepeat() { return this.myNumRepeat; }


   /* public CommandNode getNewNode(){
      ConstantNode newNode = new ConstantNode(this.myHandler, this.myParent);
      newNode.setMyValue(this.myReturnValue)
      return newNode;
   }*/

   public Double getMyReturnValue(){
      return this.myReturnValue;
   }

   protected void setMyNumParams(int num){
      this.myNumParams = num;
   }

   protected void setMyNumRepeat(double num) { this.myNumRepeat = num; }

   protected void resetIndex(){
      this.myChildrenIndex = 0;
   }

   public int getMyNumParams(){
      return this.myNumParams;
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

   protected void setMyReturnValue(Double returnValue)
   {
      this.myReturnValue = returnValue;
   }

}
