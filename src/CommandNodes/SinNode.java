package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class SinNode extends CommandNode{

    private static final int NUM_PARAMS = 1;
    private double myDegrees;

    public SinNode(CommandHandlerInterface inHandler) {
        super(inHandler);
        this.setMyNumParams(NUM_PARAMS);
    }

    public SinNode(CommandHandlerInterface inHandler, CommandNode inParent) {
        super(inHandler, inParent);
        this.setMyNumParams(NUM_PARAMS);
    }

    @Override
    public void execute() {
        parseParameters();
        this.setMyReturnValue(Math.sin(myDegrees));
    }

    @Override
    protected void parseParameters() {
        myDegrees = this.getNextDouble();
    }

}
