package CommandTree;

public class TreeTester {

   public static void printArray(String[] strings){
      for(var s : strings){
         System.out.println(s);
      }
      System.out.println("=========");
   }

   public static void main(String[] args){
      String command = "fd 50 dfasdf qj 50";
      var parser = new StringParser();
      var temp = parser.parseCommand(command);
      printArray(temp);
   }


}
