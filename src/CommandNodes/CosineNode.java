package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class CosineNode extends TrigNode{

    private static final int NUM_PARAMS = 1;
    private double myDegrees;

    public CosineNode(CommandHandlerInterface inHandler) {
        super(inHandler);
        this.setMyNumParams(NUM_PARAMS);
    }

    public CosineNode(CommandHandlerInterface inHandler, CommandNode inParent) {
        super(inHandler, inParent);
        this.setMyNumParams(NUM_PARAMS);
    }

    @Override
    public void execute() {
        parseParameters();
        double trigValue = Math.cos(Math.toRadians(myDegrees));
        setReturn(trigValue);
    }

    @Override
    protected void parseParameters() {
        myDegrees = this.getNextDouble();
    }
}
