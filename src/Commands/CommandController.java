package Commands;

public class CommandController {
   Command parent;
   String commandInput;
   public CommandController(String commands){
      this.commandInput = commands;
      this.makeTree();
   }

   private void makeTree(){
   }
}
