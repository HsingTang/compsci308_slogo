package Errors;

/**
 * @author Hsingchih Tang
 * Concrete subclass that extends SlogoException
 * Can be thrown by front end when an invalid file is uploaded as the Turtle's image
 */
public class MalformedTurtleImgException extends SlogoException {

    /**
     * Construct a new empty MalformedTurtleImgException
     */
    public MalformedTurtleImgException(){
        super();
    }

    /**
     * Construct a new MalformedTurtleImgException by wrapping another Throwable
     * @param cause the Throwable to be wrapped as a MalformedTurtleImgException
     */
    public MalformedTurtleImgException(Throwable cause){
        super(cause);
    }

    /**
     * Construct a new MalformedTurtleImgException by wrapping another Throwable and with the message argument
     * @param message the detail message associated with the new MalformedTurtleImgException
     * @param cause the Throwable to be wrapped as a MalformedTurtleImgException
     */
    public MalformedTurtleImgException(String message, Throwable cause){
        super(message,cause);
    }

    /**
     * Construct a new MalformedTurtleImgException with the message argument
     * @param message the detail message associated with the new MalformedTurtleImgException
     */
    public MalformedTurtleImgException(String message){
        super(message);
    }
}
