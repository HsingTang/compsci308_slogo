package CommandTree;

public class TreeTester {

   public static void main(String[] args){
      String s = "forward 5 repeat 3 [ forward 2 forward 3 repeat 2 [ forward 5 ] ] forward 2";
      StringParser parse = new StringParser(s);
      CommandRoot root = new CommandRoot(parse.getCommandStrings());
      CommandTreeController control = new CommandTreeController(root);
      control.execute(root.getParent());
   }
}
