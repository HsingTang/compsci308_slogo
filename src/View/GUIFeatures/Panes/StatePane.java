package View.GUIFeatures.Panes;

import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 * @author Hsingchih Tang
 */
public class StatePane extends GridPane {
    static final Integer TURTLE_LABEL_COL = 0;
    static final Integer TURTLE_VAL_COL = 1;
    static final Integer PEN_LABEL_COL = 2;
    static final Integer PEN_VAL_COL = 3;
    static final Double H_GAP = 20.0;


    public StatePane(){
        super();
        this.setHgap(H_GAP);
    }

    public void addTurtleLabel(Text[] labels){
        for (int i = 0; i < labels.length; i++) {
            this.add(labels[i], TURTLE_LABEL_COL, i);
        }
    }

    public void addTurtleState(Text[] states){
        for (int i = 0; i < states.length; i++) {
            this.add(states[i], TURTLE_VAL_COL, i);
        }
    }

    public void addPenLabel(Text[] labels){
        for (int i = 0; i < labels.length; i++) {
            this.add(labels[i], PEN_LABEL_COL, i);
        }
    }

    public void addPenState(Text[] states){
        for (int i = 0; i < states.length; i++) {
            this.add(states[i], PEN_VAL_COL, i);
        }
    }

}
