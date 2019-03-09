package View.GUIFeatures.Panes;

import javafx.beans.property.SimpleStringProperty;

/**
 * @author Hsingchih Tang
 */
public class HistoricalCommand {

    private SimpleStringProperty myContent;

    public HistoricalCommand(String s){
        myContent = new SimpleStringProperty(s);
    }

    public String getMyContent() {
        return myContent.get();
    }
}
