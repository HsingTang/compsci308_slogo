package View.GUIFeatures.Panes;

import Model.ModelInterfaces.IModel;
import View.ObserverInterfaces.IObserver;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hsingchih Tang
 * @author Eric Lin
 */
public class Console extends TextArea implements IObserver {

    public static final String PROMPT_TEXT = "Enter Commands Here";
    private IModel myValModel;
    private List<String> myDisplay;

    public Console(double w, double h) {
        this.setMaxSize(w,h);
        this.setPromptText(PROMPT_TEXT);
        this.setFocusTraversable(false);
        this.setWrapText(true);
        this.getStyleClass().add("console-text-area");
        myDisplay = new ArrayList<>();
    }

    public void clearText() {
        this.clear();
    }

    public String getTextClear() {
        String text = this.getText();
        this.clearText();
        return text;
    }

    @Override
    public void updateData() {
        myDisplay = myValModel.getData();
        this.setText(myDisplay.get(0));
    }

    @Override
    public void setupModel(IModel model) {
        myValModel = model;
        myValModel.registerObserver(this);
    }

    @Override
    public IModel getModel() {
        return myValModel;
    }
}
