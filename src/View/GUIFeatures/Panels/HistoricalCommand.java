package View.GUIFeatures.Panels;

import javafx.beans.property.SimpleStringProperty;

public class HistoricalCommand {

    private SimpleStringProperty myContent;

    public HistoricalCommand(String s){
        myContent = new SimpleStringProperty(s);
    }

    public String getMyContent() {
        return myContent.get();
    }
}
