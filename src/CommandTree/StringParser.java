package CommandTree;

import Errors.InvalidCommandException;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

/**
 * This class takes in a command from a user as a string and then converts that string into usable information for other
 * classes to create the command nodes. The StringParser is created by the controller class.
 *
 * @author Duc Tran
 * @author Robert Duval
 */
public class StringParser {
   private static String WHITESPACE_TRIM = "\\s+";
   private List<Entry<String, Pattern>> mySymbols;
   private List<String> myFilter = new ArrayList<>();

   /**
    * The constructor reads in a list of strings that should be dealt with differently if encountered. Also sets
    * the initial language to English.
    */
   public StringParser(){
      mySymbols = new ArrayList<>();
      var filterList = ResourceBundle.getBundle("languages/Filter");
      for (var key : Collections.list(filterList.getKeys())){
         myFilter.add(key);
      }
      setLanguage("English");
   }

   /**
    * Adds the given resource file to this language's recognized types
    */
   private void addPatterns (String syntax) {
      var resources = ResourceBundle.getBundle(syntax);
      for (var key : Collections.list(resources.getKeys())) {
         var regex = resources.getString(key);
         mySymbols.add(0, new SimpleEntry<>(key, Pattern.compile(regex, Pattern.CASE_INSENSITIVE)));
      }
   }

   /**
    * Takes in a language and sets the StringParser's understood language to the new language.
    *
    * @param language The language that the StringParser will be set too.
    */
   public void setLanguage(String language){
      mySymbols.clear();
      addPatterns("languages/Syntax");
      addPatterns("languages/" + language);
   }

   /**
    * Takes in the user's command and then using the set language, translates the command into an array of string that
    * the command tree class can use.
    *
    * @param command The command that the user inputs.
    *
    * @return An array of strings with that the command tree class will use. Throws an error if a command is not correct.
    */
   public String[] parseCommand(String command){
      if(command.indexOf("#")!=-1) {
         command = command.substring(0, command.indexOf("#"));
      }
      var commandWords = command.split(WHITESPACE_TRIM);
      var parsedCommand = new String[commandWords.length];
      for(int i = 0; i < commandWords.length; i++){
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
   private String getSymbol (String text) {
      for (var e : mySymbols) {
         if (match(text, e.getValue())) {
            return e.getKey();
         }
      }
      throw new InvalidCommandException();
   }

   /**
    * Returns true if the given text matches the given regular expression pattern
    */
   private boolean match (String text, Pattern regex) {
      return regex.matcher(text).matches();
   }

}
