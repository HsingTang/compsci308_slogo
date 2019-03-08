package Errors;

public class InvalidCommandException extends SlogoException {
    public InvalidCommandException(){
        super();
    }

    public InvalidCommandException(Throwable cause){
        super(cause);
    }

    /**
     * Construct a new SlogoException by wrapping another Throwable and with the message argument
     * @param message the detail message associated with the new SlogoException
     * @param cause the Throwable to be wrapped as a SlogoException
     */
    public InvalidCommandException(String message, Throwable cause){
        super(message,cause);
    }

    /**
     * Construct a new SlogoException with the message argument
     * @param message the detail message associated with the new SlogoException
     */
    public InvalidCommandException(String message){
        super(message);
    }
}
