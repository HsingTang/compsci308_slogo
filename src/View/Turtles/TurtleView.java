package View.Turtles;

import Model.ModelInterfaces.TurtleModelInterface;
import View.GUIFeatures.Panels.SlogoCanvas;

import View.ObserverInterfaces.TurtleObserver;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.util.Duration;


/**
 * @author Hsingchih Tang
 * Front-end visualization of the Turtle
 */
public class TurtleView implements TurtleObserver {

    public static final double INITIAL_HEADING = 90;
    public static final double TRANSLATION_SPEED = 3000;

    private TurtleModelInterface model;
    private ImageView myImgView;
    private Integer myID;
    private double previousX;
    private double previousY;
    private double myX;
    private double myY;
    private double myXDir;
    private double myYDir;
    private double myHeading;
    private SlogoCanvas myCanvas;
    private double canvasWidth;
    private double canvasHeight;
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
        this.myHeading = INITIAL_HEADING;
        this.myPenColor = color;
        this.penDown = true;
    }

    public Integer getMyID() {
        return myID;
    }

    public double getX() {
        return myImgView.getX();
    }

    public double getY() {
        return myImgView.getY();
    }

    public double getXDir() {
        return myXDir;
    }

    public double getYDir() {
        return myYDir;
    }

    public ImageView getImgView(){
        return myImgView;
    }

    public void setImgView(Image newImg) {
        this.myImgView = new ImageView(newImg);
    }

    private void animateRotation(double rotationDegrees) {
        RotateTransition rt = new RotateTransition(Duration.millis(TRANSLATION_SPEED), this.myImgView);
        rt.setByAngle(rotationDegrees);
        rt.play();
    }

    private void animateTranslation(double xFinal, double yFinal) {
        TranslateTransition tt = new TranslateTransition(Duration.millis(TRANSLATION_SPEED), this.myImgView);
        tt.setFromX(previousX);
        tt.setFromY(previousY);
        tt.setToX(xFinal);
        tt.setToY(yFinal);
        tt.play();
    }

    private void setX(double newX) {
        this.previousX = myX;
        this.myX = newX;
    }

    private void setY(double newY) {
        this.previousY = myY;
        this.myY = newY;
    }

    private void rotateLeft(double newDegrees) {
        this.myHeading += newDegrees;
        animateRotation(newDegrees);
    }

    private void rotateRight(double newDegrees) {
        this.myHeading -= newDegrees;
        animateRotation(-newDegrees);
    }

    private void setHeading(double newHeading) {
        this.myImgView.setRotate(newHeading - this.myHeading);
        this.myHeading = newHeading;
    }

    public void setCanvas(SlogoCanvas c){
        this.myCanvas = c;
        this.canvasWidth = c.getWidth();
        this.canvasHeight = c.getHeight();
    }

    public void drawTrail(){
        if (this.penDown){
            //draw animation
        }
    }

    public void updateX() {
        double newX = model.getX();
        this.setX(newX);
    }

    public void updateY() {
        double newY = model.getY();
        this.setY(newY);
    }

    public void updateMove() {
        animateTranslation(model.getX(), model.getY());
    }


    public void updateLeftRotate() {
        double newLeftRotateDegs = model.getHeading() - this.myHeading;
        this.rotateLeft(newLeftRotateDegs);
    }

    public void updateRightRotate() {
        double newRightRotateDegs = this.myHeading - model.getHeading();
        this.rotateRight(newRightRotateDegs);
    }

    public void updateHeading() {
        double newHeading = model.getHeading();
        this.setHeading(newHeading);
    }

    public void updatePenDown() {
        this.penDown = model.getPenDown();
    }

}
