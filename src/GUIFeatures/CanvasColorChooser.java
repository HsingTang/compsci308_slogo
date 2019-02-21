package GUIFeatures;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Locale;

public class CanvasColorChooser extends ComboBox {

    private ResourceBundle colorsBundle = ResourceBundle.getBundle("colors/Colors");

    public CanvasColorChooser() {
        super();
        for (String s : colorsBundle.keySet()) {
            System.out.println(colorsBundle.getString(s));
        }
    }
}

