package View.GUIFeatures.Panes;

import View.Turtles.TurtleView;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

/**
 * @author Hsingchih Tang
 */
public class CanvasPane extends StackPane {
    public static final Color DEFAULT_BG_COLOR = Color.BLACK;

    private SlogoCanvas myCanvas;
    private Canvas myBackGroundCanvas;
    private double myHeight;
    private double myWidth;
    private Color myBackgroundColor;

    public CanvasPane(double width, double height){
        super();
        myHeight = height;
        myWidth = width;
        myBackgroundColor = DEFAULT_BG_COLOR;
        setMaxSize(myWidth, myHeight);
        initBackGround();
        initSlogoCanvas();
    }

    public double getCanvasWidth(){
        return myWidth;
    }

    public double getCanvasHeight(){
        return myHeight;
    }

    public Color getColor() {
        return this.myBackgroundColor;
    }

    public void initTurtleView(TurtleView turtle){
        this.getChildren().add(turtle.getImgView());
        turtle.setPen(new SlogoPen(myCanvas,this));
    }

    public void setCanvasColor(Color color){
        myBackgroundColor = color;
        myBackGroundCanvas.getGraphicsContext2D().setFill(color);
        myBackGroundCanvas.getGraphicsContext2D().fillRect(0, 0, myWidth, myHeight);
        myBackGroundCanvas.toBack();
    }

    private void initSlogoCanvas() {
        myCanvas = new SlogoCanvas(myWidth,myHeight);
        StackPane.setAlignment(myCanvas, Pos.CENTER);
        this.getChildren().add(myCanvas);
    }

    private void initBackGround(){
        myBackGroundCanvas = new Canvas(myWidth,myHeight);
        myBackGroundCanvas.getGraphicsContext2D().setFill(myBackgroundColor);
        myBackGroundCanvas.getGraphicsContext2D().fillRect(0, 0, myWidth, myHeight);
        this.getChildren().add(myBackGroundCanvas);
    }

}
