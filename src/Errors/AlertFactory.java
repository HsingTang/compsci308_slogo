package Errors;

import java.util.ResourceBundle;

/**
 * @author Hsingchih Tang
 * Factory class for handling SlogoExceptions in the program
 * Displays alert dialogues for each type of SlogoException with different alert messages read from resource files
 */
public class AlertFactory {
    static final String ALERT_CONTENT = "errors/ExceptionAlertContent";
    static final String ALERT_HEADER = "errors/ExceptionAlertHeader";
    static final String ALERT_TITLE = "errors/ExceptionAlertTitle";

    private ResourceBundle contentResource;
    private ResourceBundle headerResource;
    private ResourceBundle titleResource;

    /**
     * Instantiates a new instance of AlertFactory and sets up the resource files
     */
    public AlertFactory(){
        contentResource = ResourceBundle.getBundle(ALERT_CONTENT);
        headerResource = ResourceBundle.getBundle(ALERT_HEADER);
        titleResource = ResourceBundle.getBundle(ALERT_TITLE);
    }

    /**
     * Produces a new SlogoAlert with appropriate messages based on the Exception type
     * @param exp SlogoException to handle
     * @return the SlogoAlert for this Exception
     */
    public SlogoAlert getAlert(Exception exp){
        String[] expNameArr = exp.getClass().getName().split("\\.");
        String expName = expNameArr[expNameArr.length-1];
        SlogoAlert ret = new SlogoAlert();
        System.out.println(expName);
        ret.setText(titleResource.getString(expName),headerResource.getString(expName),contentResource.getString(expName));
        return ret;
    }
}
