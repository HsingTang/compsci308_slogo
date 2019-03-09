package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class TangentNode extends TrigNode{

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
        double trigValue = Math.tan(Math.toRadians(myDegrees));
        setReturn(trigValue);
    }

    @Override
    protected void parseParameters() {
        myDegrees = this.getNextDouble();
    }
}
