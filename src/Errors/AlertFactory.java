package Errors;

import java.util.ResourceBundle;

public class AlertFactory {
    static final String ALERT_CONTENT = "errors/ExceptionAlertContent";
    static final String ALERT_HEADER = "errors/ExceptionAlertHeader";
    static final String ALERT_TITLE = "errors/ExceptionAlertTitle";

    private ResourceBundle contentResource;
    private ResourceBundle headerResource;
    private ResourceBundle titleResource;


    public AlertFactory(){
        contentResource = ResourceBundle.getBundle(ALERT_CONTENT);
        headerResource = ResourceBundle.getBundle(ALERT_HEADER);
        titleResource = ResourceBundle.getBundle(ALERT_TITLE);
    }

    public SlogoAlert getAlert(Exception exp){
        String[] expNameArr = exp.getClass().getName().split("\\.");
        String expName = expNameArr[expNameArr.length-1];
        SlogoAlert ret = new SlogoAlert();
        ret.setText(titleResource.getString(expName),headerResource.getString(expName),contentResource.getString(expName));
        return ret;
    }
}
