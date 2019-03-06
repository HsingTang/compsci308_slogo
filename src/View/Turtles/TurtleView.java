package View.Turtles;

import Model.ModelInterfaces.TurtleModelInterface;
import View.GUIFeatures.Panels.SlogoCanvas;

import View.GUIFeatures.Panels.SlogoPen;
import View.ObserverInterfaces.TurtleObserver;
import javafx.animation.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


/**
 * @author Hsingchih Tang
 * Front-end visualization of the Turtle
 */
public class TurtleView implements TurtleObserver {

    public static final double INITIAL_HEADING = 90;
    public static final double TRANSLATION_SPEED = 1000;
    public static final double ANIMATION_SPEED = 10;
    public static final double INITIAL_POSITION = 0.0;

    private TurtleModelInterface myTurtleModel;
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
    private boolean penDown = true;
    private SlogoPen myPen;


    public TurtleView(int id, Image img, TurtleModelInterface model){
        this.myTurtleModel = model;
        model.registerTurtleObserver(this);
        this.myImgView = new ImageView(img);
        this.myID = id;
        this.myX = INITIAL_POSITION;
        this.myY = INITIAL_POSITION;
        this.myXDir = 0.0;
        this.myYDir = 0.0;
        this.myHeading = INITIAL_HEADING;
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

    public ImageView getImgView(){
        return myImgView;
    }

    public void setImgView(Image newImg) {
        this.myImgView = new ImageView(newImg);
    }

    public void setPen(SlogoPen pen){
        myPen = pen;
    }

    public SlogoPen getPen() {
        return this.myPen;
    }

    private void animateRotation(double rotationDegrees) {
        RotateTransition rt = new RotateTransition(Duration.millis(TRANSLATION_SPEED), this.myImgView);
        rt.setByAngle(rotationDegrees);
        rt.play();
    }


    private boolean movementComplete(double xAdjust, double yAdjust, double xFinal, double yFinal){
        return (xAdjust<0&&this.myImgView.getTranslateX()<=xFinal&&yAdjust<0&&this.myImgView.getTranslateY()<=yFinal)||
                (xAdjust>0&&this.myImgView.getTranslateX()>=xFinal&&yAdjust>0&&this.myImgView.getTranslateY()>=yFinal)||
                (xAdjust<0&&this.myImgView.getTranslateX()<=xFinal&&yAdjust>0&&this.myImgView.getTranslateY()>=yFinal)||
                (xAdjust>0&&this.myImgView.getTranslateX()>=xFinal&&yAdjust<0&&this.myImgView.getTranslateY()<=yFinal);
    }


    private void animateTranslation(double xFinal, double yFinal) {
        Timeline timeline = new Timeline();
        Double deltaX = xFinal-myImgView.getTranslateX();
        Double deltaY = yFinal-myImgView.getTranslateY();
        Double deltaDist = Math.sqrt(Math.pow(deltaX,2)+Math.pow(deltaY,2));
        final Double xAdjust;
        final Double yAdjust;
        if(deltaDist!=INITIAL_POSITION){
            xAdjust = deltaX/deltaDist;
            yAdjust = deltaY/deltaDist;
        }else{
            xAdjust = INITIAL_POSITION;
            yAdjust = INITIAL_POSITION;
        }

        var frame = new KeyFrame(Duration.millis(ANIMATION_SPEED), e -> {
            if(movementComplete(xAdjust,yAdjust,xFinal,yFinal)){
                timeline.stop();
            }
            this.myImgView.setTranslateX(this.myImgView.getTranslateX()+xAdjust);
            this.myImgView.setTranslateY(this.myImgView.getTranslateY()+yAdjust);
            if(this.penDown){
                this.myPen.drawPath(this.myImgView.getTranslateX()-xAdjust,this.myImgView.getTranslateY()-yAdjust,this.myImgView.getTranslateX(),this.myImgView.getTranslateY());

            }
        });
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(frame);
        timeline.play();
    }


    private void goHome() {
        this.myX = INITIAL_POSITION;
        this.myY = INITIAL_POSITION;
        this.myImgView.setTranslateX(this.myX);
        this.myImgView.setTranslateY(this.myY);
    }

    public void setCanvas(SlogoCanvas c){
        this.myCanvas = c;
    }

    public void updateX() {
        this.previousX = myX;
        this.myX = myTurtleModel.getX();
    }

    public void updateY() {
        this.previousY = myY;
        this.myY = myTurtleModel.getY();
    }

    public void updateMove() {
        animateTranslation(myTurtleModel.getX(), myTurtleModel.getY());
    }

    public void updateLeftRotate() {
        double newLeftRotateDegs = myTurtleModel.getHeading() - this.myHeading;
        this.myHeading += newLeftRotateDegs;
        animateRotation(-newLeftRotateDegs);
    }

    public void updateRightRotate() {
        double newRightRotateDegs = this.myHeading - myTurtleModel.getHeading();
        this.myHeading -= newRightRotateDegs;
        animateRotation(newRightRotateDegs);
    }

    public void updateHeading() {
        double newHeading = myTurtleModel.getHeading();
        this.myImgView.setRotate(newHeading - this.myHeading);
        this.myHeading = newHeading;
    }

    public void updatePenDown() {
        this.penDown = myTurtleModel.getPenDown();
    }

    public void updateHome() { this.goHome(); }

    public void updateVisibility() {
        boolean isInvisible = myTurtleModel.isInvisible();
        if (!isInvisible) {
            this.myImgView.setVisible(true);
        } else {
            this.myImgView.setVisible(false);
        }
    }

    public void updateClear() {
        this.myPen.clear();
    }

}
