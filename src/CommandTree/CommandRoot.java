package CommandTree;

public class CommandRoot {
   CommandNode parent;
   CommandNode current;
   String[] commandStrings;

   public CommandRoot(String[] commandStrings){
      this.commandStrings = commandStrings;
      this.parent = new CommandNode();
      this.current = this.parent;
      this.makeTree();
   }

   private void makeTree(){
      for(int i = 0; i < commandStrings.length; i++){
         String s = commandStrings[i];
         if(s.equals("forward")){
            int num = Integer.parseInt(commandStrings[i+1]);
            current.addChild(new TurtleCommandNode(num));
            i = i + 1;
         }
         else if(s.equals("repeat")){
            int num = Integer.parseInt(commandStrings[i+1]);
            LoopNode loop = new LoopNode(num);
            current.addChild(loop);
            current = loop;
            i = i+2;
         }
         else if(s.equals("]")){
            current = current.getParent();
         }
      }
   }

   public CommandNode getParent(){
      return this.parent;
   }
}