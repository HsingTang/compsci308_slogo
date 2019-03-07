package View.GUIFeatures.Panes;

import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class SlogoPen extends Node {
    private final Color DEFAULT_PEN_COLOR = Color.WHITE;
    private final double DEFAULT_PEN_WIDTH = 2.0;

    private GraphicsContext myGC;
    private SlogoCanvas myCanvas;

    public SlogoPen(SlogoCanvas canvas){
        myCanvas = canvas;
        myGC = myCanvas.getGraphicsContext2D();
        myGC.setStroke(DEFAULT_PEN_COLOR);
        myGC.setFill(DEFAULT_PEN_COLOR);
        myGC.setLineWidth(DEFAULT_PEN_WIDTH);
    }

    public void setColor(Color color){
        myGC.setStroke(color);
        myGC.setFill(color);
    }

    public void setWidth(Double width){
        myGC.setLineWidth(width);
    }

    public void drawPath(double oldX, double oldY, double targetX, double targetY){
        myGC.moveTo(oldX+myCanvas.getWidth()/2,oldY+myCanvas.getHeight()/2);
        myGC.beginPath();
        myGC.lineTo(targetX+myCanvas.getWidth()/2,targetY+myCanvas.getHeight()/2);
        myGC.stroke();
        myGC.closePath();
    }

    public void clear() {
        Color canvasColor = myCanvas.getColor();
        myGC.clearRect(0, 0, myCanvas.getWidth(), myCanvas.getHeight());
        myCanvas.setBackgroundColor(canvasColor);
    }

}
