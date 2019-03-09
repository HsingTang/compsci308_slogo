package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class IspendownNode extends CommandNode {

    public static final int NUM_PARAMS = 0;

    public IspendownNode(CommandHandlerInterface inHandler) {
        super(inHandler);
        setMyNumParams(NUM_PARAMS);
    }

    public IspendownNode(CommandHandlerInterface inHandler, CommandNode inParent) {
        super(inHandler, inParent);
        setMyNumParams(NUM_PARAMS);
    }

    @Override
    public void execute() {
        this.setMyReturnValue(myHandler.getPenState());
    }

    @Override
    protected void parseParameters() {

    }

}
