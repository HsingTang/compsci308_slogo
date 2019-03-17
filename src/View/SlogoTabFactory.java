package View;

import Controller.Controller;
import Errors.SlogoException;
import javafx.stage.Stage;

import java.util.HashMap;

/**
 * @author Hsingchih Tang
 * Factory class for producing new SlogoTabs on order of the Window
 * There should be one SlogoTabFactory for the whole program
 */
public class SlogoTabFactory {
    private HashMap<Integer, SlogoTab> myViews;
    private int productCount;

    /**
     * Instantiates a new SlogoTabFactory object and set up relevant fields
     */
    public SlogoTabFactory(){
        productCount = 0;
        myViews = new HashMap<>();
    }

    /**
     * Produces a new SlogoTab
     * @param id ID number of the new SlogoTab
     * @param w width of the Window
     * @param h height of the Window
     * @param controller Main Controller
     * @param stage Main stage
     * @param window Main Window (TabPane) holding all tabs
     * @return the newly created SlogoTab
     * @throws SlogoException on failure of creating the new tab
     */
    public SlogoTab getSlogoTab(int id, double w, double h, Controller controller, Stage stage, Window window) throws SlogoException {
        SlogoTab newViewProduct;
        try{
            newViewProduct = new SlogoTab(id, w, h,controller, stage, window);
            myViews.put(productCount,newViewProduct);
            productCount++;
            return newViewProduct;
        }catch (SlogoException e){
            throw e;
        }
    }
}
