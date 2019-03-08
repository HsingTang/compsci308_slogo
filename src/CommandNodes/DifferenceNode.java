package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class DifferenceNode extends CommandNode {

    public static final int NUM_PARAMS = 2;
    private double[] myValues;

    public DifferenceNode(CommandHandlerInterface inHandler) {
        super(inHandler);
        this.setMyNumParams(NUM_PARAMS);
    }

    public DifferenceNode(CommandHandlerInterface inHandler, CommandNode inParent) {
        super(inHandler, inParent);
        this.setMyNumParams(NUM_PARAMS);
    }

    @Override
    public void execute() {
        parseParameters();
        double result = myValues[0] - myValues[1];
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
