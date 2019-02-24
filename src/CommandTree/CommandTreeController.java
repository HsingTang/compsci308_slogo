package CommandTree;

public class CommandTreeController {
   CommandRoot commandRoot;

   public CommandTreeController(CommandRoot commandRoot){
      this.commandRoot = commandRoot;
   }

   public void execute(CommandNode parent){
      for(CommandNode c: parent.getChildren()){
         this.execute(c);
      }
      if(parent instanceof LoopNode){
         for(int i = 1; i < ((LoopNode) parent).getNumTimes(); i++){
            for(CommandNode c: parent.getChildren()){
               this.execute(c);
            }
         }
      }
      System.out.println(parent.getType());
      System.out.print(" ");
      if(parent instanceof TurtleCommandNode){
         System.out.println(((TurtleCommandNode) parent).getValue());
      }
      else if (parent instanceof LoopNode){
         System.out.println(((LoopNode) parent).getNumTimes());
      }
   }
}
