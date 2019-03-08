package CommandNodes;

import CommandTree.CommandRoot;
import Handlers.HandlerInterfaces.CommandHandlerInterface;

import java.util.ArrayList;

public class UserCommandNode extends CommandNode {
   private CommandRoot root;
   private ArrayList<CommandNode> parameters;
   private String name;

   public UserCommandNode(CommandHandlerInterface inHandler){
      super(inHandler);
   }

   public UserCommandNode(CommandHandlerInterface inHandler, CommandNode inParent, String s){
      super(inHandler, inParent);
      this.name = s;
      this.getCommand();
   }

   private void getCommand(){
      this.myHandler.
   }

   public void execute(){
      this.parseParameters();
      this.setMyReturnValue(this.getMyValue());
   }

   public String getMyStringValue(){
      return this.myStringValue;
   }

   protected void parseParameters(){
      for(CommandNode c: this.getMyChildren()){
         if(!(c instanceof RightBracketNode) && !(c instanceof LeftBracketNode)) {
            this.parameters.add(c);
         }
      }
   }
}
