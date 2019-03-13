package View.GUIFeatures.Panes;

import javafx.beans.property.SimpleStringProperty;

/**
 * @author Hsingchih Tang
 * Structure designed to store historical commands that have been entered by user
 * and to interact with JavaFX TableView feature
 */
public class HistoricalCommand {

    private SimpleStringProperty myContent;

    /**
     * Instantiates a HistoricalCommand object
     * @param s the String content of the command
     */
    public HistoricalCommand(String s){
        myContent = new SimpleStringProperty(s);
    }

    /**
     * Getter method for interacting with JavaFX TableView
     * @return the command in String format held by this HistoricalCommand object
     */
    public String getMyContent() {
        return myContent.get();
    }
}
