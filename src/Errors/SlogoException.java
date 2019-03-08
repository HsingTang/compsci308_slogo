package Errors;

public abstract class SlogoException extends RuntimeException {

    public SlogoException(){
        super();
    }

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
