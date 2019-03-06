package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

public class SumNode extends CommandNode {

    public static final int SUM_PARAMS = 2;

    private double[] myValues;

    public SumNode(CommandHandlerInterface inHandler){
        super(inHandler);
        this.setMyNumParams(SUM_PARAMS);
    }

    public SumNode(CommandHandlerInterface inHandler, CommandNode inParent){
        super(inHandler, inParent);
        this.setMyNumParams(SUM_PARAMS);
    }

    @Override
    public void execute() {
        this.parseParameters();
        double sum = 0;
        for(double x : myValues){
            sum += x;
        }
        this.setMyReturnValue(sum);
        System.out.println(sum);
    }

    @Override
    protected void parseParameters() {
        myValues = new double[SUM_PARAMS];
        for (int i = 0; i < SUM_PARAMS; i++){
            myValues[i] = this.getNextDouble();
        }
    }
}
