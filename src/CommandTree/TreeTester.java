package CommandTree;

import Handlers.CommandHandler;
import Model.TurtleModel;
import Model.VariablePaneModel;

public class TreeTester {

   public static void printArray(String[] strings){
      for(var s : strings){
         System.out.println(s);
      }
      System.out.println("=========");
   }

   public static void main(String[] args){
      String test = "0.500000000";
      System.out.println(test.substring(3,4));
   }

}
