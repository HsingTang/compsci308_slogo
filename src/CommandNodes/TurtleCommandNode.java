package CommandNodes;

import CommandNodes.CommandNode;
import CommandNodes.ConstantNode;

import Controller.ControllerInterfaces.CommandControllerInterface;

public abstract class TurtleCommandNode extends CommandNode {


   private int myChildrenIndex;

   public TurtleCommandNode(CommandControllerInterface inController){
      super(inController);
   }

   public TurtleCommandNode(CommandControllerInterface inController, CommandNode inParent){
      super(inController, inParent);
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

   public abstract void execute();
}
