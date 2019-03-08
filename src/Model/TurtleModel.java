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

   public void moveWithAnimation() {
      //notifyMoveWithAnimation();
   }

   public void setX(double x) {
      this.myX = x;
      this.isMoving = true;
      //notifyX();
   }

   public void setY(double y) {
      this.myY = y;
      this.isMoving = true;
      //notifyY();
   }

   public void setHome() {
      this.myX = INITIAL_POSITION;
      this.myY = INITIAL_POSITION;
      this.isMoving = true;
      //notifyHome();
   }

   public void setLeftRotate(double deg) {
      this.myHeading += deg;
      this.isMoving = false;
      //notifyLeftRotate();
   }

   public void setRightRotate(double deg) {
      this.myHeading -= deg;
      this.isMoving = false;
      //notifyRightRotate();
   }

   public void setHeading(double deg) {
      this.myHeading = deg;
      this.isMoving = false;
      //notifyHeading();
   }

   public void setPenDown() {
      this.penDown = true;
      this.isMoving = false;
      //notifyPenDown();
   }

   public void setPenUp() {
      this.penDown = false;
      this.isMoving = false;
      //notifyPenDown();
   }

   public void setInvisible() {
      this.isInvisible = true;
      this.isMoving = false;
      //notifyVisibilityChange();
   }

   public void setVisible() {
      this.isInvisible = false;
      this.isMoving = false;
      //notifyVisibilityChange();
   }

   public void clearPen() {
      //notifyClear();
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

   /*
    private void notifyX() {
      for (TurtleObserver o : turtleObservers) {
         o.updateX();
      }
   }

   private void notifyY() {
      for (TurtleObserver o : turtleObservers) {
         o.updateY();
      }
   }

   private void notifyMoveWithAnimation() {
      for (TurtleObserver o : turtleObservers) {
         o.updateMove();
      }
   }

   private void notifyLeftRotate() {
      for (TurtleObserver o : turtleObservers) {
         o.updateLeftRotate();
      }
   }

   private void notifyRightRotate() {
      for (TurtleObserver o : turtleObservers) {
         o.updateRightRotate();
      }
   }

   private void notifyHeading() {
      for (TurtleObserver o : turtleObservers) {
         o.updateHeading();
      }
   }

   private void notifyPenDown() {
      for (TurtleObserver o : turtleObservers) {
         o.updatePenDown();
      }
   }

   private void notifyHome() {
      for (TurtleObserver o : turtleObservers) {
         o.updateHome();
      }
   }

   private void notifyVisibilityChange() {
      for (TurtleObserver o : turtleObservers) {
         o.updateVisibility();
      }
   }

   private void notifyClear() {
      for (TurtleObserver o : turtleObservers) {
         o.updateClear();
      }
   }
   */
}
