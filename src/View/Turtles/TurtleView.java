package View.Turtles;

import Model.ModelInterfaces.ModelInterface;
import View.GUIFeatures.Panels.SlogoCanvas;

import View.ObserverInterfaces.TurtleObserver;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.FillRule;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;


/**
 * @author Hsingchih Tang
 * Front-end visualization of the Turtle
 */
public class TurtleView implements TurtleObserver {

    public static final double INITIAL_HEADING = 90;
    public static final double TRANSLATION_SPEED = 1000;
    public static final double INITIAL_POSITION = 0.0;

    private ModelInterface model;
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
    private Path pen;


    public TurtleView(int id, Image img, Color color, ModelInterface model){
        this.model = model;
        model.registerTurtleObserver(this);
        this.myImgView = new ImageView(img);
        this.myID = id;
        this.myX = INITIAL_POSITION;
        this.myY = INITIAL_POSITION;
        this.myXDir = 0.0;
        this.myYDir = 0.0;
        this.myHeading = INITIAL_HEADING;
        this.myPenColor = color;
        this.penDown = true;
        this.pen = new Path();
        pen.setFill(myPenColor);
        pen.setFillRule(FillRule.EVEN_ODD);
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
        tt.setToX(xFinal);
        tt.setToY(yFinal);
        tt.play();
        this.myImgView.setX(xFinal);
        this.myImgView.setY(yFinal);
    }

    private void animatePen(double xFinal, double yFinal) {
        drawTrail();
        Path path = new Path();
        MoveTo moveTo = new MoveTo(previousX, previousY);
        LineTo lineTo = new LineTo(xFinal, yFinal);
        path.getElements().addAll(moveTo, lineTo);
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(TRANSLATION_SPEED));
        pathTransition.setNode(pen);
        pathTransition.setPath(path);
    }

    private void goHome() {
        this.myX = INITIAL_POSITION;
        this.myY = INITIAL_POSITION;
        this.myImgView.setX(this.myX);
        this.myImgView.setY(this.myY);
    }

    public void setCanvas(SlogoCanvas c){
        this.myCanvas = c;
        this.canvasWidth = c.getWidth();
        this.canvasHeight = c.getHeight();
    }

    public void drawTrail(){
        if (this.penDown){
            pen.setVisible(true);
        } else {
            pen.setVisible(false);
        }
    }

    public void updateX() {
        this.previousX = myX;
        this.myX = model.getX();
    }

    public void updateY() {
        this.previousY = myY;
        this.myY = model.getY();
    }

    public void updateMove() {
        animateTranslation(model.getX(), model.getY());
        animatePen(model.getX(), model.getY());
    }


    public void updateLeftRotate() {
        double newLeftRotateDegs = model.getHeading() - this.myHeading;
        this.myHeading += newLeftRotateDegs;
        animateRotation(-newLeftRotateDegs);
    }

    public void updateRightRotate() {
        double newRightRotateDegs = this.myHeading - model.getHeading();
        this.myHeading -= newRightRotateDegs;
        animateRotation(newRightRotateDegs);
    }

    public void updateHeading() {
        double newHeading = model.getHeading();
        this.myImgView.setRotate(newHeading - this.myHeading);
        this.myHeading = newHeading;
    }

    public void updatePenDown() {
        this.penDown = model.getPenDown();
    }

    public void updateHome() { this.goHome(); }

    public void updateVisibility() {
        boolean isInvisible = model.isInvisible();
        if (!isInvisible) {
            this.myImgView.setVisible(false);
        } else {
            this.myImgView.setVisible(true);
        }
    }

}
