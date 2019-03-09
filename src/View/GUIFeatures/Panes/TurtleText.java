package View.GUIFeatures.Panes;

import View.Turtles.TurtleView;
import javafx.scene.text.Text;

import java.util.List;

public class TurtleText {

    static final Text xPosLabel = new Text("X Position: ");
    static final Text yPosLabel = new Text("Y Position: ");
    static final Text headingLabel = new Text("Heading: ");
    static final Text IDLabel = new Text("Turtle ID: ");
    static final String DEFAULT_INIT_POS = "0.0";
    static final String INVALID_INIT_POS = "-0.0";
    static final String DEFAULT_INIT_HEADING = "90.0";
    static final Integer XPOS_INDEX = 0;
    static final Integer YPOS_INDEX = 1;
    static final Integer HEADING_INDEX = 2;

    private Text xPos;
    private Text yPos;
    private Text heading;
    private Text ID;
    private TurtleView turtle;
    private List<Text> myText;

    public TurtleText(TurtleView turtle) {
        this.turtle = turtle;
        xPos = new Text(DEFAULT_INIT_POS);
        yPos = new Text(DEFAULT_INIT_POS);
        heading = new Text(DEFAULT_INIT_HEADING);
        ID = new Text(turtle.getMyID().toString());
    }

    public Text[] getStateLabels() {
        return new Text[] {xPosLabel, yPosLabel, headingLabel, IDLabel};
    }

    public Text[] getStates() {
        return new Text[] {xPos, yPos, heading, ID};
    }

    public void setStateValues(Double[] states) {
        xPos.setText(states[XPOS_INDEX].toString().equals(INVALID_INIT_POS)?DEFAULT_INIT_POS:states[XPOS_INDEX].toString());
        yPos.setText(states[YPOS_INDEX].toString().equals(INVALID_INIT_POS)?DEFAULT_INIT_POS:states[YPOS_INDEX].toString());
        heading.setText(states[HEADING_INDEX].toString());
    }

}
