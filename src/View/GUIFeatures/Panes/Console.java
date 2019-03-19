package View.GUIFeatures.Panes;

import Model.ModelInterfaces.IModel;
import View.ObserverInterfaces.IObserver;
import javafx.scene.control.TextArea;


/**
 * @author Hsingchih Tang
 * @author Eric Lin
 * Console for reading in user commands
 */
public class Console extends TextArea implements IObserver {

    public static final String PROMPT_TEXT = "Enter Commands Here";
    private IModel myValModel;

    /**
     * Instantiates an instance of the console
     * @param w width of console
     * @param h height of console
     */
    public Console(double w, double h) {
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
     * Sets up the Console's corresponding back-end Model
     * @param model the Model component to be associated to this Console
     */
    @Override
    public void setupModel(IModel model) {
        myValModel = model;
        myValModel.registerObserverData(this);
    }

    /**
     * @return the Console's corresponding back-end Model
     */
    @Override
    public IModel getModel() {
        return myValModel;
    }
}
