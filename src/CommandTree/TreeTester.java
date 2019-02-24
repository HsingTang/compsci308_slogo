package CommandTree;

import Model.Model;

public class TreeTester {

   public static void main(String[] args){
      String s = "forward 5 repeat 3 [ forward 2 forward 3 repeat 2 [ forward 5 ] ] forward 2";
      //var parse = new StringParser();
      //parse.addPatterns("languages/English");
      //parse.parseCommand("a b c d e #c dd");
      String[] commands = {"forward", "5", "repeat", "3", "[", "forward", "2", "forward", "3", "repeat", "2", "[", "forward", "5", "]", "]", "forward", "2"};
      CommandRoot root = new CommandRoot(commands);
      Model model = new Model();
      model.setCurrentRoot(root);
      model.execute();
      //CommandTreeController control = new CommandTreeController(root);
      //control.execute(root.getParent());
   }
}
