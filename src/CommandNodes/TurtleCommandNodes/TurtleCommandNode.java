package CommandNodes.TurtleCommandNodes;

import CommandNodes.CommandNode;
import CommandNodes.ConstantNode;

import Controller.ControllerInterfaces.CommandControllerInterface;

public abstract class TurtleCommandNode extends CommandNode {
   private static int INIT_INDEX;

   private int myChildrenIndex;

   public TurtleCommandNode(CommandControllerInterface inController){
      super(inController);
      this.myChildrenIndex = INIT_INDEX;
   }

   public TurtleCommandNode(CommandControllerInterface inController, CommandNode inParent){
      super(inController, inParent);
      this.myChildrenIndex = INIT_INDEX;
   }

   private ConstantNode getNextNode(){
      ConstantNode nextNode = null;
      try{
         nextNode = (ConstantNode)(this.getMyChildren().get(this.myChildrenIndex));
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
         ConstantNode nextNode = this.getNextNode();
         value = nextNode.getMyValue();
      }
      catch(Exception e){
         /**
          * Error regarding incorrect parameter
          */
      }
      return value;
   }

   protected double getPixels(){
      return this.getNextDouble();
   }

   protected double getDegrees(){
      return this.getNextDouble();
   }

   protected double getX(){
      return this.getNextDouble();
   }

   protected double getY(){
      return this.getNextDouble();
   }


   protected abstract void parseParameters();

   protected abstract void execute();
}
