package CommandTree;

public class LoopNode extends CommandNode{
   private int numTimes;

   public LoopNode(int num){
      super();
      this.numTimes = num;
      this.setType("loop");
   }

   public int getNumTimes(){
      return this.numTimes;
   }
}
