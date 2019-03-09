package View.GUIFeatures;

import Errors.SlogoTabSetupElementException;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.ComboBoxBase;
import javafx.scene.layout.Pane;

import java.lang.reflect.Method;
import java.util.ResourceBundle;

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

    public ElementFactory(Pane hostPane) {
        myElementClassResources = ResourceBundle.getBundle(ELEMENT_CLASS_PATH_RESOURCE);
        myElementMethodResources = ResourceBundle.getBundle(ELEMENT_METHOD_RESOURCE);
        myElementArgResources = ResourceBundle.getBundle(ELEMENT_ARGUMENT_RESOURCE);
        myHostPane = hostPane;
    }

    public Node makeElement(String property) throws SlogoTabSetupElementException {
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
        } catch (Exception exp) {
            throw new SlogoTabSetupElementException();
        }
    }


    private void setInvokeMethod (String property, Node element, Method myMethod) throws SlogoTabSetupElementException {
        final String[] myArgs;
        if (myElementArgResources.containsKey(property)) {
            myArgs = myElementArgResources.getString(property).split(",");
        } else {
            myArgs = null;
        }
        if (element instanceof Button) {
            ((ButtonBase) element).setOnAction(e -> {
                try {
                    myMethod.invoke(myHostPane, (Object[]) myArgs);
                } catch(Exception exp){
                    throw new SlogoTabSetupElementException();
                }
            });
        } else {
            ((ComboBoxBase<Object>) element).setOnAction(e -> {
                try {
                    myMethod.invoke(myHostPane, (Object[]) myArgs);
                } catch (Exception exp){
                    throw new SlogoTabSetupElementException();
                }
            });
        }

    }


}
