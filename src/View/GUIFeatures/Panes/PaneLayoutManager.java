package View.GUIFeatures.Panes;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.util.ResourceBundle;

public class PaneLayoutManager {
    private final String ELEMENT_LAYOUT_RESOURCE = "elements/PaneElementLayout";
    private final Integer LAYOUT_COMPLEX_ARG_NUM = 4;
    private final Integer LAYOUT_SIMPLE_ARG_NUM = 2;
    private final Integer LAYOUT_COL_INDEX = 0;
    private final Integer LAYOUT_ROW_INDEX = 1;
    private final Integer LAYOUT_WIDTH_INDEX = 2;
    private final Integer LAYOUT_HEIGHT_INDEX = 3;
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
        String[] layoutArgs = myElementLayoutResources.getString(keyArr[keyArr.length-1]).split(",");
        if(layoutArgs.length==LAYOUT_COMPLEX_ARG_NUM){
            myPane.add(element,Integer.valueOf(layoutArgs[LAYOUT_COL_INDEX]),Integer.valueOf(layoutArgs[LAYOUT_ROW_INDEX]),Integer.valueOf(layoutArgs[LAYOUT_WIDTH_INDEX]),Integer.valueOf(layoutArgs[LAYOUT_HEIGHT_INDEX]));
        }else if(layoutArgs.length==LAYOUT_SIMPLE_ARG_NUM){
            myPane.add(element,Integer.valueOf(layoutArgs[LAYOUT_COL_INDEX]),Integer.valueOf(layoutArgs[LAYOUT_ROW_INDEX]));
        }
    }

}
