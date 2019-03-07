package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public abstract class MathCommand extends CommandNode {

    private double[] myValues;

    public MathCommand(CommandHandlerInterface inHandler){
        super(inHandler);
    }

    public MathCommand(CommandHandlerInterface inHandler, CommandNode inParent){
        super(inHandler, inParent);
    }

    public Double operate(BinaryOperator<Double> operand){
        double result = 0;
        for(var x : myValues){
            result = operand.apply(result, x);
        }
        return result;
    }

    public Double operate(UnaryOperator<Double> operand){
        return operand.apply(myValues[0]);
    }

}
