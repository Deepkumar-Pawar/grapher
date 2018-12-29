/**
 * Class to represent an operation
 */

import java.util.*;

public class Operation {

    int operationId;    //to distinguish between operations

    String resultString;    //to store the result of execution

    ArrayList<Term> operands = new ArrayList<Term>();   //to store the related operands

    public Operation(int i)
    {
        operationId = i;
    }

    public double execute(double x) {
        for (Term t : operands) {

            t.termString = t.termString.replace("x", Double.toString(x));   //replacing x with a value

            if((t.childTerms.size() != 0) && (!t.innerEqualized))
            {
                t.termString = t.childTerms.get(0).termString;
                t.innerEqualized = true;
            }   //resetting the value of the operation
        }
        switch (operationId) {
            case 0 :
                resultString = Double.toString(Double.parseDouble(operands.get(0).termString) + Double.parseDouble(operands.get(1).termString));
                break;
            case 1 :
                resultString = Double.toString(Double.parseDouble(operands.get(0).termString) - Double.parseDouble(operands.get(1).termString));
                break;
            case 2 :
                resultString = Double.toString(Double.parseDouble(operands.get(0).termString) * Double.parseDouble(operands.get(1).termString));
                break;
            case 3 :
                resultString = Double.toString(Double.parseDouble(operands.get(0).termString) / Double.parseDouble(operands.get(1).termString));
                break;
        }   //deciding the required operation
        for (Term t : operands) {
            t.termString = resultString;    //resetting each operand based on the result
        }
        return Double.parseDouble(resultString);
    }
}
