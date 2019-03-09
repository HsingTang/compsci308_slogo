package Model;

import CommandNodes.CommandNode;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CommandInfo {
   private String name;
   private ArrayList<CommandNode> commandChildren;
   private ArrayList<String> commandVariables;

   public CommandInfo(String myName, ArrayList<CommandNode> myCommandChildren, ArrayList<String> myVariables){
      this.name = myName;
      this.commandChildren = myCommandChildren;
      this.commandVariables = myVariables;
   }

   public String getName(){
      return this.name;
   }

   public ArrayList<CommandNode> getCommandChildren(){
      return this.commandChildren;
   }

   public ArrayList<String> getCommandVariables(){
      return this.commandVariables;
   }
}
