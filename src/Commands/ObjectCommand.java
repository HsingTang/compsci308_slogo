package Commands;

import java.util.List;

public class ObjectCommand extends Command {
   int changeSteps;
   public ObjectCommand(ObjectCommandTypes type, int steps){
      super("");
   }
   private void forward(int steps){
      this.changeSteps = steps;
   }

   private void backward(int steps){
      this.changeSteps = -steps;
   }
}
