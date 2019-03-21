package View.Turtles;

import Model.ModelInterfaces.TurtleModelInterface;
import State.TurtleState;
import View.GUIFeatures.Panes.SlogoPen;
import View.GUIFeatures.Panes.TurtleText;
import View.ObserverInterfaces.TurtleObserver;
import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.text.DecimalFormat;
import java.util.Queue;


/**
 * @author Hsingchih Tang
 * @author Eric Lin
 * Front-end visualization of the Turtle. There should be one Turtle per tab. I'v chosen this class, along with the
 * Turtle Model class as my masterpiece classes to reflect the observer/observable design pattern that I've used.
 * Also, the methods in this class are as succint as can be and the use of helper methods is important within the
 * turtle view to calculate distances travelled. The turtleView has a dependency, only on the TurtleModelInterface is
 * passed to the observer. The front-end has a depencedency on this model interface, but as you will see in the model,
 * there is only a dependency of the model on the observer interface which only has an udpate Method. Overall,
 * this class is used to change the front-end view of the turtle on model change.
 */
public class TurtleView implements TurtleObserver {

    public static final double INITIAL_HEADING = 90;
    public static final double TRANSLATION_SPEED = 1000;
    public static final double ANIMATION_SPEED = 10;
    public static final double INITIAL_POSITION = 0.0;
    public static final double TURTLE_SIZE = 35;
    public static final double THRESHOLD = 0.00000001;
    public static final double MODIFIER = -1;
    public static final String DOUBLE_PATTERN = "#.#####";

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

    /**
     * Instantiates a new TurtleView object
     * @param id indicating which tab this TurtleView belongs to
     * @param img the ImageView visualization of the Turtle
     * @param model the TurtleModel associated with this TurtleView
     */
    public TurtleView(int id, Image img, TurtleModelInterface model) {
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

    /**
     * Updates the ImageView visualization for this TurtleView
     * @param newImg the new visualization image
     */
    public void setImgView(Image newImg) {
        this.myImgView.setImage(newImg);
    }

    /**
     * Ties the TurtleView with its corresponding SlogoPen for canvas drawing
     * @param pen the SlogoPen to be tied with this TurtleView
     */
    public void setPen(SlogoPen pen) {
        myPen = pen;
    }

    /**
     * Retrieve the TurtleView states from its TurtleModel as a result of command execution
     * and update the front-end visualization based on TurtleModel's data
     */
    public void updateView() {
        this.stateQueue = myTurtleModel.getModelStates();
        updateTurtle();
    }

    /**
     * @return ID number of this TurtleView
     */
    public Integer getMyID() {
        return myID;
    }

    /**
     * @return ImageView visualization of this TurtleView
     */
    public ImageView getImgView() {
        return myImgView;
    }

    /**
     * @return the SlogoPen tied with this TurtleView
     */
    public SlogoPen getPen() {
        return this.myPen;
    }

    /**
     * @return the TurtleView's states (positions, heading, etc.) wrapped in TurtleText format
     */
    public TurtleText getTurtleTextState() {
        return this.turtleTextState;
    }

    private void updateTurtle() {
        if (!stateQueue.isEmpty()) {
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

    private void animateRotation(double rotationDegrees) {
        RotateTransition rt = new RotateTransition(Duration.millis(TRANSLATION_SPEED), this.myImgView);
        rt.setByAngle(rotationDegrees);
        rt.setOnFinished(e -> updateTurtle());
        rt.play();
    }

    private boolean movementComplete(double xAdjust, double yAdjust, double xFinal, double yFinal) {
        boolean checkXLessThanFinal = checkXLessThanFinal(xAdjust, yAdjust, xFinal, yFinal);
        boolean checkXGreaterThanFinal = checkXGreaterThanFinal(xAdjust, yAdjust, xFinal, yFinal);
        return (checkXLessThanFinal || checkXGreaterThanFinal);
    }

    private boolean checkXLessThanFinal(double xAdjust, double yAdjust, double xFinal, double yFinal) {
        double translateX = this.myImgView.getTranslateX();
        double translateY = this.myImgView.getTranslateY();
        boolean check1 = xAdjust < 0 && translateX <= xFinal && yAdjust < 0 && translateY <= yFinal;
        boolean check2 = xAdjust < 0 && translateX <= xFinal && yAdjust > 0 && translateY >= yFinal;
        return (check1 || check2);
    }

    private boolean checkXGreaterThanFinal(double xAdjust, double yAdjust, double xFinal, double yFinal) {
        double translateX = this.myImgView.getTranslateX();
        double translateY = this.myImgView.getTranslateY();
        boolean check1 = xAdjust > 0 && translateX >= xFinal && yAdjust > 0 && translateY >= yFinal;
        boolean check2 = xAdjust > 0 && translateX >= xFinal && yAdjust < 0 && translateY <= yFinal;
        return (check1 || check2);
    }

    private void calcAnimateParams(double xFinal, double yFinal) {
        Double deltaX = xFinal - this.myImgView.getTranslateX();
        Double deltaY = yFinal - this.myImgView.getTranslateY();
        Double deltaDist = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        Double xAdjust = (deltaDist != INITIAL_POSITION ? (deltaX / deltaDist) : INITIAL_POSITION);
        Double yAdjust = (deltaDist != INITIAL_POSITION ? (deltaY / deltaDist) : INITIAL_POSITION);
        animateTranslation(xAdjust, yAdjust, xFinal, yFinal);
    }

    private void animateTranslation(double xAdjust, double yAdjust, double xFinal, double yFinal) {
        Timeline timeline = new Timeline();
        var frame = new KeyFrame(Duration.millis(ANIMATION_SPEED), e -> drawPen(xAdjust, yAdjust, xFinal, yFinal, timeline));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(frame);
        timeline.play();
    }

    private void drawPen(double xAdjust, double yAdjust, double xFinal, double yFinal, Timeline timeline) {
        if (movementComplete(xAdjust, yAdjust, xFinal, yFinal)) {
            timeline.stop();
        }
        this.myImgView.setTranslateX(this.myImgView.getTranslateX() + xAdjust);
        this.myImgView.setTranslateY(this.myImgView.getTranslateY() + yAdjust);
        if (this.penDown) {
            this.myPen.drawPath(this.myImgView.getTranslateX() - xAdjust, this.myImgView.getTranslateY() - yAdjust, this.myImgView.getTranslateX(), this.myImgView.getTranslateY());
        }
    }

    private void updatePenDown() {
        turtleTextState.setPenDownValue(this.penDown.toString());
    }

    private void updatePenVisibility() {
        if (newState.getIsPenCleared()) {
            this.myPen.clear();
            this.penDown = false;
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

    private void setTurtleStateText() {
        DecimalFormat df = new DecimalFormat(DOUBLE_PATTERN);
        double retX = (Math.abs(this.myX) > THRESHOLD ? this.myX : 0);
        double retY = (Math.abs(this.myY) > THRESHOLD ? this.myY : 0);
        retX = Double.parseDouble(df.format(retX));
        retY = MODIFIER * Double.parseDouble(df.format(retY));
        Double[] newPositions = {retX, retY, this.myHeading};
        turtleTextState.setStateValues(newPositions);
    }

}