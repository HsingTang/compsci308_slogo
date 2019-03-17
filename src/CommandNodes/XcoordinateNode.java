package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * Command Node that reports the X-coor of the turtle.
 * @author Duc Tran
 */
public class XcoordinateNode extends CommandNode {

    public static final int NUM_PARAMS = 0;

    public XcoordinateNode(CommandHandlerInterface inHandler) {
        super(inHandler);
        setMyNumParams(NUM_PARAMS);
    }

    public XcoordinateNode(CommandHandlerInterface inHandler, CommandNode inParent) {
        super(inHandler, inParent);
        setMyNumParams(NUM_PARAMS);
    }

    /**
     * Sets myReturnValue to the X-coor of the turtle.
     */
    @Override
    public void execute() {
        this.setMyReturnValue(myHandler.getXcor());
    }

    @Override
    protected void parseParameters() {

    }

}
