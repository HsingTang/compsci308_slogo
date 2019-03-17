package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * Command Node that negates a given value.
 *
 * @author Duc Tran
 */
public class MinusClass extends CommandNode {

    private static final int NUM_PARAMS = 1;
    private double myExpr;

    public MinusClass(CommandHandlerInterface inHandler) {
        super(inHandler);
        this.setMyNumParams(NUM_PARAMS);
    }

    public MinusClass(CommandHandlerInterface inHandler, CommandNode inParent) {
        super(inHandler, inParent);
        this.setMyNumParams(NUM_PARAMS);
    }

    /**
     * Negates myExpr and sets myReturnValue to that result.
     */
    @Override
    public void execute() {
        parseParameters();
        setMyReturnValue(-myExpr);
    }

    @Override
    protected void parseParameters() {
        myExpr = this.getNextDouble();
    }
}
