package Model;

import CommandTree.TurtleCommandNode;
import Model.ModelInterfaces.TurtleModelInterface;
import View.ObserverInterfaces.TurtleObserver;
import View.Turtles.TurtleView;
import javafx.scene.paint.Color;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TurtleModel  extends Model implements TurtleModelInterface{
   private static int VISIBLE = 1;
   private static int INVISIBLE = 0;
   private static Double INITIAL_POSITION = 0.0;


   private Double myX;
   private Double myY;
   private Double myXDir;
   private Double myYDir;
   private double myAngle;
   private Color myPenColor;
   private boolean penDown;
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
   }

   public void execute(TurtleCommandNode command){
      Method method = this.getMethodMap().get(command.getType());
      ArrayList<Double> parameters = command.getParsedParameters();
      try {
         method.invoke(this, parameters);
      }
      catch(Exception e){
         System.out.println("not valid!");
      }
   }

   private void setMethodMap(){
      Method [] methods = this.getClass().getDeclaredMethods();
      for(Method m: methods){
         m.setAccessible(true);
         this.getMethodMap().put(m.getName(), m);
      }
   }

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

   public void setX(double x) { // Must be called by controller!!!!
      this.myX = x;
      notifyX();
   }

   public double getX() {
      return this.myX;
   }

   private Double home(){
      Double distance = 0.0;
      return distance;
   }

   private Double clearScreen(){
      return this.home();
   }

   public void registerTurtleObserver(TurtleObserver o) {
      turtleObservers.add(o);
   }

   public void removeTurtleObserver(TurtleObserver o) {
      turtleObservers.remove(o);
   }

   public void notifyX() {
      for (TurtleObserver o : turtleObservers) {
         o.updateX();
      }
   }
}
