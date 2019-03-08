package Model;

import Model.ModelInterfaces.TurtleModelInterface;
import State.TurtleState;
import View.ObserverInterfaces.TurtleObserver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

   public TurtleModel(){
      super();
      turtleObservers = new ArrayList<>();
      this.myX = INITIAL_POSITION;
      this.myY = INITIAL_POSITION;
      this.myHeading = INITIAL_HEADING;
      this.modelStates = new LinkedList<>();
   }

   public Queue<TurtleState> getModelStates() {
      return this.modelStates;
   }

   public void setX(double x) {
      this.myX = x;
      this.isMoving = true;
   }

   public void setY(double y) {
      this.myY = y;
      this.isMoving = true;
   }

   public void setHome() {
      this.myX = INITIAL_POSITION;
      this.myY = INITIAL_POSITION;
      this.isMoving = true;
   }

   public void setLeftRotate(double deg) {
      this.myHeading += deg;
      this.isMoving = false;
   }

   public void setRightRotate(double deg) {
      this.myHeading -= deg;
      this.isMoving = false;
   }

   public void setHeading(double deg) {
      this.myHeading = deg;
      this.isMoving = false;
   }

   public void setPenDown() {
      this.penDown = true;
      this.isMoving = false;
   }

   public void setPenUp() {
      this.penDown = false;
      this.isMoving = false;
   }

   public void setInvisible() {
      this.isInvisible = true;
      this.isMoving = false;
   }

   public void setVisible() {
      this.isInvisible = false;
      this.isMoving = false;
   }

   public void clearPen() {
      this.isPenInvisible = true;
   }

   public double getX() {
      return this.myX;
   }

   public double getY() {
      return this.myY;
   }

   public double getHeading() {
      return this.myHeading;
   }

   public boolean getPenDown() {
      return this.penDown;
   }

   public boolean isInvisible() {
      return this.isInvisible;
   }

   public boolean isPenInvisible() {
      return this.isPenInvisible;
   }

   public void setPenVisible() {
      this.isPenInvisible = false;
   }

   public boolean isMoving() {
      return this.isMoving;
   }

   public void registerTurtleObserver(TurtleObserver o) {
      turtleObservers.add(o);
   }

   public void removeTurtleObserver(TurtleObserver o) {
      turtleObservers.remove(o);
   }

}
