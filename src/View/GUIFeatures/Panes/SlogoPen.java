package View.GUIFeatures.Panes;

import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * @author Hsingchih Tang
 * The pen tied to a TurtleView for drawing trails. There should be one Pen per TurtleView (i.e. one pen per tab)
 */
public class SlogoPen extends Node {
    static final Color DEFAULT_PEN_COLOR = Color.WHITE;
    static final double DEFAULT_PEN_WIDTH = 2.0;

    private GraphicsContext myGC;
    private CanvasPane myCanvasPane;
    private SlogoCanvas myCanvas;

    /**
     * Instantiates an instance of SlogoPen
     * @param canvas the canvas on which the trail should be drawn
     * @param pane the pane which holds the canvas
     */
    public SlogoPen(SlogoCanvas canvas, CanvasPane pane){
        myCanvas = canvas;
        myCanvasPane = pane;
        myGC = myCanvas.getGraphicsContext2D();
        myGC.setStroke(DEFAULT_PEN_COLOR);
        myGC.setFill(DEFAULT_PEN_COLOR);
        myGC.setLineWidth(DEFAULT_PEN_WIDTH);
    }

    /**
     * Update the pen's color
     * @param color the color to be applied on the pen
     */
    public void setColor(Color color){
        myGC.setStroke(color);
        myGC.setFill(color);
    }

    /**
     * Update the pen width
     * @param width the pen width to be applied
     */
    public void setWidth(Double width){
        myGC.setLineWidth(width);
    }

    /**
     * Draw a very short straight line segment following the TurtleView's movement
     * @param oldX the initial x-position of the TurtleView
     * @param oldY the initial y-position of the TurtleView
     * @param targetX the final x-position of the TurtleView
     * @param targetY the final y-position of the TurtleView
     */
    public void drawPath(double oldX, double oldY, double targetX, double targetY){
        myGC.moveTo(oldX+myCanvas.getWidth()/2,oldY+myCanvas.getHeight()/2);
        myGC.beginPath();
        myGC.lineTo(targetX+myCanvas.getWidth()/2,targetY+myCanvas.getHeight()/2);
        myGC.stroke();
        myGC.closePath();
    }

    /**
     * Clear all drawings on the canvas
     */
    public void clear() {
        Color canvasColor = myCanvasPane.getColor();
        myGC.clearRect(0, 0, myCanvas.getWidth(), myCanvas.getHeight());
        myCanvasPane.setCanvasColor(canvasColor);
    }

}
