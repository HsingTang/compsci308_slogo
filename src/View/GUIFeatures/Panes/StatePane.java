package View.GUIFeatures.Panes;

import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 * @author Hsingchih Tang
 * The Pane designed for displaying TurtleView's current position, heading and pen states
 * Resides in the TopPane. There should be one StatePane per TurtleView (i.e. per tab).
 */
public class StatePane extends GridPane {
    static final Integer TURTLE_LABEL_COL = 0;
    static final Integer TURTLE_VAL_COL = 1;
    static final Integer PEN_LABEL_COL = 2;
    static final Integer PEN_VAL_COL = 3;
    static final Double H_GAP = 20.0;

    /**
     * Instantiates a new instance of StatePane.
     */
    public StatePane(){
        super();
        this.setHgap(H_GAP);
    }

    /**
     * set up the layout for labels of TurtleView states
     * @param labels an array of TurtleView state labels
     */
    public void addTurtleLabel(Text[] labels){
        for (int i = 0; i < labels.length; i++) {
            this.add(labels[i], TURTLE_LABEL_COL, i);
        }
    }

    /**
     * set up the layout for values of TurtleView states
     * @param states an array of TurtleView state values
     */
    public void addTurtleState(Text[] states){
        for (int i = 0; i < states.length; i++) {
            this.add(states[i], TURTLE_VAL_COL, i);
        }
    }

    /**
     * set up the layout for labels of pen states
     * @param labels an array of pen state labels
     */
    public void addPenLabel(Text[] labels){
        for (int i = 0; i < labels.length; i++) {
            this.add(labels[i], PEN_LABEL_COL, i);
        }
    }

    /**
     * set up the layout for values of pen states
     * @param states an array of pen state values
     */
    public void addPenState(Text[] states){
        for (int i = 0; i < states.length; i++) {
            this.add(states[i], PEN_VAL_COL, i);
        }
    }

}
