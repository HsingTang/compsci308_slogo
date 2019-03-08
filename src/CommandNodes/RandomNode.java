package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class RandomNode extends CommandNode {

    private static final int NUM_PARAMS = 1;
    private double myMax;

    public RandomNode(CommandHandlerInterface inHandler) {
        super(inHandler);
        this.setMyNumParams(NUM_PARAMS);
    }

    public RandomNode(CommandHandlerInterface inHandler, CommandNode inParent) {
        super(inHandler, inParent);
        this.setMyNumParams(NUM_PARAMS);
    }

    @Override
    public void execute() {
        parseParameters();
        double result = myMax * Math.random();
        this.setMyReturnValue(result);
    }

    @Override
    protected void parseParameters() {
        myMax = this.getNextDouble();
    }
}
