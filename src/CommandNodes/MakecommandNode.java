package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;
import Model.CommandInfo;

import java.util.ArrayList;

/**
 * @author Mary Gooneratne
 * CommandNode signaling the start of a user-defined command
 */
public class MakecommandNode extends CommandNode{
   private ArrayList<CommandNode> commandChildren;
   private ArrayList<CommandNode> executeChildren;
   private ArrayList<String> variables;
   private String name;

   /**
    * Instantiates MakeCommand node
    * @param inHandler handler that handles CommandNodes
    */
   public MakecommandNode(CommandHandlerInterface inHandler){
      super(inHandler);
   }

   /**
    * Instantiates MakeCommand node
    * @param inHandler handler that handles commandNodes
    * @param inParent parent of this command node
    */
   public MakecommandNode(CommandHandlerInterface inHandler, CommandNode inParent){
      super(inHandler, inParent);
      this.commandChildren = new ArrayList<>();
      this.variables = new ArrayList<>();
      this.executeChildren = new ArrayList<>();
   }

   /**
    * Parses command parameters and calls appropriate execution method on handler
    */
   public void execute(){
      this.makeUserCommand();
   }

   /**
    * Checks if children are filled by checking if brackets are closed
    * @return true if all parameters necessary filled, else false
    */
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
      return numLeftBrackets > 1 && numLeftBrackets==numRightBrackets;
   }

   /**
    * Adds child to user-defined command children node
    * @param newChild commandNode to be added as child
    */
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

   private void makeUserCommand(){
      this.parseParameters();
      CommandInfo info = new CommandInfo(name, executeChildren, variables);
      this.myHandler.makeCommand(info);
   }
}
