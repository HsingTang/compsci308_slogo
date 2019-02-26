package CommandTree;

import Model.MainModel;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class TreeTester {

   public static void main(String[] args){
      String s = "forward 5 repeat 3 [ forward 2 forward 3 repeat 2 [ forward 5 ] ] forward 2";
      var parse = new StringParser();
      parse.addPatterns("languages/French");
      parse.addPatterns("languages/Syntax");
      var temp = parse.parseCommand("dev 50 der 40 :var [ gc 45 ] #c");
      for(var e : temp){
         System.out.println(e);
      }
      String[] commands = {"forward", "5", "repeat", "3", "[", "forward", "2", "forward", "3", "repeat", "2", "[", "forward", "5", "]", "]", "forward", "2"};
      CommandRoot root = new CommandRoot(commands);
      MainModel model = new MainModel();
      model.setCurrentRoot(root);
      model.execute();
   }


}
