package View.Turtles;

import Model.ModelInterfaces.TurtleModelInterface;
import View.GUIFeatures.Panels.SlogoCanvas;

import View.ObserverInterfaces.TurtleObserver;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;


/**
 * @author Hsingchih Tang
 * Front-end visualization of the Turtle
 */
public class TurtleView implements TurtleObserver {

    private TurtleModelInterface model;
    private ImageView myImgView;
    private Integer myID;
    private Double myX;
    private Double myY;
    private Double myXDir;
    private Double myYDir;
    private SlogoCanvas myCanvas;
    private Double canvasWidth;
    private Double canvasHeight;
    private Color myPenColor;
    private boolean penDown;


    public TurtleView(int id, Image img, Color color, TurtleModelInterface model){
        this.model = model;
        model.registerTurtleObserver(this);
        this.myImgView = new ImageView(img);
        this.myID = id;
        this.myX = 0.0;
        this.myY = 0.0;
        this.myXDir = 0.0;
        this.myYDir = 0.0;
        this.myPenColor = color;
        this.penDown = true;
    }

    public Integer getMyID() {
        return myID;
    }

    public Double getX() {
        return myImgView.getX();
    }

    public Double getY() {
        return myImgView.getY();
    }

    public Double getXDir() {
        return myXDir;
    }

    public Double getYDir() {
        return myYDir;
    }

    public ImageView getImgView(){
        return myImgView;
    }

    public void setImgView(Image newImg) {
        this.myImgView = new ImageView(newImg);
    }

    private void setX(Double newX) {
        this.myX = newX;
    }

    private void setY(Double newY) {
        this.myY = newY;
    }

    public void setXDir(Double newXDir) {
        this.myXDir = newXDir;
    }

    public void setYDir(Double newYDir) {
        this.myYDir = newYDir;
    }

    public void setCanvas(SlogoCanvas c){
        this.myCanvas = c;
        this.canvasWidth = c.getWidth();
        this.canvasHeight = c.getHeight();
    }

    public void setPenUp(){
        this.penDown = false;
    }

    public void setPenDown(){
        this.penDown = true;
    }

    public void drawTrail(){
        if (this.penDown){

        }
    }

    public void updateX() {
        double newX = model.getX();
        this.setX(newX);
    }

    public void updateY() {

    }

}
