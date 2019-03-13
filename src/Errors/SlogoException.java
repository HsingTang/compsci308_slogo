package Errors;

/**
 * @author Hsingchih Tang
 * Abstract super class that is able to wrap unexpected Java Exceptions
 * and is also extended by concrete subclasses for expected SlogoExceptions (invalid commands, setup failure, etc.)
 */
public abstract class SlogoException extends RuntimeException {

    /**
     * Construct a new empty SlogoException
     */
    public SlogoException(){
        super();
    }

    /**
     * Construct a new SlogoException by wrapping another Throwable
     * @param cause the Throwable to be wrapped as a SlogoException
     */
    public SlogoException(Throwable cause){
        super(cause);
    }

    /**
     * Construct a new SlogoException by wrapping another Throwable and with the message argument
     * @param message the detail message associated with the new SlogoException
     * @param cause the Throwable to be wrapped as a SlogoException
     */
    public SlogoException(String message, Throwable cause){
        super(message,cause);
    }

    /**
     * Construct a new SlogoException with the message argument
     * @param message the detail message associated with the new SlogoException
     */
    public SlogoException(String message){
        super(message);
    }

}
