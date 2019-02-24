package CommandTree;

public class StringParser {
   private static String WHITESPACE_TRIM = "\\s+";

   private String commandString;
   private String[] commandStrings;

   public StringParser(String s){
      this.commandString = s;
      commandStrings = this.commandString.split(WHITESPACE_TRIM);
   }

   public String[] getCommandStrings(){
      return this.commandStrings;
   }
}
