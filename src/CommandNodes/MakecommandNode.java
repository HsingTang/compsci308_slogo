package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;
import Model.CommandInfo;

import java.util.ArrayList;

public class MakecommandNode extends CommandNode{
   private ArrayList<CommandNode> commandChildren;
   private ArrayList<CommandNode> executeChildren;
   private ArrayList<String> variables;
   private String name;

   public MakecommandNode(CommandHandlerInterface inHandler){
      super(inHandler);
   }

   public MakecommandNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler, inParent);
      this.commandChildren = new ArrayList<>();
      this.variables = new ArrayList<>();
      this.executeChildren = new ArrayList<>();
   }


   public void execute(){
      this.makeUserCommand();
   }

   public boolean childrenFilled(){
      int numRightBrackets = 0;
      int numLeftBrackets = 0;
      for(CommandNode c: this.commandChildren){
         if(c instanceof RightBracketNode){
            numRightBrackets++;
         }
         if(c instanceof LeftBracketNode){
            numLeftBrackets++;
         }
      }
      if(numLeftBrackets > 1 && numLeftBrackets==numRightBrackets){
         return true;
      }
      else{
         return false;
      }
   }

   public void addChild(CommandNode newChild){
      newChild.setParent(this);

      this.commandChildren.add(newChild);
   }

   protected void parseParameters(){
      int left = 0;
      this.name = ((StringNode)(this.commandChildren.get(0))).getMyStringValue();
      for(CommandNode c: this.commandChildren){
         if(c instanceof LeftBracketNode){
            left++;
         }
         else {
            if(left == 1 && !(c instanceof RightBracketNode)){
                  this.variables.add(((VariableNode) (c)).getMyStringValue());
               }
            else if(left == 2 && !(c instanceof RightBracketNode)){
               this.executeChildren.add(c);
            }
         }
      }
   }

   public void makeUserCommand(){
      this.parseParameters();
      CommandInfo info = new CommandInfo(name, executeChildren, variables);
      this.myHandler.makeCommand(info);
   }
}
