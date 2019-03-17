package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * Command Node that calculates the Cosine of an angle and then sets that value to the nodes return value.
 *
 * @author Duc Tran
 */
public class CosineNode extends TrigNode{

    private static final int NUM_PARAMS = 1;
    private double myDegrees;

    public CosineNode(CommandHandlerInterface inHandler) {
        super(inHandler);
        this.setMyNumParams(NUM_PARAMS);
    }

    public CosineNode(CommandHandlerInterface inHandler, CommandNode inParent) {
        super(inHandler, inParent);
        this.setMyNumParams(NUM_PARAMS);
    }

    /**
     * Calculates the cosine of myDegrees and sets myReturnValue to that result. The value is rounded to the nearest
     * hundredths.
     */
    @Override
    public void execute() {
        parseParameters();
        double trigValue = Math.cos(Math.toRadians(myDegrees));
        setReturn(trigValue);
    }

    @Override
    protected void parseParameters() {
        myDegrees = this.getNextDouble();
    }
}
