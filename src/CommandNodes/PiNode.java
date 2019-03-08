package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class PiNode extends CommandNode{

    private static final int NUM_PARAMS = 0;

    public PiNode(CommandHandlerInterface inHandler) {
        super(inHandler);
        this.setMyNumParams(NUM_PARAMS);

    }

    public PiNode(CommandHandlerInterface inHandler, CommandNode inParent) {
        super(inHandler, inParent);
        this.setMyNumParams(NUM_PARAMS);
    }

    @Override
    public void execute() {
        this.setMyReturnValue(Math.PI);
    }

    @Override
    protected void parseParameters() {

    }

}
