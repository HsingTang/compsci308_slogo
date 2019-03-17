package CommandNodes;

import Errors.InvalidCommandException;
import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * Command Node that calculates the remainder from dividing two given values.
 *
 * @author Duc Tran
 */
public class RemainderNode extends CommandNode {

    public static final int NUM_PARAMS = 2;
    private double[] myValues;

    public RemainderNode(CommandHandlerInterface inHandler) {
        super(inHandler);
        this.setMyNumParams(NUM_PARAMS);
    }

    public RemainderNode(CommandHandlerInterface inHandler, CommandNode inParent) {
        super(inHandler, inParent);
        this.setMyNumParams(NUM_PARAMS);
    }

    /**
     * Calculates the remainder from dividing myValues[0] by myValues[1] and sets myReturnValue to the result. Throws an
     * error if myValues[1] is zero.
     *
     * @throws InvalidCommandException Throws an InvalidCommandException to avoid a division by zero error.
     */
    @Override
    public void execute() throws InvalidCommandException{
        parseParameters();
        if(myValues[1]==0){
            throw new InvalidCommandException();
        }
        double result = myValues[0] % myValues[1];
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
