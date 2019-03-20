package Model;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mary Gooneratne
 * Model class that holds valid commands
 */
public class Model {
   private final Map<String, Method> methodMap;

   /**
    * Instantiates Model object
    */
   public Model(){
      this.methodMap = new HashMap<>();
      this.setMethodMap();
   }

   /**
    * @return map of valid command methods
    */
   public Map<String, Method> getMethodMap() {
      return this.methodMap;
   }

   /**
    * Sets method map for Model by extract declared methods of class
    */
   private void setMethodMap(){
      Method [] methods = this.getClass().getDeclaredMethods();
      for(Method m: methods){
         m.setAccessible(true);
         this.methodMap.put(m.getName(), m);
      }
   }
}
