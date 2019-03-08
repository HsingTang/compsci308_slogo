package View.GUIFeatures;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.ComboBoxBase;
import javafx.scene.layout.Pane;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ResourceBundle;

public class ElementFactory {
    private final String ELEMENT_CLASS_PATH_RESOURCE = "elements/PaneElementClassPath";
    private final String ELEMENT_METHOD_RESOURCE = "elements/PaneElementMethod";
    private final String ELEMENT_ARGUMENT_RESOURCE = "elements/PaneElementArgument";

    private ResourceBundle myElementClassResources;
    private ResourceBundle myElementMethodResources;
    private ResourceBundle myElementArgResources;
    private Pane myHostPane;

    public ElementFactory(Pane hostPane){
        myElementClassResources = ResourceBundle.getBundle(ELEMENT_CLASS_PATH_RESOURCE);
        myElementMethodResources = ResourceBundle.getBundle(ELEMENT_METHOD_RESOURCE);
        myElementArgResources = ResourceBundle.getBundle(ELEMENT_ARGUMENT_RESOURCE);
        myHostPane = hostPane;
    }

    public Node makeElement(String property) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        var newElement = Class.forName(myElementClassResources.getString(property)).getConstructor().newInstance();
        if(myElementMethodResources.containsKey(property)){
            String[] methodInfo = myElementMethodResources.getString(property).split(",");
            Method myMethod;
            if (methodInfo.length==2){
                myMethod = myHostPane.getClass().getDeclaredMethod(methodInfo[1]);
                setInvokeMethod(property,(Node)newElement,myMethod,newElement.getClass());
            }else if(methodInfo.length==3){
                myMethod = myHostPane.getClass().getDeclaredMethod(methodInfo[1],Class.forName(methodInfo[2]));
                setInvokeMethod(property,(Node)newElement,myMethod,newElement.getClass());
            }
        }
        return (Node)newElement;
    }


    private void setInvokeMethod(String property, Node element, Method myMethod, Class b){
        final String[] myArgs;
        if(myElementArgResources.containsKey(property)) {
            myArgs = myElementArgResources.getString(property).split(",");
        }else{
            myArgs = null;
        }
        if(element instanceof Button){
            ((ButtonBase)element).setOnAction(e-> {
                try {
                    myMethod.invoke(myHostPane,(Object[])myArgs);
                } catch (Exception exp) {
                    exp.printStackTrace();
                }
            });
        }else{
            ((ComboBoxBase<Object>)element).setOnAction(e-> {
                try {
                    myMethod.invoke(myHostPane,(Object[])myArgs);
                } catch (Exception exp) {
                    exp.printStackTrace();
                }
            });
        }

    }


}
