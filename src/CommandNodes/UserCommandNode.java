package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;
import Model.CommandInfo;

import java.util.ArrayList;
import java.util.List;

public class UserCommandNode extends CommandNode {
   private List<String> parameters;
   private List<CommandNode> executeChildren;
   private String name;

   public UserCommandNode(CommandHandlerInterface inHandler){
      super(inHandler);
   }

   public UserCommandNode(CommandHandlerInterface inHandler, CommandNode inParent, ArrayList<String> params, ArrayList<CommandNode> executeChildren){
      super(inHandler, inParent);
      this.parameters = params;
      this.setMyNumParams(params.size());
      this.executeChildren = executeChildren;
   }

   public UserCommandNode(CommandHandlerInterface inHandler, CommandNode inParent, CommandInfo info){
      super(inHandler, inParent);
      this.parameters = info.getCommandVariables();
//      System.out.println("SIZE " + this.parameters.size());
      this.setMyNumParams(this.parameters.size());
      this.executeChildren = info.getCommandChildren();
   }

   public void execute(){
      this.parseParameters();
   }

   public void parseParameters(){
      for(int i = 0; i < this.parameters.size(); i++){
         this.myHandler.makeVariable(this.parameters.get(i), this.getMyChildren().get(i).getMyReturnValue());
//         System.out.println(this.myHandler.isVariable("dog"));
      }
   }

   public List<CommandNode> getExecuteChildren(){
      return this.executeChildren;
   }

   private void clearVars(){
      for(int i = 0; i < this.getMyNumParams(); i++){
         this.myHandler.makeVariable(this.parameters.get(i), 0.0);
      }
   }
}
