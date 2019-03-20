package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * @author Mary Gooneratne
 * CommandNode that returns heading of turtle to command lime
 *
 */
public class HeadingNode extends CommandNode{

    public static final int NUM_PARAMS = 0;

    /**
     * Instantiates a HeadingNode
     * @param inHandler handler to execute commands
     */
    public HeadingNode(CommandHandlerInterface inHandler) {
        super(inHandler);
        setMyNumParams(NUM_PARAMS);
    }

    /**
     * Instantiates HeadingNode
     * @param inHandler handler to execute commands
     * @param inParent parent of node
     */
    public HeadingNode(CommandHandlerInterface inHandler, CommandNode inParent) {
        super(inHandler, inParent);
        setMyNumParams(NUM_PARAMS);
    }

    /**
     * Parses command parameters and calls appropriate execution method on handler
     */
    @Override
    public void execute() {
        this.setMyReturnValue(myHandler.getHeading());
    }

    @Override
    protected void parseParameters() {

    }
}
