package Errors;

/**
 * @author Hsingchih Tang
 * Concrete subclass that extends SlogoException
 * Can be thrown by back-end Parser or CommandHandler on failure of command execution caused by invalid commands
 */
public class InvalidCommandException extends SlogoException {

    /**
     * Construct a new empty InvalidCommandException
     */
    public InvalidCommandException(){
        super();
    }

    /**
     * Construct a new InvalidCommandException by wrapping another Throwable
     * @param cause the Throwable to be wrapped as a InvalidCommandException
     */
    public InvalidCommandException(Throwable cause){
        super(cause);
    }

    /**
     * Construct a new InvalidCommandException by wrapping another Throwable and with the message argument
     * @param message the detail message associated with the new InvalidCommandException
     * @param cause the Throwable to be wrapped as a InvalidCommandException
     */
    public InvalidCommandException(String message, Throwable cause){
        super(message,cause);
    }

    /**
     * Construct a new InvalidCommandException with the message argument
     * @param message the detail message associated with the new InvalidCommandException
     */
    public InvalidCommandException(String message){
        super(message);
    }
}
