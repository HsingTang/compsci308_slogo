package View.GUIFeatures.Panes;

import View.Turtles.TurtleView;
import javafx.scene.text.Text;

public class TurtleText {

    private Text xPosLabel;
    private Text yPosLabel;
    private Text headingLabel;
    private Text IDLabel;
    private Text xPos;
    private Text yPos;
    private Text heading;
    private Text ID;
    private TurtleView turtle;

    public TurtleText(TurtleView turtle) {
        this.turtle = turtle;
        xPosLabel = new Text("X Position: ");
        yPosLabel = new Text("Y Position: ");
        headingLabel = new Text("Heading: ");
        IDLabel = new Text("ID: ");
        xPos = new Text("0.0");
        yPos = new Text("0.0");
        heading = new Text("90.0");
        ID = new Text(turtle.getMyID().toString());
    }

    public Text[] getStateLabels() {
        return new Text[] {xPosLabel, yPosLabel, headingLabel, IDLabel};
    }

    public Text[] getStates() {
        return new Text[] {xPos, yPos, heading, ID};
    }

    public void setStateValues(Double[] states) {
        xPos.setText(states[0].toString());
        yPos.setText(states[1].toString());
        heading.setText(states[2].toString());
        System.out.println(xPos);
        System.out.println(yPos);
        System.out.println(heading);
    }

}
