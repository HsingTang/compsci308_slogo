package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;
/**
 * @author Mary Gooneratne
 * Abstract CommandNode that serves as the framework for all CommandNodes that alter turtle properties
 */
public abstract class TurtleCommandNode extends CommandNode {

   private int myChildrenIndex;

   /**
    * Instantiates TurtleCommandNode
    * @param inHandler handles this node
    */
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

   /**
    * Parses command parameters and calls appropriate execution method on handler
    */
   public abstract void execute();
}
