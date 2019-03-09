package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class IsshowingNode extends CommandNode {

    public static final int NUM_PARAMS = 0;

    public IsshowingNode(CommandHandlerInterface inHandler) {
        super(inHandler);
        setMyNumParams(NUM_PARAMS);
    }

    public IsshowingNode(CommandHandlerInterface inHandler, CommandNode inParent) {
        super(inHandler, inParent);
        setMyNumParams(NUM_PARAMS);
    }

    @Override
    public void execute() {
        this.setMyReturnValue(myHandler.getXcor());
    }

    @Override
    protected void parseParameters() {

    }

}
