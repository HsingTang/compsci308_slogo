package Model;

import CommandNodes.CommandNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mary Gooneratne
 * Storage object for properties of user-defined command
 */
public class CommandInfo {
   private String name;
   private List<CommandNode> commandChildren;
   private List<String> commandVariables;

   /**
    * Instantiates CommandInfo object
    * @param myName name of command
    * @param myCommandChildren children of command
    * @param myVariables parameters of command
    */
   public CommandInfo(String myName, ArrayList<CommandNode> myCommandChildren, ArrayList<String> myVariables){
      this.name = myName;
      this.commandChildren = myCommandChildren;
      this.commandVariables = myVariables;
   }

   /**
    * @return name of command
    */
   public String getName(){
      return this.name;
   }

   /**
    * @return children of command to  front end
    */

   public List<CommandNode> getCommandChildren(){
      return this.commandChildren;
   }

   /**
    * @return list of parameters to front end
    */

   public List<String> getCommandVariables(){
      return this.commandVariables;
   }
}
