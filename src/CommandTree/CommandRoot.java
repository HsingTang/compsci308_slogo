package CommandTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CommandRoot {
   private static String END_EXPRESSION = "]";
   private static String START_EXPRESSION = "[";
   private static String LOOP_EXPRESSION = "repeat";


   private CommandNode parent;
   private CommandNode current;
   private String[] commandStrings;
   private int numCommands;
   private int commandIndex;
   private Set<String> turtlecommands;

   public CommandRoot(String[] commandStrings){
      this.commandStrings = commandStrings;
      this.numCommands = commandStrings.length;
      this.parent = new CommandNode();
      this.current = this.parent;
      this.commandIndex = 0;
      this.setCommands();
      this.makeTree();
   }

   private void makeTree(){
      while(this.commandIndex < this.numCommands){
         String s = this.commandStrings[this.commandIndex];
         if(turtlecommands.contains(s)){
            CommandNode newNode = new TurtleCommandNode(s);
            this.addParameters(newNode);
            current.addChild(newNode);
         }
         else if(s.equals(LOOP_EXPRESSION)){
            LoopNode newNode = new LoopNode(s);
            this.addParameters(newNode);
            current.addChild(newNode);
            current = newNode;
         }
         else if(s.equals(END_EXPRESSION)){
            current = current.getParent();
         }
         this.commandIndex++;
      }
   }

   private void addParameters(CommandNode newNode){
      if(newNode instanceof TurtleCommandNode){
         while(!this.endParam()){
            this.commandIndex++;
            newNode.addParameter(commandStrings[this.commandIndex]);
         }
      }
      else {
         this.addLoopParameters(newNode);
      }



   }

   private boolean endParam(){
      return this.commandIndex+1 >= numCommands || this.turtlecommands.contains(commandStrings[this.commandIndex+1]) || this.commandStrings[this.commandIndex+1].equals("repeat") || this.commandStrings[this.commandIndex+1].equals("[") || this.commandStrings[this.commandIndex+1].equals("]");
   }

   private void addLoopParameters(CommandNode newNode){
      while(!this.endParam()){
         this.commandIndex++;
         newNode.addParameter(commandStrings[this.commandIndex]);
      }
   }

   public void setCommands(){
      this.turtlecommands = new HashSet<>();
      this.turtlecommands.add("forward");
      this.turtlecommands.add("left");
      this.turtlecommands.add("backward");
      this.turtlecommands.add("right");
   }

   public CommandNode getParent(){
      return this.parent;
   }
}