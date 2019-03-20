package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * @author Mary Gooneratne
 * CommandNode that changes heading of turtle
 */
public class SetheadingNode extends TurtleCommandNode{
   private static final int SET_HEADING_PARAMS = 1;

   private double myDegrees;

   /**
    * Instantiates SetheadingNode object
    * @param inHandler handles this command node
    */
   public SetheadingNode(CommandHandlerInterface inHandler){
      super(inHandler);
      this.setMyNumParams(SET_HEADING_PARAMS);
   }

   /**
    * Instantiates SetheadingNode object
    * @param inHandler handles the command node
    * @param inParent parent of this command node
    */
   public SetheadingNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler, inParent);
      this.setMyNumParams(SET_HEADING_PARAMS);
   }

   /**
    * Parses command parameters and calls appropriate execution method on handler
    */
   public void execute(){
      this.parseParameters();
      this.setMyReturnValue(this.myHandler.setHeading(this.myDegrees));
   }

   protected void parseParameters(){
      try {
         this.myDegrees = this.getDegrees();
      }
      catch(Exception e){
         /**
          * Error regarding parameter parsing
          */
      }
   }
}
