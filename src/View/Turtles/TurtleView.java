package View.Turtles;

import Model.ModelInterfaces.TurtleModelInterface;
import State.TurtleState;
import View.GUIFeatures.Panes.SlogoPen;
import View.GUIFeatures.Panes.TurtleText;
import View.ObserverInterfaces.TurtleObserver;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.text.DecimalFormat;
import java.util.Queue;


/**
 * @author Hsingchih Tang
 * @author Eric Lin
 * Front-end visualization of the Turtle
 */
public class TurtleView implements TurtleObserver {

    public static final double INITIAL_HEADING = 90;
    public static final double TRANSLATION_SPEED = 1000;
    public static final double ANIMATION_SPEED = 10;
    public static final double INITIAL_POSITION = 0.0;
    public static final double TURTLE_SIZE = 35;
    public static final double THRESHOLD = 0.00000001;
    public static final double MODIFIER = -1;
    public static final double X_BOUND = 240;
    public static final double Y_BOUND = 240;

    private TurtleModelInterface myTurtleModel;
    private ImageView myImgView;
    private Integer myID;
    private double myX;
    private double myY;
    private double myHeading;
    private Boolean penDown;
    private boolean isMoving;
    private SlogoPen myPen;
    private Queue<TurtleState> stateQueue;
    private TurtleState newState;
    private TurtleText turtleTextState;

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
        this.turtleTextState = new TurtleText(this);
    }

    public Integer getMyID() {
        return myID;
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
        return (checkXLessThanFinal || checkXGreaterThanFinal)||xOutofBound(xAdjust)||yOutofBound(yAdjust);
    }


    private boolean xOutofBound(double xAdjust){
        boolean ret = Math.abs(this.myImgView.getTranslateX()+xAdjust)>=X_BOUND;
        if(ret){
            myTurtleModel.setX(myTurtleModel.getX()>0?X_BOUND:X_BOUND*(MODIFIER));
        }
        return ret;
    }

    private boolean yOutofBound(double yAdjust){
        boolean ret = Math.abs(this.myImgView.getTranslateY()+yAdjust)>=Y_BOUND;
        if(ret){
            myTurtleModel.setY(myTurtleModel.getY()>0?Y_BOUND:Y_BOUND*(MODIFIER));
        }
        return ret;
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
        Double xAdjust = (deltaDist!=INITIAL_POSITION?(deltaX/deltaDist):INITIAL_POSITION);
        Double yAdjust = (deltaDist!=INITIAL_POSITION?(deltaY/deltaDist):INITIAL_POSITION);
        animateTranslation(xAdjust,yAdjust,xFinal,yFinal);
    }

    private void animateTranslation(double xAdjust,double yAdjust, double xFinal, double yFinal){
        Timeline timeline = new Timeline();
        var frame = new KeyFrame(Duration.millis(ANIMATION_SPEED), e -> {
                if (movementComplete(xAdjust, yAdjust, xFinal, yFinal)) {
                    timeline.stop();
                }
                if(Math.abs(this.myImgView.getTranslateX()+xAdjust)<X_BOUND && Math.abs(this.myImgView.getTranslateY()+yAdjust)<Y_BOUND){
                    this.myImgView.setTranslateX(this.myImgView.getTranslateX() + xAdjust);
                    this.myImgView.setTranslateY(this.myImgView.getTranslateY() + yAdjust);
                    if (this.penDown) {
                        this.myPen.drawPath(this.myImgView.getTranslateX() - xAdjust, this.myImgView.getTranslateY() - yAdjust, this.myImgView.getTranslateX(), this.myImgView.getTranslateY());
                    }
                }
        });
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(frame);
        timeline.play();
    }

    private  void updatePenDown() {
        this.penDown = newState.getPenDown();
        if (this.penDown) {
            turtleTextState.setPenDownValue("true");
        } else {
            turtleTextState.setPenDownValue("false");
        }
    }

    public void updateView() {
        this.stateQueue = myTurtleModel.getModelStates();
        updateTurtle();
    }

    private void updatePenVisibility() {
        if (newState.getIsPenCleared()) {
            this.myPen.clear();
            this.penDown = false;
        }
    }

    private void updateTurtle() {
        if (!stateQueue.isEmpty()) {
            System.out.println(stateQueue.size());
            double currentHeading = this.myHeading;
            newState = stateQueue.poll();
            this.getTurtleState(newState);
            updatePenDown();
            updatePenVisibility();
            if (isMoving) {
                calcAnimateParams(newState.getNewX(), newState.getNewY());
            }
            animateRotation(currentHeading - newState.getNewHeading());
            myTurtleModel.setPenVisible();
            setTurtleStateText();
        }

    }

    private void getTurtleState(TurtleState newState) {
        this.myX = newState.getNewX();
        this.myY = newState.getNewY();
        this.myHeading = newState.getNewHeading();
        this.penDown = newState.getPenDown();
        this.myImgView.setVisible(!newState.getIsInvisible());
        this.isMoving = newState.getIsMoving();
    }

    public TurtleText getTurtleTextState() {
        return this.turtleTextState;
    }

    private void setTurtleStateText() {
        double retX = 0;
        double retY = 0;
        DecimalFormat df = new DecimalFormat("#.#####");
        if (Math.abs(this.myX) > THRESHOLD) {
            retX = this.myX;
        }
        if (Math.abs(this.myY) > THRESHOLD) {
            retY = this.myY;
        }
        retX = Double.parseDouble(df.format(retX));
        retY = MODIFIER * Double.parseDouble(df.format(retY));
        Double[] newPositions = {retX, retY, this.myHeading};
        turtleTextState.setStateValues(newPositions);
    }

}