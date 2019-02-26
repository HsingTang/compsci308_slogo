package CommandNodes.TurtleCommandNodes;

import CommandNodes.CommandNode;
import CommandNodes.ConstantNode;

import Controller.ControllerInterfaces.CommandControllerInterface;

public abstract class TurtleCommandNode extends CommandNode {

   public TurtleCommandNode(CommandControllerInterface inController){
      super(inController);
   }

   public TurtleCommandNode(CommandControllerInterface inController, CommandNode inParent){
      super(inController, inParent);
   }

   private ConstantNode getPixelsNode(){
      ConstantNode pixelsNode = null;
      try{
         pixelsNode = (ConstantNode)(this.getMyChildren().get(0));
      }
      catch(Exception e){
         /**
          * Error regarding incorrect node type for pixels
          */
      }
      return pixelsNode;
   }

   protected double getPixels(){
      double pixels = 0;
      try{
         ConstantNode pixelsNode = this.getPixelsNode();
         pixels = pixelsNode.getMyValue();
      }
      catch(Exception e){
         /**
          * Error regarding incorrect pixels parameter
          */
      }
      return pixels;
   }

   protected double getDegrees(){
      return this.getPixels();
   }


   protected abstract void parseParameters();

   protected abstract void execute();
}
