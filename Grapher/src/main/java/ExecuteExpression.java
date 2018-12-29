/**
 * Class to execute each stored operation and yield a definite value based on the input
 */

public class ExecuteExpression {

    public static double executeExp(Expression exp, double x)
    {
        double y = 0.0;

        for (int i = exp.operations.size() - 1; i >= 0; i--)
        {
            y = exp.operations.get(i).execute(x);
        }

        if (exp.operations.size() == 0)
        {
            y = x;
        }

        return y;

        //takes an x value and executes each stored operation sequentially to obtain a y value
    }
}
