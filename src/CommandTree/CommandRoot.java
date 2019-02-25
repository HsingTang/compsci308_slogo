package CommandTree;

import java.util.ArrayList;

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
         if(s.equals("forward") || s.equals("left") || s.equals("backward") || s.equals("right")){
            current.addChild(new TurtleCommandNode(s));
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
         else{
            int lastChildIndex = current.getChildren().size()-1;
            current.getChildren().get(lastChildIndex).addParameter(s);
         }
      }
   }

   public CommandNode getParent(){
      return this.parent;
   }
}