package CommandTree;

import CommandNodes.CommandNode;
import CommandNodes.TreeParentNode;
import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class CommandRoot {
   private static final int INIT = 0;

   private final CommandNodeFactory myCommandNodeFactory;

   private final String[] commandStrings;
   private final int numCommands;

   private final CommandHandlerInterface myHandler;
   private final CommandNode parent;
   private CommandNode currentParent;
   private int currentIndex;

   public CommandRoot(String[] commandStrings, CommandHandlerInterface controller) {
      this.commandStrings = commandStrings;
      this.numCommands = commandStrings.length;
      this.myHandler = controller;
      this.parent = new TreeParentNode(this.myHandler);
      this.currentParent = this.parent;
      this.currentIndex = INIT;
      this.myCommandNodeFactory = new CommandNodeFactory(this.myHandler);
      this.makeTree();
   }

   private void makeTree() {
      while (this.currentIndex < this.numCommands) {
         String currentString = this.commandStrings[this.currentIndex];
         CommandNode newNode = this.myCommandNodeFactory.newNode(currentString, this.currentParent, this);
         while(this.currentParent.childrenFilled()){
            this.currentParent = this.currentParent.getParent();
         }
         this.currentParent.addChild(newNode);
         this.currentParent = newNode;
         this.currentIndex++;
      }
   }

   public void execute(){
      this.executeNode(this.parent);
   }

   private void executeNode(CommandNode parent) {
      for (CommandNode c : parent.getMyChildren()) {
         for(int i = 0; i < c.getMyNumRepeat(); i++) {
            this.executeNode(c);
         }
      }
      parent.fullExecute();
   }

}