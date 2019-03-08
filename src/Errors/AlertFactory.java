package Errors;

import java.util.ResourceBundle;

public class AlertFactory {
    final String ALERT_CONTENT = "errors/ExceptionAlertContent";
    final String ALERT_HEADER = "errors/ExceptionAlertHeader";
    final String ALERT_TITLE = "errors/ExceptionAlertTitle";

    private ResourceBundle contentResource;
    private ResourceBundle headerResource;
    private ResourceBundle titleResource;


    public AlertFactory(){
        contentResource = ResourceBundle.getBundle(ALERT_CONTENT);
        headerResource = ResourceBundle.getBundle(ALERT_HEADER);
        titleResource = ResourceBundle.getBundle(ALERT_TITLE);
    }

    public SlogoAlert getAlert(Exception exp){
        String expName = exp.getClass().getName();
        SlogoAlert ret = new SlogoAlert();
        ret.setText(titleResource.getString(expName),headerResource.getString(expName),contentResource.getString(expName));
        return ret;
    }
}
