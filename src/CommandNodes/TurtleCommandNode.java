package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public abstract class TurtleCommandNode extends CommandNode {

   private int myChildrenIndex;

   public TurtleCommandNode(CommandHandlerInterface inHandler){
      super(inHandler);
   }

   public TurtleCommandNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler, inParent);
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
