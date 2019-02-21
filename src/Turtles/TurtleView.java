package Turtles;

import GUIFeatures.SlogoCanvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 * @author Hsingchih Tang
 * Front-end visualization of the Turtle
 */
public class TurtleView {

    private ImageView myImgView;
    private Integer myID;
    private Double myX;
    private Double myY;
    private Double myXDir;
    private Double myYDir;
    private SlogoCanvas myCanvas;
    private Color myPenColor;
    private boolean penDown;


    public TurtleView(int id, Image img, SlogoCanvas c, Color color){
        this.myID = id;
        this.myX = 0.0;
        this.myY = 0.0;
        this.myXDir = 0.0;
        this.myYDir = 0.0;
        this.myImgView = new ImageView(img);
        this.myCanvas = c;
        this.myPenColor = color;
        this.penDown = true;
    }

    public Integer getMyID() {
        return myID;
    }

    public Double getX() {
        return myX;
    }

    public Double getY() {
        return myY;
    }

    public Double getXDir() {
        return myXDir;
    }

    public Double getYDir() {
        return myYDir;
    }

    public void setImgView(Image newImg) {
        this.myImgView = new ImageView(newImg);
    }

    public void setX(Double newX) {
        this.myX = newX;
    }

    public void setY(Double newY) {
        this.myY = newY;
    }

    public void setXDir(Double newXDir) {
        this.myXDir = newXDir;
    }

    public void setYDir(Double newYDir) {
        this.myYDir = newYDir;
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

}
