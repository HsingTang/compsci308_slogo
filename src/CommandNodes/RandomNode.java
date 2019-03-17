package CommandNodes;

import Errors.InvalidCommandException;
import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * Command Node that calculates a random number from 0 to a given max value exclusive.
 *
 * @author Duc Tran
 */
public class RandomNode extends CommandNode {

    private static final int NUM_PARAMS = 1;
    private double myMax;

    public RandomNode(CommandHandlerInterface inHandler) {
        super(inHandler);
        this.setMyNumParams(NUM_PARAMS);
    }

    public RandomNode(CommandHandlerInterface inHandler, CommandNode inParent) {
        super(inHandler, inParent);
        this.setMyNumParams(NUM_PARAMS);
    }

    /**
     * Calculates a random number from 0 to myMax and sets myReturnValue to that result. Throws an InvalidCommandException
     * if myMax is less than 0.
     *
     * @throws InvalidCommandException Thrown if myMax is less than 0 since the Random command cannot return a value
     * less than 0.
     */
    @Override
    public void execute() throws InvalidCommandException{
        parseParameters();
        if(myMax < 0){
            throw new InvalidCommandException();
        }
        double result = myMax * Math.random();
        this.setMyReturnValue(result);
    }

    @Override
    protected void parseParameters() {
        myMax = this.getNextDouble();
    }
}
