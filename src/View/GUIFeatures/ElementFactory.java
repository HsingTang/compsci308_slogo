package View.GUIFeatures;

import Errors.SlogoException;
import Errors.SlogoTabSetupElementException;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.ComboBoxBase;
import javafx.scene.layout.Pane;

import java.lang.reflect.Method;
import java.util.ResourceBundle;

/**
 * @author Hsingchih Tang
 * Factory class that flexibly arranges the set-on-action functions for buttons/choosers based on resource file contents
 */
public class ElementFactory {
    static final String ELEMENT_CLASS_PATH_RESOURCE = "elements/PaneElementClassPath";
    static final String ELEMENT_METHOD_RESOURCE = "elements/PaneElementMethod";
    static final String ELEMENT_ARGUMENT_RESOURCE = "elements/PaneElementArgument";
    static final Integer INFO_LENGTH_WITHOUT_ARGUMENT = 2;
    static final Integer INFO_LENGTH_WITH_ARGUMENT = 3;
    static final Integer METHOD_NAME_INDEX = 1;
    static final Integer METHOD_ARG_INDEX = 2;

    private ResourceBundle myElementClassResources;
    private ResourceBundle myElementMethodResources;
    private ResourceBundle myElementArgResources;
    private Pane myHostPane;

    /**
     * Instantiates an ElementFactory object and sets up the resource file
     * @param hostPane the Pane (either TopPane or BottomPane section of a tab) which invokes the constructor
     */
    public ElementFactory(Pane hostPane) {
        myElementClassResources = ResourceBundle.getBundle(ELEMENT_CLASS_PATH_RESOURCE);
        myElementMethodResources = ResourceBundle.getBundle(ELEMENT_METHOD_RESOURCE);
        myElementArgResources = ResourceBundle.getBundle(ELEMENT_ARGUMENT_RESOURCE);
        myHostPane = hostPane;
    }

    /**
     * Uses reflection to instantiate the element that the caller is asking for and sets up the
     * target function to invoke on user action by looking up the input argument in resource file
     * @param property String specifying the element type (specific Button/Chooser class) to instantiate
     * @return the element specified by input argument, and equipped with the appropriate set-on-action method
     * @throws SlogoException on failure of instantiating the element or wrong method argument that triggers exceptions
     */
    public Node makeElement(String property) throws SlogoException {
        try {
            var newElement = Class.forName(myElementClassResources.getString(property)).getConstructor().newInstance();
            if (myElementMethodResources.containsKey(property)) {
                String[] methodInfo = myElementMethodResources.getString(property).split(",");
                Method myMethod;
                if (methodInfo.length == INFO_LENGTH_WITHOUT_ARGUMENT) {
                    myMethod = myHostPane.getClass().getDeclaredMethod(methodInfo[METHOD_NAME_INDEX]);
                    setInvokeMethod(property, (Node) newElement, myMethod);
                } else if (methodInfo.length == INFO_LENGTH_WITH_ARGUMENT) {
                    myMethod = myHostPane.getClass().getDeclaredMethod(methodInfo[METHOD_NAME_INDEX], Class.forName(methodInfo[METHOD_ARG_INDEX]));
                    setInvokeMethod(property, (Node) newElement, myMethod);
                }
            }
            return (Node) newElement;
        } catch(SlogoException exp){
            throw exp;
        } catch (Exception exp) {
            throw new SlogoTabSetupElementException();
        }
    }


    /**
     * Sets up the element's target function to invoke when triggered by user action
     * Treats ButtonBase and ComboBoxBase elements separately
     * @param property String specifying the element type
     * @param element the element to manage
     * @param myMethod the method to set-on-action
     * @throws SlogoException on failure of instantiating the element or wrong method argument that triggers exceptions
     */
    private void setInvokeMethod (String property, Node element, Method myMethod) throws SlogoException {
        final String[] myArgs;
        if (myElementArgResources.containsKey(property)) {
            myArgs = myElementArgResources.getString(property).split(",");
        } else {
            myArgs = null;
        }
        if (element instanceof Button) {
            ((ButtonBase) element).setOnAction(e -> {
                try {
                    safeInvoke(myMethod, myArgs);
                } catch(SlogoException exp) {
                    throw exp;
                }
            });
        } else {
            ((ComboBoxBase<Object>) element).setOnAction(e -> {
                try {
                    safeInvoke(myMethod, myArgs);
                } catch(SlogoException exp) {
                    throw exp;
                }
            });
        }

    }

    /**
     * Call invoke on the function with specified arguments
     * @param myMethod the target function to invoke
     * @param myArgs input arguments into the method
     * @throws SlogoException on wrong method argument or exceptions at the execution of target function
     */
    private void safeInvoke(Method myMethod, String[] myArgs) throws SlogoException{
        try {
            myMethod.invoke(myHostPane, (Object[]) myArgs);
        } catch(SlogoException exp){
            throw exp;
        } catch (Exception exp){
            throw new SlogoTabSetupElementException();
        }
    }

}
