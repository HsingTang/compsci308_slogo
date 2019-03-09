package View.GUIFeatures.Panes;

import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class TurtleStatePane extends GridPane {
    static final Integer LABEL_COL = 0;
    static final Integer VALUE_COL = 1;

    public TurtleStatePane(){
        super();
    }

    public void addLabel(Text[] labels){
        for (int i = 0; i < labels.length; i++) {
            this.add(labels[i], LABEL_COL, i);
        }
    }

    public void addState(Text[] states){
        for (int i = 0; i < states.length; i++) {
            this.add(states[i], VALUE_COL, i);
        }
    }

}
