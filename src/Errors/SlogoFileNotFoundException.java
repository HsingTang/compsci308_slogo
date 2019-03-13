package Errors;

/**
 * @author Hsingchih Tang
 * Concrete subclass that extends SlogoException
 * Can be thrown when a file is missing (usually some source file used by the back-end parsing/execution classes)
 */
public class SlogoFileNotFoundException extends SlogoException{
    /**
     * Construct a new empty SlogoFileNotFoundException
     */
    public SlogoFileNotFoundException(){
        super();
    }

    /**
     * Construct a new SlogoFileNotFoundException by wrapping another Throwable
     * @param cause the Throwable to be wrapped as a SlogoFileNotFoundException
     */
    public SlogoFileNotFoundException(Throwable cause){
        super(cause);
    }

    /**
     * Construct a new SlogoFileNotFoundException by wrapping another Throwable and with the message argument
     * @param message the detail message associated with the new SlogoFileNotFoundException
     * @param cause the Throwable to be wrapped as a SlogoFileNotFoundException
     */
    public SlogoFileNotFoundException(String message, Throwable cause){
        super(message,cause);
    }

    /**
     * Construct a new SlogoFileNotFoundException with the message argument
     * @param message the detail message associated with the new SlogoFileNotFoundException
     */
    public SlogoFileNotFoundException(String message){
        super(message);
    }
}
