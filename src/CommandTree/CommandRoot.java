package CommandTree;

import CommandNodes.CommandNode;
import CommandNodes.TreeParentNode;
import CommandNodes.UserCommandNode;
import Errors.SlogoException;
import Handlers.HandlerInterfaces.CommandHandlerInterface;
import View.ObserverInterfaces.TurtleObserver;

public class CommandRoot {
   private static final int INIT = 0;

   private final CommandNodeFactory myCommandNodeFactory;

   private final String[] commandStrings;
   private final int numCommands;

   private final CommandHandlerInterface myHandler;
   private final CommandNode parent;
   private CommandNode currentParent;
   private int currentIndex;


   public CommandRoot(String[] commandStrings, CommandHandlerInterface controller, TurtleObserver o) throws SlogoException {
      try{
         this.commandStrings = commandStrings;
         this.numCommands = commandStrings.length;
         this.myHandler = controller;
         this.parent = new TreeParentNode(this.myHandler, o);
         this.currentParent = this.parent;
         this.currentIndex = INIT;
         this.myCommandNodeFactory = new CommandNodeFactory(this.myHandler);
         this.makeTree();
      }catch (SlogoException e){
         throw e;
      }

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
      try{
         this.executeNode(this.parent);
      }catch (SlogoException e){
         throw e;
      }

   }

   private void executeNode(CommandNode parent) throws SlogoException{
      for (CommandNode c : parent.getMyChildren()) {
         for(int i = 0; i < c.getMyNumRepeat(); i++) {
            try{
               this.executeNode(c);
            }catch (SlogoException e){
               throw e;
            }
         }
      }
      try{
         parent.fullExecute();
         if(parent instanceof UserCommandNode){
            this.runUserCommand((UserCommandNode)parent);
         }
      }catch (SlogoException e){
         throw e;
      }
      if(parent.getMyReturnValue()!=null){
         this.myHandler.addReturnVal(Double.toString(parent.getMyReturnValue()));
      }

   }

   private void runUserCommand(UserCommandNode parent){
      for(CommandNode executeChild: parent.getExecuteChildren()){
         this.executeNode(executeChild);
      }
   }

}