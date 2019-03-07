package View.GUIFeatures.Panes;

import View.Turtles.TurtleView;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class CanvasPane extends StackPane {
    private SlogoCanvas myCanvas;
    private TurtleView myTurtle;
    private double myHeight;
    private double myWidth;

    public CanvasPane(double width, double height){
        super();
        myHeight = height;
        myWidth = width;
        this.setMaxSize(myWidth, myHeight);
        initCanvas();
    }

    public SlogoCanvas getCanvas(){
        return this.myCanvas;
    }

    public double getCanvasWidth(){
        return myWidth;
    }

    public double getCanvasHeight(){
        return myHeight;
    }

    public void initTurtleView(TurtleView turtle){
        myTurtle = turtle;
        this.getChildren().add(myTurtle.getImgView());
        myTurtle.setCanvas(myCanvas);
        myTurtle.setPen(new SlogoPen(myCanvas));
    }

    public void setCanvasColor(Color color){
        myCanvas.setBackgroundColor(color);
    }

    private void initCanvas() {
        myCanvas = new SlogoCanvas(myWidth,myHeight);
        StackPane.setAlignment(myCanvas, Pos.CENTER);
        this.getChildren().add(myCanvas);
    }



}
