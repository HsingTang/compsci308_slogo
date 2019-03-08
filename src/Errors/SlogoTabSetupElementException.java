package Errors;

public class SlogoTabSetupElementException extends SlogoException {
    public SlogoTabSetupElementException(){
        super();
    }

    public SlogoTabSetupElementException(Throwable cause){
        super(cause);
    }

    /**
     * Construct a new SlogoException by wrapping another Throwable and with the message argument
     * @param message the detail message associated with the new SlogoException
     * @param cause the Throwable to be wrapped as a SlogoException
     */
    public SlogoTabSetupElementException(String message, Throwable cause){
        super(message,cause);
    }

    /**
     * Construct a new SlogoException with the message argument
     * @param message the detail message associated with the new SlogoException
     */
    public SlogoTabSetupElementException(String message){
        super(message);
    }
}
