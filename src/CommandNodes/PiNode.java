package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * Command Node that returns the value of Pi.
 *
 * @author Duc Tran
 */
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

    /**
     * Sets myReturnValue to the value of Pi.
     */
    @Override
    public void execute() {
        this.setMyReturnValue(Math.PI);
    }

    @Override
    protected void parseParameters() {

    }

}
