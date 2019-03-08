package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

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
