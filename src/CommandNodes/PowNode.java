package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class PowNode extends CommandNode{

    private static final int NUM_PARAMS = 2;
    private double[] myExprs;

    public PowNode(CommandHandlerInterface inHandler) {
        super(inHandler);
        this.setMyNumParams(NUM_PARAMS);
    }

    public PowNode(CommandHandlerInterface inHandler, CommandNode inParent) {
        super(inHandler, inParent);
        this.setMyNumParams(NUM_PARAMS);
    }

    @Override
    public void execute() {
        parseParameters();
        this.setMyReturnValue(Math.pow(myExprs[0],myExprs[1]));
    }

    @Override
    protected void parseParameters() {
        myExprs = new double[NUM_PARAMS];
        for(int i = 0; i < myExprs.length; i++){
            myExprs[i] = this.getNextDouble();
        }
    }
}
