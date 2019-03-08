package View.Turtles;

import Handlers.HandlerInterfaces.CommandHandlerInterface;
import Model.ModelInterfaces.TurtleModelInterface;
import State.TurtleState;
import View.GUIFeatures.Panes.SlogoPen;
import View.ObserverInterfaces.TurtleObserver;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import java.util.Queue;


/**
 * @author Hsingchih Tang
 * Front-end visualization of the Turtle
 */
public class TurtleView implements TurtleObserver {

    public static final double INITIAL_HEADING = 90;
    public static final double TRANSLATION_SPEED = 1000;
    public static final double ANIMATION_SPEED = 10;
    public static final double INITIAL_POSITION = 0.0;
    public static final double TURTLE_SIZE = 35;

    private TurtleModelInterface myTurtleModel;
    private CommandHandlerInterface handler;
    private ImageView myImgView;
    private Integer myID;
    private double previousX;
    private double previousY;
    private double myX;
    private double myY;
    private double myHeading;
    private boolean penDown = true;
    private SlogoPen myPen;
    private Queue<TurtleState> stateQueue;


    public TurtleView(int id, Image img, TurtleModelInterface model){
        this.myTurtleModel = model;
        model.registerTurtleObserver(this);
        this.myImgView = new ImageView(img);
        myImgView.setFitWidth(TURTLE_SIZE);
        myImgView.setFitHeight(TURTLE_SIZE);
        myImgView.setPreserveRatio(true);
        this.myID = id;
        this.myX = INITIAL_POSITION;
        this.myY = INITIAL_POSITION;
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
        this.myImgView.setImage(newImg);
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
        rt.setOnFinished(e -> updateTurtle());
        rt.play();
    }


    private boolean movementComplete(double xAdjust, double yAdjust, double xFinal, double yFinal){
        boolean checkXLessThanFinal = checkXLessThanFinal(xAdjust, yAdjust, xFinal, yFinal);
        boolean checkXGreaterThanFinal = checkXGreaterThanFinal(xAdjust, yAdjust, xFinal, yFinal);
        return (checkXLessThanFinal || checkXGreaterThanFinal);
    }

    private boolean checkXLessThanFinal(double xAdjust, double yAdjust, double xFinal, double yFinal) {
        double translateX = this.myImgView.getTranslateX();
        double translateY = this.myImgView.getTranslateY();
        boolean check1 = xAdjust<0&&translateX<=xFinal&&yAdjust<0&&translateY<=yFinal;
        boolean check2 = xAdjust<0&&translateX<=xFinal&&yAdjust>0&&translateY>=yFinal;
        return (check1 || check2);
    }

    private boolean checkXGreaterThanFinal(double xAdjust, double yAdjust, double xFinal, double yFinal) {
        double translateX = this.myImgView.getTranslateX();
        double translateY = this.myImgView.getTranslateY();
        boolean check1 =  xAdjust>0&&translateX>=xFinal&&yAdjust>0&&translateY>=yFinal;
        boolean check2 =  xAdjust>0&&translateX>=xFinal&&yAdjust<0&&translateY<=yFinal;
        return (check1 || check2);
    }


    private void calcAnimateParams(double xFinal, double yFinal) {
        Double deltaX = xFinal - this.myImgView.getTranslateX();
        Double deltaY = yFinal - this.myImgView.getTranslateY();
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
        animateTranslation(xAdjust,yAdjust,xFinal,yFinal);
    }

    private void animateTranslation(double xAdjust,double yAdjust, double xFinal, double yFinal){
        Timeline timeline = new Timeline();
        var frame = new KeyFrame(Duration.millis(ANIMATION_SPEED), e -> {
                if (movementComplete(xAdjust, yAdjust, xFinal, yFinal)) {
                    timeline.stop();
                }
                this.myImgView.setTranslateX(this.myImgView.getTranslateX() + xAdjust);
                this.myImgView.setTranslateY(this.myImgView.getTranslateY() + yAdjust);
                if (this.penDown) {
                    this.myPen.drawPath(this.myImgView.getTranslateX() - xAdjust, this.myImgView.getTranslateY() - yAdjust, this.myImgView.getTranslateX(), this.myImgView.getTranslateY());
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


    public void updateX() {
        this.myX = myTurtleModel.getX();

    }

    public void updateY() {
        this.myY = myTurtleModel.getY();

    }

    public void updateMove() {
        calcAnimateParams(myTurtleModel.getX(), myTurtleModel.getY());
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
        animateRotation(this.myHeading - newHeading);
        this.myHeading = newHeading;
    }

    public void updatePenDown() {
        this.penDown = myTurtleModel.getPenDown();
    }

    public void updateHome() { this.goHome(); }

    public void updateVisibility() {
        this.myImgView.setVisible(!myTurtleModel.isInvisible());
    }

    public void updateClear() {
        this.myPen.clear();
    }

    public void updateView() {
        this.stateQueue = myTurtleModel.getModelStates();
        updateTurtle();
    }

    private void updatePenVisibility() {
        if (myTurtleModel.isPenInvisible()) {
            this.myPen.clear();
            this.penDown = false;
        }
        myTurtleModel.setPenVisible();
    }

    private void updateTurtle() {
        System.out.println("StateQueue size: " + stateQueue.size());
        if (!stateQueue.isEmpty()) {
            System.out.println("entering");
            double currentHeading = this.myHeading;
            previousX = this.myX;
            previousY = this.myY;
            TurtleState newState = stateQueue.poll();
            this.getTurtleState(newState);
            updateVisibility();
            updatePenDown();
            updatePenVisibility();
            calcAnimateParams(newState.getNewX(), newState.getNewY());
            animateRotation(currentHeading - newState.getNewHeading());
        }

    }

    private void getTurtleState(TurtleState newState) {
        this.myX = newState.getNewX();
        this.myY = newState.getNewY();
        this.myHeading = newState.getNewHeading();
        this.penDown = newState.getPenDown();
        this.myImgView.setVisible(!newState.getIsInvisible());
    }

}
