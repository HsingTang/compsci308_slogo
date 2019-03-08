package Errors;

public class InvokeHelpPageException extends SlogoException {
    public InvokeHelpPageException(){
        super();
    }

    public InvokeHelpPageException(Throwable cause){
        super(cause);
    }

    /**
     * Construct a new SlogoException by wrapping another Throwable and with the message argument
     * @param message the detail message associated with the new SlogoException
     * @param cause the Throwable to be wrapped as a SlogoException
     */
    public InvokeHelpPageException(String message, Throwable cause){
        super(message,cause);
    }

    /**
     * Construct a new SlogoException with the message argument
     * @param message the detail message associated with the new SlogoException
     */
    public InvokeHelpPageException(String message){
        super(message);
    }
}
