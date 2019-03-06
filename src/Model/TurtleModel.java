package Model;

import Model.ModelInterfaces.TurtleModelInterface;
import View.ObserverInterfaces.TurtleObserver;

import java.util.ArrayList;
import java.util.List;

public class TurtleModel implements TurtleModelInterface {
   private static double INITIAL_POSITION = 0.0;

   public static final double INITIAL_HEADING = 90;

   private double myX;
   private double myY;
   private double myHeading;
   private boolean penDown = true;
   private boolean isInvisible = false;
   private List<TurtleObserver> turtleObservers;


   public TurtleModel(){
      super();
      turtleObservers = new ArrayList<>();
      this.myX = INITIAL_POSITION;
      this.myY = INITIAL_POSITION;
      this.myHeading = INITIAL_HEADING;
   }

   public void moveWithAnimation() {
      notifyMoveWithAnimation();
   }

   public void setX(double x) {
      this.myX = x;
      notifyX();
   }

   public void setY(double y) {
      this.myY = y;
      notifyY();
   }

   public void setHome() {
      this.myX = INITIAL_POSITION;
      this.myY = INITIAL_POSITION;
      notifyHome();
   }

   public void setLeftRotate(double deg) {
      this.myHeading += deg;
      notifyLeftRotate();
   }

   public void setRightRotate(double deg) {
      this.myHeading -= deg;
      notifyRightRotate();
   }

   public void setHeading(double deg) {
      this.myHeading = deg;
      notifyHeading();
   }

   public void setPenDown() {
      this.penDown = true;
      notifyPenDown();
   }

   public void setPenUp() {
      this.penDown = false;
      notifyPenDown();
   }

   public void setInvisible() {
      this.isInvisible = true;
      notifyVisibilityChange();
   }

   public void setVisible() {
      this.isInvisible = false;
      notifyVisibilityChange();
   }

   public void clearPen() {
      notifyClear();
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

   public void registerTurtleObserver(TurtleObserver o) {
      turtleObservers.add(o);
   }

   public void removeTurtleObserver(TurtleObserver o) {
      turtleObservers.remove(o);
   }

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
}
