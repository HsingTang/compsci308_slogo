package View;

import Controller.Controller;
import javafx.stage.Stage;

import java.util.HashMap;

public class SlogoTabFactory {
    private HashMap<Integer, ViewInterface> myViews;
    private int productCount;
    private SlogoTab newViewProduct;

    public SlogoTabFactory(){
        productCount = 0;
        myViews = new HashMap<>();
    }

    public SlogoTab getSlogoTab(int id, double w, double h, Controller controller, Stage myStage){
        newViewProduct = new SlogoTab(id, w, h,controller, myStage);
        myViews.put(productCount,newViewProduct);
        productCount++;
        return newViewProduct;
    }
}
