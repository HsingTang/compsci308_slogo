package CommandNodes;

import Errors.InvalidCommandException;
import Handlers.HandlerInterfaces.CommandHandlerInterface;

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

    @Override
    public void execute() throws InvalidCommandException{
        parseParameters();
        if(myValues[1]==0){
            throw new InvalidCommandException();
        }
        double result = myValues[0] / myValues[1]; //There will be a division by zero error here if myValues[1] is zero
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
