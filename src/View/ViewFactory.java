package View;

import java.util.HashMap;

public class ViewFactory {
    private HashMap<Integer, ViewInterface> myViews;
    private int productCount;

    public ViewFactory(){
        productCount = 0;
        myViews = new HashMap<>();
    }

    public SlogoTab getSlogoTab(int id, double w, double h){
        SlogoTab newViewProduct = new SlogoTab(id, w, h);
        myViews.put(productCount,newViewProduct);
        productCount++;
        return newViewProduct;
    }
}
