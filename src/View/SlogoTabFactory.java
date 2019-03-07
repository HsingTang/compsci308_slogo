package View;

import Controller.Controller;
import javafx.stage.Stage;


import java.util.HashMap;

public class SlogoTabFactory {
    private HashMap<Integer, IView> myViews;
    private int productCount;
    private SlogoTab newViewProduct;

    public SlogoTabFactory(){
        productCount = 0;
        myViews = new HashMap<>();
    }

    public SlogoTab getSlogoTab(int id, double w, double h, Controller controller, Stage stage, Window window){
        newViewProduct = new SlogoTab(id, w, h,controller, stage, window);
        myViews.put(productCount,newViewProduct);
        productCount++;
        return newViewProduct;
    }
}
