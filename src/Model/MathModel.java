package Models;

public class MathModel {

    private double result;

    public void sum(double val1, double val2){
        result = val1 + val2;
    }

    public void difference(double val1, double val2){
        result = val1 - val2;
    }

    public void product(double val1, double val2){
        result = val1 * val2;
    }

    public void quotient(double val1, double val2){
        result = val1/val2;
    }

    public void remainder(double val1, double val2){
        result = val1 % val2;
    }

}
