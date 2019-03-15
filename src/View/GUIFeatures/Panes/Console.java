package View.GUIFeatures.Panes;

import Model.ModelInterfaces.IModel;
import View.ObserverInterfaces.IObserver;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hsingchih Tang
 * @author Eric Lin
 * Console for reading in user commands
 */
public class Console extends TextArea implements IObserver {

    public static final String PROMPT_TEXT = "Enter Commands Here";
    private IModel myValModel;
    private List<String> myDisplay;

    /**
     * Instantiates an instance of the console
     * @param w width of console
     * @param h height of console
     */
    public Console(double w, double h) {
        myDisplay = new ArrayList<>();
        this.setMaxSize(w,h);
        this.setPromptText(PROMPT_TEXT);
        this.setFocusTraversable(false);
        this.setWrapText(true);
        this.getStyleClass().add("console-text-area");
        this.setOnMouseClicked(e->clearText());
    }

    /**
     * Clears the text displayed in the Console's text area
     */
    public void clearText() {
        this.clear();
    }

    /**
     * Retrieves a command's execution result from the Console's ReturnValModel
     * and displays the result in Console's text area
     */
    @Override
    public void updateData() {
//        System.out.println("console gets notified");
        myDisplay = myValModel.getData();
        this.setText(myDisplay.get(0));
//        System.out.println(myDisplay.get(0));

    }

    /**
     * Sets up the Console's corresponding back-end Model
     * @param model the Model component to be associated to this Console
     */
    @Override
    public void setupModel(IModel model) {
        myValModel = model;
        myValModel.registerObserver(this);
    }

    /**
     * @return the Console's corresponding back-end Model
     */
    @Override
    public IModel getModel() {
        return myValModel;
    }
}
