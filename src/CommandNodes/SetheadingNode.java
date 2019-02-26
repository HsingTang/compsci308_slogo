package CommandNodes;

import Controller.ControllerInterfaces.CommandControllerInterface;

public class SetheadingNode extends TurtleCommandNode{
   private static int SET_HEADING_PARAMS = 1;

   private double myDegrees;

   public SetheadingNode(CommandControllerInterface inController){
      super(inController);
      this.setMyNumParams(SET_HEADING_PARAMS);
   }

   public SetheadingNode(CommandControllerInterface inController, CommandNode inParent){
      super(inController, inParent);
      this.setMyNumParams(SET_HEADING_PARAMS);
   }

   public void execute(){
      this.parseParameters();
      this.myController.setHeading(this.myDegrees);
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
