package CommandTree;

public class LoopNode extends CommandNode{
   private int numTimes;

   public LoopNode(String type){
      super();
      this.setType(type);
   }

   public int getNumTimes(){
      return this.numTimes;
   }

   public void parseParameters(){
      this.numTimes = Integer.parseInt(this.getParameters().get(0));
   }
}
