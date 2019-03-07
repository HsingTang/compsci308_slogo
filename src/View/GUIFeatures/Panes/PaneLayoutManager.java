package View.GUIFeatures.Panes;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.util.ResourceBundle;

public class PaneLayoutManager {
    private final String ELEMENT_LAYOUT_RESOURCE = "elements/PaneElementLayout";
    private GridPane myPane;
    private ResourceBundle myElementLayoutResources;

    public PaneLayoutManager(GridPane p){
        myPane = p;
        myElementLayoutResources = ResourceBundle.getBundle(ELEMENT_LAYOUT_RESOURCE);
    }

    public void setLayout(Node element){
        String[] keyArr;
        if(element instanceof Text){
            keyArr = ((Text) element).getText().split("\\.");
        }else{
            keyArr = element.getClass().toString().split("\\.");
        }
        System.out.println(keyArr[keyArr.length-1]);
        String[] layoutArgs = myElementLayoutResources.getString(keyArr[keyArr.length-1]).split(",");
        for(String s:layoutArgs){
            System.out.println(s);
        }
        if(layoutArgs.length==4){
            myPane.add(element,Integer.valueOf(layoutArgs[0]),Integer.valueOf(layoutArgs[1]),Integer.valueOf(layoutArgs[2]),Integer.valueOf(layoutArgs[3]));
        }else if(layoutArgs.length==2){
            myPane.add(element,Integer.valueOf(layoutArgs[0]),Integer.valueOf(layoutArgs[1]));
        }
    }

}
