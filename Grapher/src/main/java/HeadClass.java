/**
 * Class to call all the other methods and contain main method
 */

public class HeadClass {

    public static Expression exp = new Expression("");  //to contain the current input expression

    public static void main(String args[])
    {
        ApplicationWindow.init();
    }

    public static void start(Expression exp)
    {
        EvaluateExpression.evaluate(exp);
    }
}
