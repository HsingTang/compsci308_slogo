package CommandTree;

import Handlers.CommandHandler;
import Handlers.HandlerInterfaces.CommandHandlerInterface;
import Model.TurtleModel;
import Model.ModelInterfaces.ModelInterface;

public class TreeTester {

   public static void main(String[] args){
      String commands = "forward 5 repeat 3 [ forward forward 10 repeat 3 [ left 2 ] ] backward 1";
      StringParser parser = new StringParser();
      parser.addPatterns("languages/English");
      parser.addPatterns("languages/Syntax");
      //CommandRoot root = new CommandRoot(commands, control);
      ModelInterface model = new TurtleModel();
      CommandHandlerInterface handler = new CommandHandler(model);
      CommandRoot root = new CommandRoot(parser.parseCommand(commands), handler);
      root.execute();
   }


}
