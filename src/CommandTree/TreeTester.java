package CommandTree;

public class TreeTester {

   public static void main(String[] args){
<<<<<<< HEAD
      String commands = "dev 5 repeat 3 [ dev dev 10 repeat 3 [ gc 2 ] ] der 1";
      StringParser parser = new StringParser();
      parser.addPatterns("languages/French");
      parser.addPatterns("languages/Syntax");
      //CommandRoot root = new CommandRoot(commands, control);
      ModelInterface model = new TurtleModel();
      CommandHandlerInterface handler = new CommandHandler(model);
      CommandRoot root = new CommandRoot(parser.parseCommand(commands), handler);
      root.execute();
=======

>>>>>>> 0ca4dcd3b0c3b6ffeef60ea5712080ebdb918158
   }


}
