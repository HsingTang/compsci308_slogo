package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * Command Node that checks if the turtle's pen is down or up.
 *
 * @author Duc Tran
 */
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

    /**
     * Uses the myHandler to get the current state of the pen. If the pen is down the value 1 is set to myReturnValue
     * and 0 if the pen is up.
     */
    @Override
    public void execute() {
        this.setMyReturnValue(myHandler.getPenState());
    }

    @Override
    protected void parseParameters() {

    }

}
