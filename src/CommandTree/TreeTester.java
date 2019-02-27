package CommandTree;

import Controller.ControllerInterfaces.CommandControllerInterface;

public class TreeTester {

   public static void main(String[] args){
      String[] commands = {"forward", "5", "repeat", "5", "[", "forward", "2", "forward", "3", "repeat", "2", "[", "left", "5", "]", "]", "backward", "2"};
      //CommandControllerInterface control = new Controller();
      //CommandRoot root = new CommandRoot(commands, control);
      /*MainModel model = new MainModel();
      model.setCurrentRoot(root);
      model.execute();*/
      //root.execute();
   }


}
