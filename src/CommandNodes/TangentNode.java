package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class TangentNode extends CommandNode{

    private static final int NUM_PARAMS = 1;
    private double myDegrees;

    public TangentNode(CommandHandlerInterface inHandler) {
        super(inHandler);
        this.setMyNumParams(NUM_PARAMS);
    }

    public TangentNode(CommandHandlerInterface inHandler, CommandNode inParent) {
        super(inHandler, inParent);
        this.setMyNumParams(NUM_PARAMS);
    }

    @Override
    public void execute() {
        parseParameters();
        double radianValue = Math.toRadians(myDegrees);
        this.setMyReturnValue(Math.tan(radianValue));
    }

    @Override
    protected void parseParameters() {
        myDegrees = this.getNextDouble();
    }
}
