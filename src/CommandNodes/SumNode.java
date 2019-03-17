package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * Command Node that calculates the sum of two given values.
 *
 * @author Duc Tran
 */
public class SumNode extends CommandNode{

    public static final int NUM_PARAMS = 2;
    private double[] myValues;

    public SumNode(CommandHandlerInterface inHandler) {
        super(inHandler);
        this.setMyNumParams(NUM_PARAMS);
    }

    public SumNode(CommandHandlerInterface inHandler, CommandNode inParent) {
        super(inHandler, inParent);
        this.setMyNumParams(NUM_PARAMS);
    }

    /**
     * Calculates the sum of myValues[0] and myValues[1] and sets myReturnValue to the result.
     */
    @Override
    public void execute() {
        parseParameters();
        double result = 0;
        for(double x : myValues){
            result += x;
        }
        setMyReturnValue(result);
    }

    @Override
    protected void parseParameters() {
        myValues = new double[NUM_PARAMS];
        for(int i = 0; i < myValues.length; i++){
            myValues[i] = this.getNextDouble();
        }
    }

}
