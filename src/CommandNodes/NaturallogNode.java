package CommandNodes;

import Errors.InvalidCommandException;
import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * Command Node that calculates the natural log of given value.
 *
 * @author Duc Tran
 */
public class NaturallogNode extends CommandNode{

    private static final int NUM_PARAMS = 1;
    private double myExprs;

    public NaturallogNode(CommandHandlerInterface inHandler) {
        super(inHandler);
        this.setMyNumParams(NUM_PARAMS);
    }

    public NaturallogNode(CommandHandlerInterface inHandler, CommandNode inParent) {
        super(inHandler, inParent);
        this.setMyNumParams(NUM_PARAMS);
    }

    /**
     * Calculates the natural log of myExprs and sets the result to myReturnValue. Throws an InvalidCommandException if
     * myExprs is less than or equal to zero.
     *
     * @throws InvalidCommandException This error is thrown when myExprs is less than or equal to 0 because natural log
     * is undefined for those values.
     */
    @Override
    public void execute() throws InvalidCommandException{
        if(myExprs<=0){
            throw new InvalidCommandException();
        }
        this.setMyReturnValue(Math.log(myExprs));
    }

    @Override
    protected void parseParameters() {
        myExprs = this.getNextDouble();
    }
}
