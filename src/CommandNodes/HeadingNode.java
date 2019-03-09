package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class HeadingNode extends CommandNode{

    public static final int NUM_PARAMS = 0;

    public HeadingNode(CommandHandlerInterface inHandler) {
        super(inHandler);
        setMyNumParams(NUM_PARAMS);
    }

    public HeadingNode(CommandHandlerInterface inHandler, CommandNode inParent) {
        super(inHandler, inParent);
        setMyNumParams(NUM_PARAMS);
    }

    @Override
    public void execute() {
        this.setMyReturnValue(myHandler.getHeading());
    }

    @Override
    protected void parseParameters() {

    }
}
