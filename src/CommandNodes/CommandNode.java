package CommandNodes;

import Errors.SlogoException;
import Handlers.HandlerInterfaces.CommandHandlerInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mary Gooneratne
 * Abstract tree node object to store slogo commands
 */
public abstract class CommandNode {

   private static final int INIT = 0;

   protected final CommandHandlerInterface myHandler;
   private List<CommandNode> myChildren;
   private CommandNode myParent;
   private int myNumParams;
   private Double myReturnValue;
   private int myChildrenIndex;
   private double myNumRepeat;

   /**
    * Instantiates new CommandNode object
    * @param inHandler handler that executes commands
    */
   public CommandNode(CommandHandlerInterface inHandler) {
      this.myChildren = new ArrayList<>();
      this.myHandler = inHandler;
      this.myNumParams = INIT;
      this.myChildrenIndex = 0;
      this.myNumRepeat = 1;
   }

   /**
    * Instantiates new CommandNode object
    * @param inHandler handler that executes commands
    * @param inParent parent of created CommandNode
    */
   public CommandNode(CommandHandlerInterface inHandler, CommandNode inParent){
      this.myChildren = new ArrayList<>();
      this.myHandler = inHandler;
      this.myNumParams = INIT;
      this.myParent = inParent;
      this.myChildrenIndex = 0;
      this.myNumRepeat = 1;

}

   /**
    * Adds child to current CommandNode
    * @param newChild commandNode to be added as child
    */
   public void addChild(CommandNode newChild){
      newChild.setParent(this);
      this.myChildren.add(newChild);
      this.myNumParams--;
   }

   /**
    * @return children of CommandNode
    */
   public List<CommandNode> getMyChildren(){
      return this.myChildren;
   }

   /**
    * Sets new parent of CommandNode
    * @param newParent for the CommandNode to be the child of
    */
   public void setParent(CommandNode newParent){
      this.myParent = newParent;
   }

   /**
    * @return parent of CommandNode
    */
   public CommandNode getParent(){
      return this.myParent;
   }

   private CommandNode getNextNode(){
      CommandNode nextNode = null;
      try{
         nextNode = this.getMyChildren().get(this.myChildrenIndex);
         this.myChildrenIndex++;
      }
      catch(Exception e){
         /**
          * Error regarding no child
          */
      }
      return nextNode;
   }

   protected double getNextDouble(){
      double value = 0;
      CommandNode nextNode = (this.getNextNode());
      return nextNode.getMyReturnValue();
   }

   /**
    * Checks to see if current CommandNode has a sufficient number of parameters (nodes/children)
    * @return true if sufficient number of children, else false
    */
   public boolean childrenFilled() {
      return this.myNumParams == 0;
   }

   /**
    * @return number of times commandNode should be executed
    */
   public double getMyNumRepeat() { return this.myNumRepeat; }


   /**
    * @return return value of the CommandNode
    */
   public Double getMyReturnValue(){
      return this.myReturnValue;
   }

   protected void setMyNumParams(int num){
      this.myNumParams = num;
   }

   /**
    * Sets value for number of times command is to be repeated
    * @param num number of times to be repeated
    */
   public void setMyNumRepeat(double num) { this.myNumRepeat = num; }

   private void resetIndex(){
      this.myChildrenIndex = 0;
   }

   /**
    * @return number of parameters of this command node
    */
   public int getMyNumParams(){
      return this.myNumParams;
   }

   /**
    * The full execution method for CommandNode objects that executes the node and resets number of children
    * @throws SlogoException
    */
   public void fullExecute()throws SlogoException{
      try{
         this.execute();
         this.resetIndex();
      }catch (SlogoException e){
         throw e;
      }

   }

   /**
    * Abstract method parses command parameters and calls appropriate execution method on handler
    */
   public abstract void execute() throws SlogoException;

   protected abstract void parseParameters();

   protected void setMyReturnValue(Double returnValue)
   {
      this.myReturnValue = returnValue;
   }

}
