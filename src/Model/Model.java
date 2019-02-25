package Model;

import CommandTree.CommandNode;

import java.lang.reflect.Method;
import java.util.HashMap;

public class Model {

   private HashMap<String, Method> methodMap;

   public Model(){
      this.methodMap = new HashMap<>();
      this.setMethodMap();
   }

   public HashMap<String, Method> getMethodMap() {
      return this.methodMap;
   }

   private void setMethodMap(){
      Method [] methods = this.getClass().getDeclaredMethods();
      for(Method m: methods){
         m.setAccessible(true);
         this.methodMap.put(m.getName(), m);
      }
   }


   public boolean isCommand(CommandNode inNode){
      return this.methodMap.containsKey(inNode.getType());
   }

}
