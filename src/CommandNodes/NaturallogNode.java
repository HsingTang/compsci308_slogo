package CommandNodes;

import Errors.InvalidCommandException;
import Handlers.HandlerInterfaces.CommandHandlerInterface;

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

    @Override
    public void execute() throws InvalidCommandException{
        if(myExprs<=0){
            throw new InvalidCommandException();
        }
        this.setMyReturnValue(Math.log(myExprs)); //Math.log will through an exception of myExprs is <= 0;
    }

    @Override
    protected void parseParameters() {
        myExprs = this.getNextDouble();
    }
}
