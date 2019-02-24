package CommandTree;

public class TurtleCommandNode extends CommandNode{
   private int value;

   public TurtleCommandNode(int val){
      super();
      this.setType("turtle");
      this.value = val;
   }

   public int getValue(){
      return this.value;
   }
}
