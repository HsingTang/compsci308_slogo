package CommandTree;

import Handlers.CommandHandler;
import Handlers.HandlerInterfaces.CommandHandlerInterface;
import Model.TurtleModel;
import Model.ModelInterfaces.ModelInterface;

public class TreeTester {

   public static void main(String[] args){
      String[] commands = {"forward", "forward", "5"};

      //CommandRoot root = new CommandRoot(commands, control);
      ModelInterface model = new TurtleModel();
      CommandHandlerInterface handler = new CommandHandler(model);
      CommandRoot root = new CommandRoot(commands, handler);
      root.execute();
   }


}
