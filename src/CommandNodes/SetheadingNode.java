package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class SetheadingNode extends TurtleCommandNode{
   private static int SET_HEADING_PARAMS = 1;

   private double myDegrees;

   public SetheadingNode(CommandHandlerInterface inHandler){
      super(inHandler);
      this.setMyNumParams(SET_HEADING_PARAMS);
   }

   public SetheadingNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler, inParent);
      this.setMyNumParams(SET_HEADING_PARAMS);
   }

   public void execute(){
      this.parseParameters();
      this.myHandler.setHeading(this.myDegrees);
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
