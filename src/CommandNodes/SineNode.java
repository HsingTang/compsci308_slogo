package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class SineNode extends CommandNode{

    private static final int NUM_PARAMS = 1;
    private double myDegrees;

    public SineNode(CommandHandlerInterface inHandler) {
        super(inHandler);
        this.setMyNumParams(NUM_PARAMS);
    }

    public SineNode(CommandHandlerInterface inHandler, CommandNode inParent) {
        super(inHandler, inParent);
        this.setMyNumParams(NUM_PARAMS);
    }

    @Override
    public void execute() {
        parseParameters();
        double radianValue = Math.toRadians(myDegrees);
        this.setMyReturnValue(Math.sin(radianValue));
        System.out.println("%" + this.getMyReturnValue());
    }

    @Override
    protected void parseParameters() {
        myDegrees = this.getNextDouble();
    }

}
