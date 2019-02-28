package CommandTree;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class StringParser {
   private static String WHITESPACE_TRIM = "\\s+";
   private List<Entry<String, Pattern>> mySymbols;
   private List<String> myFilter = new ArrayList<>();

   public StringParser(){
      mySymbols = new ArrayList<>();
      var syntax = ResourceBundle.getBundle("languages/Syntax");
      for (var key : Collections.list(syntax.getKeys())){
         myFilter.add(key);
      }
   }

   /**
    * Adds the given resource file to this language's recognized types
    */
   public void addPatterns (String syntax) {
      var resources = ResourceBundle.getBundle(syntax);
      for (var key : Collections.list(resources.getKeys())) {
         var regex = resources.getString(key);
         mySymbols.add(new SimpleEntry<>(key, Pattern.compile(regex, Pattern.CASE_INSENSITIVE)));
      }
   }

   public String[] parseCommand(String command){
      var commandWords = command.split(WHITESPACE_TRIM);
      int size = 0;
      for(var s : commandWords){
         if(getSymbol(s).equals("Comment")){
            break;
         }
         size++;
      }
      var parsedCommand = new String[size];
      for(int i = 0; i < size; i++){

         if(!myFilter.contains(getSymbol(commandWords[i]))){
            parsedCommand[i] = getSymbol(commandWords[i]).toLowerCase();

         }else {
            parsedCommand[i] = commandWords[i];

         }
      }
      return parsedCommand;
   }

   /**
    * Returns language's type associated with the given text if one exists
    */
   public String getSymbol (String text) {
      final var ERROR = "NO MATCH";
      for (var e : mySymbols) {
         if (match(text, e.getValue())) {
            return e.getKey();
         }
      }
      // FIXME: perhaps throw an exception instead
      return ERROR;
   }

   /**
    * Returns true if the given text matches the given regular expression pattern
    */
   private boolean match (String text, Pattern regex) {
      return regex.matcher(text).matches();
   }

}
