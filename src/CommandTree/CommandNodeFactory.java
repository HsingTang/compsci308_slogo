package CommandTree;

import CommandNodes.CommandNode;
import CommandNodes.ConstantNode;
import Controller.ControllerInterfaces.CommandControllerInterface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.util.HashMap;

public class CommandNodeFactory {
   private static String EXPRESSION_MAP_FILE = "/resources/expressionToString.txt";
   private static String MAP_SPLIT = ":";
   private static int MAP_LIMIT = 2;
   private static String NODE_BUILDER = "Node";

   private CommandControllerInterface myController;
   private HashMap<String, String> expressionStringMap;

   public CommandNodeFactory(CommandControllerInterface controller) {
      this.myController = controller;
      this.setExpressionMap();
   }

   public CommandNode newNode(String arrayString, CommandNode parent) {
      StringBuilder nodeString = new StringBuilder();

      if (this.expressionStringMap.containsKey(arrayString)) {
         nodeString.append(this.expressionStringMap.get(arrayString)).append(NODE_BUILDER);
         return this.newNode(nodeString.toString(), parent);
      } else {
         try {
            Double constant = Double.parseDouble(arrayString);
            return this.newConstantNode(parent, constant);
         } catch (NumberFormatException e) {
            nodeString.append(arrayString.substring(0, 1).toUpperCase()).append(arrayString.substring(1).toLowerCase()).append(NODE_BUILDER);
            return this.newNode(nodeString.toString(), parent);
         }
      }
   }

   private CommandNode newNode(Class<?> nodeClass, CommandNode parent){
      try{
         Constructor<?> cons = nodeClass.getConstructor(CommandControllerInterface.class, CommandNode.class);
         return (CommandNode)(cons.newInstance(myController, parent));
      }
      catch(Exception e){
         /**
          * Error regarding no such command
          */
         return null;
      }
   }
   private ConstantNode newConstantNode(CommandNode parent, Double value){
      return new ConstantNode(myController, parent, value);
   }

   private void setExpressionMap(){
      HashMap<String, String> map = new HashMap<>();
      try {
         String line;
         BufferedReader reader = new BufferedReader(new FileReader(EXPRESSION_MAP_FILE));
         while ((line = reader.readLine()) != null) {
            String[] parts = line.split(MAP_SPLIT, MAP_LIMIT);
            String key = parts[0];
            String value = parts[1];
            map.put(key, value);
         }
         reader.close();
         this.expressionStringMap = map;
      } catch (Exception e) {
         /**
          * Error about internal expression file not found
          */
      }
   }
}
