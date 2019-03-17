package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * Command Node that reports the Y-coor of the turtle.
 * @author Duc Tran
 */
public class YCoordinateNode extends CommandNode{

    public static final int NUM_PARAMS = 0;

    public YCoordinateNode(CommandHandlerInterface inHandler) {
        super(inHandler);
        setMyNumParams(NUM_PARAMS);
    }

    public YCoordinateNode(CommandHandlerInterface inHandler, CommandNode inParent) {
        super(inHandler, inParent);
        setMyNumParams(NUM_PARAMS);
    }

    /**
     * Sets myReturnValue to the Y-coor of the turtle.
     */
    @Override
    public void execute() {
        this.setMyReturnValue(myHandler.getYcor());
    }

    @Override
    protected void parseParameters() {

    }

}
