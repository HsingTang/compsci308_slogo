package View.GUIFeatures.Panes;

import View.Turtles.TurtleView;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

/**
 * @author Hsingchih Tang
 * Center section of the GUI, which holds the Turtle visualization and the Canvas on which Turtle draws its trail
 * There should be one CanvasPane per tab
 */
public class CanvasPane extends StackPane {
    public static final Color DEFAULT_BG_COLOR = Color.BLACK;

    private SlogoCanvas myCanvas;
    private Canvas myBackGroundCanvas;
    private double myHeight;
    private double myWidth;
    private Color myBackgroundColor;

    /**
     * Initiates an instance of the CanvasPane
     * @param width of the canvas area
     * @param height of the canvas area
     */
    public CanvasPane(double width, double height){
        super();
        myHeight = height;
        myWidth = width;
        myBackgroundColor = DEFAULT_BG_COLOR;
        setMaxSize(myWidth, myHeight);
        initBackGround();
        initSlogoCanvas();
    }

    /**
     * @return width of the canvas area
     */
    public double getCanvasWidth(){
        return myWidth;
    }

    /**
     * @return height of the canvas area
     */
    public double getCanvasHeight(){
        return myHeight;
    }

    /**
     * @return background color of the canvas area
     */
    public Color getColor() {
        return this.myBackgroundColor;
    }

    /**
     * Sets up the TurtleView for this tab and initializes its corresponding pen for drawing
     * @param turtle the TurtleView of this tab
     */
    public void initTurtleView(TurtleView turtle){
        this.getChildren().add(turtle.getImgView());
        turtle.setPen(new SlogoPen(myCanvas,this));
    }

    /**
     * Changes the canvas background color without affecting the trails already drawn
     * @param color
     */
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
