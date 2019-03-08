package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class LogNode extends CommandNode{

    private static final int NUM_PARAMS = 1;
    private double myExprs;

    public LogNode(CommandHandlerInterface inHandler) {
        super(inHandler);
        this.setMyNumParams(NUM_PARAMS);
    }

    public LogNode(CommandHandlerInterface inHandler, CommandNode inParent) {
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
