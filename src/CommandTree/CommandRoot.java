package CommandTree;

import CommandNodes.CommandNode;
import CommandNodes.RepeatNode;
import CommandNodes.TreeParentNode;
import Controller.ControllerInterfaces.CommandControllerInterface;

public class CommandRoot {
   private static int INIT = 0;

   private CommandNodeFactory myCommandNodeFactory;

   private String[] commandStrings;
   private int numCommands;

   private CommandControllerInterface myController;
   private CommandNode parent;
   private CommandNode currentParent;
   private int currentIndex;
   private String currentString;

   public CommandRoot(String[] commandStrings, CommandControllerInterface controller) {
      this.commandStrings = commandStrings;
      this.numCommands = commandStrings.length;
      this.myController = controller;
      this.parent = new TreeParentNode(this.myController);
      this.currentParent = this.parent;
      this.currentIndex = INIT;
      this.myCommandNodeFactory = new CommandNodeFactory(this.myController);
      this.makeTree();
   }

   private void makeTree() {
      while (this.currentIndex < this.numCommands) {
         this.currentString = this.commandStrings[this.currentIndex];
         CommandNode newNode = this.myCommandNodeFactory.newNode(this.currentString, this.currentParent, this);
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

   public void executeNode(CommandNode parent){
      for(CommandNode c: parent.getMyChildren()){
         this.executeNode(c);
      }
      parent.fullExecute();
      if(parent instanceof RepeatNode){
         this.executeLoopNode((RepeatNode)(parent));
      }
      }

      private void executeLoopNode(RepeatNode parent){
         for(int i = 1; i < parent.getNumRepeat(); i++) {
            for (CommandNode c : parent.getMyChildren()) {
               this.executeNode(c);
            }
         }
      }


}