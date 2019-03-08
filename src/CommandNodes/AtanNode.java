package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class AtanNode extends CommandNode{

    private static final int NUM_PARAMS = 1;
    private double myDegrees;

    public AtanNode(CommandHandlerInterface inHandler) {
        super(inHandler);
        this.setMyNumParams(NUM_PARAMS);
    }

    public AtanNode(CommandHandlerInterface inHandler, CommandNode inParent) {
        super(inHandler, inParent);
        this.setMyNumParams(NUM_PARAMS);
    }

    @Override
    public void execute() {
        parseParameters();
        this.setMyReturnValue(Math.atan(myDegrees));
    }

    @Override
    protected void parseParameters() {
        myDegrees = this.getNextDouble();
    }
}
