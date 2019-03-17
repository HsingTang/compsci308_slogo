package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * Command Node that calculates the Sine of a given angle.
 *
 * @author Duc Tran
 */
public class SineNode extends TrigNode{

    private static final int NUM_PARAMS = 1;
    private double myDegrees;

    public SineNode(CommandHandlerInterface inHandler) {
        super(inHandler);
        this.setMyNumParams(NUM_PARAMS);
    }

    public SineNode(CommandHandlerInterface inHandler, CommandNode inParent) {
        super(inHandler, inParent);
        this.setMyNumParams(NUM_PARAMS);
    }

    /**
     * Calculates the sine of myDegrees and sets myReturnValue to the result. The result is rounded to the nearest
     * hundredths.
     */
    @Override
    public void execute() {
        parseParameters();
        double trigValue = Math.sin(Math.toRadians(myDegrees));
        setReturn(trigValue);
    }

    @Override
    protected void parseParameters() {
        myDegrees = this.getNextDouble();
    }

}
