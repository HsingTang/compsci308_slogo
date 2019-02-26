package CommandTree;

import CommandNodes.CommandNode;
import CommandNodes.ConstantNode;
import Controller.ControllerInterfaces.CommandControllerInterface;

import java.lang.reflect.Constructor;

public class CommandNodeFactory {

   private static CommandControllerInterface myController;

   public CommandNodeFactory(CommandControllerInterface controller){
      this.myController = controller;
   }

   public static CommandNode getNode(String nodeString, CommandNode parent){
      try{
         Class<?> cl = Class.forName(nodeString);
         Constructor<?> cons = cl.getConstructor(CommandControllerInterface.class, CommandNode.class);
         return (CommandNode)(cons.newInstance(nodeString, parent));
      }
      catch(Exception e){
         /**
          * Error regarding incorrect nodeString name
          */
         return null;
      }
   }

   /*public static ConstantNode getConstantNode(CommandNode parent, String stringValue){
      try
   }*/
}
