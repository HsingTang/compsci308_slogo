package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class TanNode extends CommandNode{

    private static final int NUM_PARAMS = 1;
    private double myDegrees;

    public TanNode(CommandHandlerInterface inHandler) {
        super(inHandler);
        this.setMyNumParams(NUM_PARAMS);
    }

    public TanNode(CommandHandlerInterface inHandler, CommandNode inParent) {
        super(inHandler, inParent);
        this.setMyNumParams(NUM_PARAMS);
    }

    @Override
    public void execute() {
        parseParameters();
        this.setMyReturnValue(Math.tan(myDegrees));
    }

    @Override
    protected void parseParameters() {
        myDegrees = this.getNextDouble();
    }
}
