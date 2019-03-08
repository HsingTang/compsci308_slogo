package Errors;

public class MalformedTurtleImgException extends SlogoException {
    public MalformedTurtleImgException(){
        super();
    }

    public MalformedTurtleImgException(Throwable cause){
        super(cause);
    }

    /**
     * Construct a new SlogoException by wrapping another Throwable and with the message argument
     * @param message the detail message associated with the new SlogoException
     * @param cause the Throwable to be wrapped as a SlogoException
     */
    public MalformedTurtleImgException(String message, Throwable cause){
        super(message,cause);
    }

    /**
     * Construct a new SlogoException with the message argument
     * @param message the detail message associated with the new SlogoException
     */
    public MalformedTurtleImgException(String message){
        super(message);
    }
}
