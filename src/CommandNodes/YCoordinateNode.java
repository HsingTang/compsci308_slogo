package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

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

    @Override
    public void execute() {
        this.setMyReturnValue(myHandler.getYcor());
    }

    @Override
    protected void parseParameters() {

    }

}
