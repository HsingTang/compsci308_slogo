package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * Command Node that calculates the Atan of a value and sets that to its return value.
 *
 * @author Duc Tran
 */
public class ArctangentNode extends CommandNode{

    private static final int NUM_PARAMS = 1;
    private double myValue;

    /**
     * Constructor that calls the super constructor and then sets the number of parameters to NUM_PARAMS. All
     * command nodes follow this constructor format.
     *
     * @param inHandler The handler that handles transfers the results of the node to the front end.
     */
    public ArctangentNode(CommandHandlerInterface inHandler) {
        super(inHandler);
        this.setMyNumParams(NUM_PARAMS);
    }

    /**
     * Constructor that calls the super constructor and then sets the number of parameters to NUM_PARAMS. All
     * command nodes follow this constructor format.
     *
     * @param inHandler The handler that handles transfers the results of the node to the front end.
     * @param inParent The parent node of this command node.
     */
    public ArctangentNode(CommandHandlerInterface inHandler, CommandNode inParent) {
        super(inHandler, inParent);
        this.setMyNumParams(NUM_PARAMS);
    }

    /**
     * Calculates the Atan of myValue (which is the value the user inputted) and then sets myReturnValue to it.
     */
    @Override
    public void execute() {
        parseParameters();
        this.setMyReturnValue(Math.atan(myValue));
    }

    @Override
    protected void parseParameters() {
        myValue = this.getNextDouble();
    }
}
