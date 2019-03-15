package Errors;

/**
 * @author Hsingchih Tang
 * Concrete subclass that extends SlogoException
 * Can be thrown by front-end element on failure of invoking the help page when user clicks the HelpButton
 */
public class InvokeHelpPageException extends SlogoException {

    /**
     * Construct a new empty InvokeHelpPageException
     */
    public InvokeHelpPageException(){
        super();
    }

    /**
     * Construct a new InvokeHelpPageException by wrapping another Throwable
     * @param cause the Throwable to be wrapped as a InvokeHelpPageException
     */
    public InvokeHelpPageException(Throwable cause){
        super(cause);
    }

    /**
     * Construct a new InvokeHelpPageException by wrapping another Throwable and with the message argument
     * @param message the detail message associated with the new InvokeHelpPageException
     * @param cause the Throwable to be wrapped as a InvokeHelpPageException
     */
    public InvokeHelpPageException(String message, Throwable cause){
        super(message,cause);
    }

    /**
     * Construct a new InvokeHelpPageException with the message argument
     * @param message the detail message associated with the new InvokeHelpPageException
     */
    public InvokeHelpPageException(String message){
        super(message);
    }
}
