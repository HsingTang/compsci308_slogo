package Model;

import CommandNodes.CommandNode;

import java.util.ArrayList;
import java.util.List;

public class CommandInfo {
   private String name;
   private List<CommandNode> commandChildren;
   private List<String> commandVariables;

   public CommandInfo(String myName, ArrayList<CommandNode> myCommandChildren, ArrayList<String> myVariables){
      this.name = myName;
      this.commandChildren = myCommandChildren;
      this.commandVariables = myVariables;
   }

   public String getName(){
      return this.name;
   }

   public List<CommandNode> getCommandChildren(){
      return this.commandChildren;
   }

   public List<String> getCommandVariables(){
      return this.commandVariables;
   }
}
