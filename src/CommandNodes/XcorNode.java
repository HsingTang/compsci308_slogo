package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class XcorNode extends CommandNode {

    public static final int NUM_PARAMS = 0;
    private double myXcor;

    public XcorNode(CommandHandlerInterface inHandler) {
        super(inHandler);
        setMyNumParams(NUM_PARAMS);
    }

    public XcorNode(CommandHandlerInterface inHandler, CommandNode inParent) {
        super(inHandler, inParent);
        setMyNumParams(NUM_PARAMS);
    }

    @Override
    public void execute() {
        this.setMyReturnValue(myHandler.getXcor());
        System.out.println(this.getMyReturnValue());
    }

    @Override
    protected void parseParameters() {

    }
}
