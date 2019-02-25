package CommandTree;

import java.util.ArrayList;

public class TurtleCommandNode extends CommandNode{
   private ArrayList<Double> parsedParameters;

   public TurtleCommandNode(String type){
      super();
      this.setType(type);
      this.parsedParameters = new ArrayList<>();
   }
   public ArrayList<Double> getParsedParameters(){
      for(String s: this.getParameters()){
         parsedParameters.add(Double.parseDouble(s));
      }
      return parsedParameters;
   }

}
