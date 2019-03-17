package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * Command Node that checks if the turtle is visible or not.
 *
 * @author Duc Tran
 */
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

    /**
     * Checks if the turtle is visible. If it is, myReturnValue is set to 1, and 0 if not.
     */
    @Override
    public void execute() {
        this.setMyReturnValue(myHandler.getTurtleState());
    }

    @Override
    protected void parseParameters() {

    }

}
