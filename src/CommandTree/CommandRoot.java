package CommandTree;

import CommandNodes.CommandNode;
import CommandNodes.MakecommandNode;
import CommandNodes.TreeParentNode;
import CommandNodes.UserCommandNode;
import Handlers.HandlerInterfaces.CommandHandlerInterface;
import View.ObserverInterfaces.TurtleObserver;
import View.Turtles.TurtleView;

public class CommandRoot {
   private static final int INIT = 0;

   private final CommandNodeFactory myCommandNodeFactory;

   private final String[] commandStrings;
   private final int numCommands;

   private final CommandHandlerInterface myHandler;
   private final CommandNode parent;
   private CommandNode currentParent;
   private int currentIndex;


   public CommandRoot(String[] commandStrings, CommandHandlerInterface controller, TurtleObserver o) {
      this.commandStrings = commandStrings;
      this.numCommands = commandStrings.length;
      this.myHandler = controller;
      this.parent = new TreeParentNode(this.myHandler, o);
      this.currentParent = this.parent;
      this.currentIndex = INIT;
      this.myCommandNodeFactory = new CommandNodeFactory(this.myHandler);
      this.makeTree();
   }

   private void makeTree() {
      while (this.currentIndex < this.numCommands) {
         String currentString = this.commandStrings[this.currentIndex];
         myHandler.addToHistory(currentString);
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
            System.out.println(c);
         }
      }
      parent.fullExecute();
      if(parent instanceof UserCommandNode){
         this.runUserCommand((UserCommandNode)parent);
      }
   }

   private void runUserCommand(UserCommandNode parent){
      for(CommandNode executeChild: parent.getExecuteChildren()){
         this.executeNode(executeChild);
      }
   }

}