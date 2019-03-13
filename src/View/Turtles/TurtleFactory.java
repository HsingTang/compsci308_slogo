package View.Turtles;

import Model.TurtleModel;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;


/**
 * @author Hsingchih Tang
 * Produces new TurtleView objects and manages all TurtleViews that have been created in the program
 * There should be one instance of TurtleFactory for the whole program
 */
public class TurtleFactory {
    private final Image DEFAULT_TURTLE_IMG = new Image(this.getClass().getClassLoader().getResourceAsStream("Turtles/Turtle.png"));
    private Map<Integer,TurtleView> myTurtles;

    /**
     * Instantiates a TurtleFactory for producing TurtleViews later
     */
    public TurtleFactory(){
        this.myTurtles = new HashMap<>();
    }

    /**
     * @param id ID number indicating which tab this TurtleView would belong to
     * @param m back-end TurtleModel to be associated with the TurtleView
     * @return a new TurtleView object with default Turtle image
     */
    public TurtleView makeTurtle(int id, TurtleModel m){
        TurtleView newTurtle = new TurtleView(id, DEFAULT_TURTLE_IMG,m);
        myTurtles.put(id,newTurtle);
        return newTurtle;
    }

//    public TurtleView makeTurtle(int id, String imgSrc, TurtleModel m){
//        TurtleView newTurtle = new TurtleView(id, new Image(this.getClass().getClassLoader().getResourceAsStream(imgSrc)),m);
//        myTurtles.put(id,newTurtle);
//        return newTurtle;
//    }

    /**
     * @param id ID number associated to the TurtleView object being asked for
     * @return the TurtleView indicated by the id number
     */
    public TurtleView getTurtle(int id){
        return myTurtles.get(id);
    }

}
