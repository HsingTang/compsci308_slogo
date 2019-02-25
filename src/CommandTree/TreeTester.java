package CommandTree;

public class TreeTester {

   public static void main(String[] args){
      String s = "forward 5 repeat 3 [ forward 2 forward 3 repeat 2 [ forward 5 ] ] forward 2";
      var parse = new StringParser();
      parse.addPatterns("languages/English");
      parse.addPatterns("languages/Syntax");
      var temp = parse.parseCommand("fd 90 devant 40 :dog ase #c dd");
      for(var q : temp){
         System.out.println(q);
      }
      //CommandRoot root = new CommandRoot(parse.getCommandStrings());
      //CommandTreeController control = new CommandTreeController(root);
      //control.execute(root.getParent());
   }
}
