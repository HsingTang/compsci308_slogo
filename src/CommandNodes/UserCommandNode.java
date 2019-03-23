package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;
import Model.CommandInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mary Gooneratne
 * CommandNode that serves as the storage object for user-defined commands
 */

public class UserCommandNode extends CommandNode {
   private List<String> parameters;
   private List<CommandNode> executeChildren;
   private String name;

   /**
    * Instantiates UserCommandNode object
    * @param inHandler handles this command node
    */
   public UserCommandNode(CommandHandlerInterface inHandler){
      super(inHandler);
   }

   /**
    * Instantiates UserCommandNode
    * @param inHandler handles this command node
    * @param inParent parent of this node
    * @param params parameters of this command
    * @param executeChildren children of this command
    */
   public UserCommandNode(CommandHandlerInterface inHandler, CommandNode inParent, ArrayList<String> params, ArrayList<CommandNode> executeChildren){
      super(inHandler, inParent);
      this.parameters = params;
      this.setMyNumParams(params.size());
      this.executeChildren = executeChildren;
   }

   /**
    * Instantiates UserCommandNode
    * @param inHandler handles this command node
    * @param inParent parent of this command node
    * @param info object that stores params and block of commandnodes and name of command
    */
   public UserCommandNode(CommandHandlerInterface inHandler, CommandNode inParent, CommandInfo info){
      super(inHandler, inParent);
      this.parameters = info.getCommandVariables();
      this.setMyNumParams(this.parameters.size());
      this.executeChildren = info.getCommandChildren();
   }

   /**
    * Parses command parameters and calls appropriate execution method on handler
    */
   public void execute(){
      this.parseParameters();
   }

   public void parseParameters(){
      for(int i = 0; i < this.parameters.size(); i++){
         this.myHandler.makeVariable(this.parameters.get(i), this.getMyChildren().get(i).getMyReturnValue());
      }
   }

   /**
    * @return user-defined command to front end
    */
   public List<CommandNode> getExecuteChildren(){
      return this.executeChildren;
   }

   private void clearVars(){
      for(int i = 0; i < this.getMyNumParams(); i++){
         this.myHandler.makeVariable(this.parameters.get(i), 0.0);
      }
   }
}
