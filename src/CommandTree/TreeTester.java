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
      String command = "lessthan 19 10";
      var parser = new StringParser();
      //var temp = parser.parseCommand(command);
      String[] temp = {"makevariable", "cool", "5", "forward", ":cool"};
      TurtleModel model = new TurtleModel();
      VariablePaneModel varModel = new VariablePaneModel();
      CommandHandler handler = new CommandHandler(model, varModel);
      CommandRoot root = new CommandRoot(temp, handler);
      root.execute();
   }


}
