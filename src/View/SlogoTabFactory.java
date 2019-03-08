package View;

import Controller.Controller;
import Errors.SlogoException;
import javafx.stage.Stage;


import java.util.HashMap;

public class SlogoTabFactory {
    private HashMap<Integer, IView> myViews;
    private int productCount;

    public SlogoTabFactory(){
        productCount = 0;
        myViews = new HashMap<>();
    }

    public SlogoTab getSlogoTab(int id, double w, double h, Controller controller, Stage stage, Window window) throws SlogoException {
        SlogoTab newViewProduct = new SlogoTab(id, w, h,controller, stage, window);
        myViews.put(productCount,newViewProduct);
        productCount++;
        return newViewProduct;
    }
}
