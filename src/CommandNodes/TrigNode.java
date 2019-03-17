package CommandNodes;

import Handlers.HandlerInterfaces.CommandHandlerInterface;

/**
 * Command Node that the trig commands extends. Contains methods that help format and set the result of the trig commands.
 *
 * @author Duc Tran
 */
public abstract class TrigNode extends CommandNode{

    public TrigNode(CommandHandlerInterface inHandler) {
        super(inHandler);
    }

    public TrigNode(CommandHandlerInterface inHandler, CommandNode inParent) {
        super(inHandler, inParent);
    }

    /**
     * Sets myReturnValue either to zero or to the result of the trig command rounded to the nearest hundredths.
     * @param trigValue
     */
    public void setReturn(double trigValue) {
        if (trigValue == 0.0){
            this.setMyReturnValue(trigValue);
        }else {
            var stringValue = Double.toString(Math.abs(trigValue));
            double roundedValue = (trigValue/Math.abs(trigValue)) * roundDecimal(stringValue);
            this.setMyReturnValue(roundedValue);
        }
    }

    private double roundDecimal(String value){
        if(value.length() <= 3){
            return Double.parseDouble(value);
        }else{
            double returnVal = Double.parseDouble(value.substring(0,4));
            double decider = Double.parseDouble(value.substring(4,5));
            if(decider < 5){
                return returnVal;
            }else{
                return returnVal + .01;
            }
        }
    }
}
