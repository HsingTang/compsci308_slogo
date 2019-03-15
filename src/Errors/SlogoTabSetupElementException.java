package Errors;

/**
 * @author Hsingchih Tang
 * Concrete subclass that extends SlogoException
 * Can be thrown on failure of initializing front-end GUI elements (invalid methods for buttons to invoke, etc.)
 */
public class SlogoTabSetupElementException extends SlogoException {

    /**
     * Construct a new empty SlogoTabSetupElementException
     */
    public SlogoTabSetupElementException(){
        super();
    }

    /**
     * Construct a new SlogoTabSetupElementException by wrapping another Throwable
     * @param cause the Throwable to be wrapped as a SlogoTabSetupElementException
     */
    public SlogoTabSetupElementException(Throwable cause){
        super(cause);
    }

    /**
     * Construct a new SlogoTabSetupElementException by wrapping another Throwable and with the message argument
     * @param message the detail message associated with the new SlogoTabSetupElementException
     * @param cause the Throwable to be wrapped as a SlogoTabSetupElementException
     */
    public SlogoTabSetupElementException(String message, Throwable cause){
        super(message,cause);
    }

    /**
     * Construct a new SlogoTabSetupElementException with the message argument
     * @param message the detail message associated with the new SlogoTabSetupElementException
     */
    public SlogoTabSetupElementException(String message){
        super(message);
    }
}
