package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * Command Node that calculates the tangent of a given angle.
 *
 * @author Duc Tran
 */
public class TangentNode extends TrigNode{

    private static final int NUM_PARAMS = 1;
    private double myDegrees;

    public TangentNode(CommandHandlerInterface inHandler) {
        super(inHandler);
        this.setMyNumParams(NUM_PARAMS);
    }

    public TangentNode(CommandHandlerInterface inHandler, CommandNode inParent) {
        super(inHandler, inParent);
        this.setMyNumParams(NUM_PARAMS);
    }

    /**
     * Calculates the result the tangent of myDegrees ans sets myReturnValue to the result. The result is rounded to
     * the nearest hundredths.
     */
    @Override
    public void execute() {
        parseParameters();
        double trigValue = Math.tan(Math.toRadians(myDegrees));
        setReturn(trigValue);
    }

    @Override
    protected void parseParameters() {
        myDegrees = this.getNextDouble();
    }
}
