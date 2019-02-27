package Model;

import Model.ModelInterfaces.ModelInterface;
import View.ObserverInterfaces.TurtleObserver;
import View.Turtles.TurtleView;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class TurtleModel implements ModelInterface {
   private static int VISIBLE = 1;
   private static int INVISIBLE = 0;
   private static Double INITIAL_POSITION = 0.0;

   public static final double INITIAL_HEADING = 90;


   private Double myX;
   private Double myY;
   private Double myXDir;
   private Double myYDir;
   private double myHeading;
   private Color myPenColor;
   private boolean penDown = true;
   private boolean isInvisible = false;
   private TurtleView myView;
   private List<TurtleObserver> turtleObservers;


   public TurtleModel(){
      super();
      //this.myView = myView;
      turtleObservers = new ArrayList<>();
      this.myX = INITIAL_POSITION;
      this.myY = INITIAL_POSITION;
      this.myXDir = INITIAL_POSITION;
      this.myYDir = INITIAL_POSITION;
      this.myHeading = INITIAL_HEADING;
   }

   /*public void execute(TurtleCommandNode command){
      /*Method method = this.getMethodMap().get(command.getType());
      ArrayList<Double> parameters = command.getParsedParameters();
      try {
         method.invoke(this, parameters);
      }
      catch(Exception e){
         System.out.println("not valid!");
      }
   }*/

   private Double forward(ArrayList<Double> params){
      System.out.println("forward" + params.get(0));
      return params.get(0);
   }
   private Double backward(ArrayList<Double> params){
      return params.get(0);
   }

   private Double left(ArrayList<Double> params){
      return params.get(0);
   }

   private Double right(ArrayList<Double> params){
      return params.get(0);
   }

   private Double setHeading(ArrayList<Double> params){
      return params.get(0);
   }

   private Double towards(ArrayList<Double> params){
      return params.get(0);
   }

   private int penUp(){
      return VISIBLE;
   }

   private int penDown(){
      return VISIBLE;
   }

   private int showTurtle(){
      return VISIBLE;
   }

   private int hideTurtle(){
      return INVISIBLE;
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
   }

   public double getX() {
      return this.myX;
   }

   public double getY() {
      return this.myY;
   }

   private Double home(){
      Double distance = 0.0;
      return distance;
   }

   public double getHeading() {
      return this.myHeading;
   }

   public boolean getPenDown() {
      return this.getPenDown();
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
}
