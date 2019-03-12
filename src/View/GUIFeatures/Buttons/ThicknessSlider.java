package View.GUIFeatures.Buttons;

import View.GUIFeatures.Panes.SlogoPen;
import javafx.scene.control.Slider;
import javafx.scene.text.Text;

/**
 * Slider to adjust thickness of pen
 *
 * @author Eric Lin
 */
public class ThicknessSlider extends Slider {

    static final int BASE = 1;
    static final int MAX = 4;
    static final int DEFAULT = 2;
    static final double INCREMENT = 0.25;

    private Text sliderText;

    /**
     * creates an instance of thickness slider
     */
    public ThicknessSlider() {
        super(BASE, MAX, DEFAULT);
        this.setShowTickLabels(true);
        this.setShowTickMarks(true);
        this.setSnapToTicks(true);
        this.setBlockIncrement(INCREMENT);
        this.setMajorTickUnit(BASE);
        this.getStyleClass().add("slider");
        sliderText = new Text("Set Pen Width");
    }

    public void changeThickness(SlogoPen pen) {
        pen.setWidth(this.getValue());
    }

    public Text getSliderText() {
        return this.sliderText;
    }
}
