package View.GUIFeatures.Panes;

import View.Turtles.TurtleView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.text.DecimalFormat;

/**
 * @author Hsingchih Tang
 * @author Eric Lin
 *
 * Text to display the turtes and pens state
 */
public class TurtleText {

    private final Text X_POS_LABEL = new Text("X Position: ");
    private final Text Y_POS_LABEL = new Text("Y Position: ");
    private final Text HEADING_LABEL = new Text("Heading: ");
    private final Text ID_LABEL = new Text("Turtle ID: ");
    private final Text PEN_COLOR_LABEL = new Text("Pen Color: ");
    private final Text PEN_THICKNESS_LABEL = new Text("Pen Thickness: ");
    private final Text PEN_DOWN_LABEL = new Text("Pen Down: ");
    static final String DEFAULT_INIT_POS = "0.0";
    static final String INVALID_INIT_POS = "-0.0";
    static final String DEFAULT_INIT_HEADING = "90.0";
    static final String DEFAULT_PEN_COLOR = "White";
    static final String DEFAULT_PEN_THICKNESS = "2.0";
    static final String DEFAULT_PEN_DOWN = "true";
    static final Integer XPOS_INDEX = 0;
    static final Integer YPOS_INDEX = 1;
    static final Integer HEADING_INDEX = 2;
    static final Integer HEX_MODIFIER = 255;


    private Text xPos;
    private Text yPos;
    private Text heading;
    private Text ID;
    private Text penColor;
    private Text penThickness;
    private Text penDown;

    /**
     * Creates an instance of the turtle text
     *
     * @param turtle    Turtle View
     */
    public TurtleText(TurtleView turtle) {
        xPos = new Text(DEFAULT_INIT_POS);
        yPos = new Text(DEFAULT_INIT_POS);
        heading = new Text(DEFAULT_INIT_HEADING);
        ID = new Text(turtle.getMyID().toString());
        penColor = new Text(DEFAULT_PEN_COLOR);
        penThickness = new Text(DEFAULT_PEN_THICKNESS);
        penDown = new Text(DEFAULT_PEN_DOWN);
    }

    Text[] getTurtleLabels() {
        return new Text[] {X_POS_LABEL, Y_POS_LABEL, HEADING_LABEL, ID_LABEL};
    }

    Text[] getTurtleStates() {
        return new Text[] {xPos, yPos, heading, ID};
    }

    Text[] getPenLabels() {
        return new Text[] {PEN_COLOR_LABEL, PEN_THICKNESS_LABEL, PEN_DOWN_LABEL};
    }

    Text[] getPenStates() {
        return new Text[] {penColor, penThickness, penDown};
    }

    /**
     * Sets the states to be displayed on screen
     *
     * @param states array of turtle state values
     */
    public void setStateValues(Double[] states) {
        xPos.setText(states[XPOS_INDEX].toString().equals(INVALID_INIT_POS)?DEFAULT_INIT_POS:states[XPOS_INDEX].toString());
        yPos.setText(states[YPOS_INDEX].toString().equals(INVALID_INIT_POS)?DEFAULT_INIT_POS:states[YPOS_INDEX].toString());
        heading.setText(states[HEADING_INDEX].toString());
    }

    void setPenColor(Color color) {
        int green = (int) (color.getGreen()*HEX_MODIFIER);
        String greenString = Integer.toHexString(green);
        int red = (int) (color.getRed() * HEX_MODIFIER);
        String redString = Integer.toHexString(red);
        int blue = (int) (color.getBlue()*HEX_MODIFIER);
        String blueString = Integer.toHexString(blue);
        String hexColor = "#" + redString + greenString + blueString;
        penColor.setText(hexColor);
    }

    void setPenThickness(Double thickness) {
        DecimalFormat df = new DecimalFormat("#.#####");
        penThickness.setText(df.format(thickness));
    }

    /**
     * Set value of pendown
     *
     * @param isDown    string of whether pen is down or up
     */
    public void setPenDownValue(String isDown) {
        penDown.setText(isDown);
    }


}
