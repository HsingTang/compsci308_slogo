package CommandTree;

import java.util.ArrayList;

public class TurtleCommandNode extends CommandNode{
   private int value;
   private ArrayList<Double> parameters;

   public TurtleCommandNode(int val){
      super();
      this.setType("turtle");
      this.value = val;
      this.parameters = new ArrayList<>();
   }

   public int getValue(){
      return this.value;
   }

   public ArrayList<Double> getParameters(){
      return this.parameters;
   }

}
