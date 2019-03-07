package CommandTree;

public class TreeTester {

   public static void printArray(String[] strings){
      for(var s : strings){
         System.out.println(s);
      }
      System.out.println("=========");
   }

   public static void main(String[] args){
      StringParser parse1 = new StringParser();
      StringParser parse2 = new TestParser();
      TestParser parse3 = new TestParser();
      System.out.println(parse1.getClass().getName());
      System.out.println(parse2.getClass().getName());
      System.out.println(parse3.getClass().getName());
   }


}
