package CommandTree;

import CommandNodes.CommandNode;
import CommandNodes.TurtleCommandNodes.TurtleCommandNode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CommandRoot {
   private static String END_EXPRESSION = "]";
   private static String START_EXPRESSION = "[";
   private static String LOOP_EXPRESSION = "repeat";
   private static String EXPRESSION_MAP_FILE = "/resources/expressionToString.txt";
   private static String MAP_SPLIT = ":";
   private static int MAP_LIMIT = 2;
   private static String NODE_BUILDER = "Node";


   private CommandNode parent;

   private CommandNode current;
   private int currentIndex;
   private String currentString;
   private String currentNodeString;

   private HashMap<String, String> expressionStringMap;

   private String[] commandStrings;
   private int numCommands;

   public CommandRoot(String[] commandStrings){
      this.commandStrings = commandStrings;
      this.numCommands = commandStrings.length;
      this.current = this.parent;
      this.currentIndex = 0;
      this.setExpressionMap();
      this.makeTree();
   }

   private void makeTree(){
      this.currentString = this.commandStrings[this.currentIndex];
      this.setCurrentNodeString();

   }

   private void setExpressionMap(){
      HashMap<String, String> map = new HashMap<>();
      try{
         String line;
         BufferedReader reader = new BufferedReader(new FileReader(EXPRESSION_MAP_FILE));
         while((line = reader.readLine()) != null){
            String[] parts = line.split(MAP_SPLIT, MAP_LIMIT);
            String key = parts[0];
            String value = parts[1];
            map.put(key, value);
         }
         reader.close();
         this.expressionStringMap = map;
      }
      catch(Exception e){
         /**
          * Error about internal expression file not found
          */
      }
   }

   private void setCurrentNodeString(){
      StringBuilder nodeString = new StringBuilder();
      if(this.expressionStringMap.containsKey(this.currentString)){
         nodeString.append(this.expressionStringMap.get(this.currentString));
      }
      else{
         nodeString.append(this.currentString.substring(0,1).toUpperCase()).append(this.currentString.substring(1).toLowerCase());
      }
      nodeString.append(NODE_BUILDER);
      this.currentNodeString = nodeString.toString();
   }
}