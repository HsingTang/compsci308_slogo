package CommandNodes;

import Errors.InvalidCommandException;
import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * Command Node that calculates quotient of two given values.
 *
 * @author Duc Tran
 */
public class QuotientNode extends CommandNode {

    public static final int NUM_PARAMS = 2;
    private double[] myValues;

    public QuotientNode(CommandHandlerInterface inHandler) {
        super(inHandler);
        this.setMyNumParams(NUM_PARAMS);
    }

    public QuotientNode(CommandHandlerInterface inHandler, CommandNode inParent) {
        super(inHandler, inParent);
        this.setMyNumParams(NUM_PARAMS);
    }

    /**
     * Calculates the result of myValues[0] divided by myValues[1] and sets myReturnValue to the result. Throws an
     * InvalidCommandException when myValues[1] equals 0.
     *
     * @throws InvalidCommandException Error thrown to avoid division by zero.
     */
    @Override
    public void execute() throws InvalidCommandException{
        parseParameters();
        if(myValues[1]==0){
            throw new InvalidCommandException();
        }
        double result = myValues[0] / myValues[1];
        setMyReturnValue(result);
    }

    @Override
    protected void parseParameters() {
        myValues = new double[NUM_PARAMS];
        for(int i = 0; i < myValues.length; i++){
            myValues[i] = this.getNextDouble();
        }
    }

}
