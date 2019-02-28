package View.GUIFeatures.Panels;

import Model.Model;
import javafx.scene.control.TextArea;
import java.util.List;

public class Console extends TextArea {

    public static final String PROMPT_TEXT = "Enter Commands Here";
    private String myDisplay;
    private Model myMathModel;

    private List<String> myCommands;

    public Console(double w, double h) {
        this.setMaxSize(w,h);
        this.setPromptText(PROMPT_TEXT);
        this.setFocusTraversable(false);
        this.setWrapText(true);
        this.getStyleClass().add("console-text-area");
    }

    public void clearText() {
        this.clear();
    }


    public void updateDisplay(){

    }

    public void setMathModel(Model m){
        myMathModel = m;
    }

    private void displayText(){
        this.setText(myDisplay);
    }

    public String getTextClear() {
        String text = this.getText();
        this.clearText();
        return text;
    }

}
