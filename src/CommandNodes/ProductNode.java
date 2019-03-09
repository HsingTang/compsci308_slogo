package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class ProductNode extends CommandNode {

    public static final int NUM_PARAMS = 2;
    private double[] myValues;

    public ProductNode(CommandHandlerInterface inHandler) {
        super(inHandler);
        this.setMyNumParams(NUM_PARAMS);
    }

    public ProductNode(CommandHandlerInterface inHandler, CommandNode inParent) {
        super(inHandler, inParent);
        this.setMyNumParams(NUM_PARAMS);
    }

    @Override
    public void execute() {
        parseParameters();
        double result = 1;
        for(double x : myValues){
            result *= x;
        }
        this.setMyReturnValue(result);
        System.out.println(this.getMyReturnValue());
    }

    @Override
    protected void parseParameters() {
        myValues = new double[NUM_PARAMS];
        for(int i = 0; i < myValues.length; i++){
            myValues[i] = this.getNextDouble();
        }
    }
}
