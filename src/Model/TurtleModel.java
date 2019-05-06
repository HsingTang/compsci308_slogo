package Model;

import Model.ModelInterfaces.TurtleModelInterface;
import State.TurtleState;
import View.ObserverInterfaces.TurtleObserver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Model for the turtle on the backend. I've included this as part of my masterpiece because it shows
 * part of the observer/observable design pattern I implemented. It extends an interface that defines what methods
 * it must use. Even more, the only dependency from the front-end is on the turtle observer interface, which only
 * implements the "update" method. This means that on final change (in TreeParentNode), the view will update. 
 *
 * @author Eric Lin
 */
public class TurtleModel implements TurtleModelInterface {
   private static double INITIAL_POSITION = 0.0;

   public static final double INITIAL_HEADING = 90;

   private double myX;
   private double myY;
   private double myHeading;
   private boolean penDown = true;
   private boolean isInvisible = false;
   private boolean isPenInvisible = false;
   private boolean isMoving = false;
   private List<TurtleObserver> turtleObservers;
   private Queue<TurtleState> modelStates;

   /**
    * creates an instance of the turtle model
    */
   public TurtleModel(){
      turtleObservers = new ArrayList<>();
      this.myX = INITIAL_POSITION;
      this.myY = INITIAL_POSITION;
      this.myHeading = INITIAL_HEADING;
      this.modelStates = new LinkedList<>();
   }

   /**
    * returns the queue of turtle states
    *
    * @return  queue of turtle states
    */
   public Queue<TurtleState> getModelStates() {
      return this.modelStates;
   }

   /**
    * sets new x of the turtle model
    *
    * @param x    new x
    */
   public void setX(double x) {
      this.myX = x;
      this.isMoving = true;
   }

   /**
    * sets new y of the turtle model
    *
    * @param y    new y
    */
   public void setY(double y) {
      this.myY = y;
      this.isMoving = true;
   }

   /**
    * sets position of turtle model to center (0,0)
    */
   public void setHome() {
      this.myX = INITIAL_POSITION;
      this.myY = INITIAL_POSITION;
      this.isMoving = true;
   }

   /**
    * sets the new heading of turtle after left turn
    *
    * @param deg  degrees to turn left
    */
   public void setLeftRotate(double deg) {
      this.myHeading += deg;
      this.isMoving = false;
   }

   /**
    * sets the new heading of turtle after right turn
    *
    * @param deg  degrees to turn right
    */
   public void setRightRotate(double deg) {
      this.myHeading -= deg;
      this.isMoving = false;
   }

   /**
    * sets the new heading of the turtle
    *
    * @param deg  new heading
    */
   public void setHeading(double deg) {
      this.myHeading = deg;
      this.isMoving = false;
   }

   /**
    * sets the pen down of turtle to true
    */
   public void setPenDown() {
      this.penDown = true;
      this.isMoving = false;
   }

   /**
    * sets turtle model pen down to false
    */
   public void setPenUp() {
      this.penDown = false;
      this.isMoving = false;
   }

   /**
    * sets turtle model invisible state to true
    */
   public void setInvisible() {
      this.isInvisible = true;
      this.isMoving = false;
   }

   /**
    * sets turtle model invisible state to false
    */
   public void setVisible() {
      this.isInvisible = false;
      this.isMoving = false;
   }

   /**
    * sets the pen invisibility to true
    */
   public void clearPen() {
      this.isPenInvisible = true;
   }

   /**
    * get X of turtle
    *
    * @return  x position of turtle
    */
   public double getX() {
      return this.myX;
   }

   /**
    * get Y position of turtle
    *
    * @return  y position of turtle
    */
   public double getY() {
      return this.myY;
   }

   /**
    * gets the heading of the turtle
    *
    * @return  heading of the turtle
    */
   public double getHeading() {
      return this.myHeading;
   }

   /**
    * gets whether the pen is up or down
    *
    * @return  penDown boolean of turtle
    */
   public boolean getPenDown() {
      return this.penDown;
   }

   /**
    * gets whether turtle is invisible
    *
    * @return  visibility state of turtle
    */
   public boolean isInvisible() {
      return this.isInvisible;
   }

   /**
    * gets whether pen is invisible
    *
    * @return  visibility state of the pen
    */
   public boolean isPenInvisible() {
      return this.isPenInvisible;
   }

   /**
    * sets pen visibility to false
    */
   public void setPenVisible() {
      this.isPenInvisible = false;
   }

   /**
    * gets whether turtle is moving after a command
    *
    * @return  whether a turtle is moving in a line
    */
   public boolean isMoving() {
      return this.isMoving;
   }

   /**
    * registers a turtle observer
    *
    * @param o turtle observer
    */
   public void registerTurtleObserver(TurtleObserver o) {
      turtleObservers.add(o);
   }

   /**
    * removes a turtle observer
    *
    * @param o turtle observer
    */
   public void removeTurtleObserver(TurtleObserver o) {
      turtleObservers.remove(o);
   }

}
