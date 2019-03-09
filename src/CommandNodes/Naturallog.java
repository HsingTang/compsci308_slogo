package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class Naturallog extends CommandNode{

    private static final int NUM_PARAMS = 1;
    private double myExprs;

    public Naturallog(CommandHandlerInterface inHandler) {
        super(inHandler);
        this.setMyNumParams(NUM_PARAMS);
    }

    public Naturallog(CommandHandlerInterface inHandler, CommandNode inParent) {
        super(inHandler, inParent);
        this.setMyNumParams(NUM_PARAMS);
    }

    @Override
    public void execute() {
        this.setMyReturnValue(Math.log(myExprs));
    }

    @Override
    protected void parseParameters() {
        myExprs = this.getNextDouble();
    }
}
