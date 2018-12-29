/**
 * Class to call the methods necessary to evaluate the input expression all from one place
 */

public class EvaluateExpression {

    public static double precision = 0.1;
    public static int numberOfCoordinates = 150;

    //variables to define the number of coordinates to be rendered

    public static void evaluate(Expression exp)
    {
        exp.expString = exp.expString.replace(" ", "");

        //removing all the whitespaces

        calculateMathematicalCoordinates(exp);
        createPixelCoordinates(exp);
    }

    public static void calculateMathematicalCoordinates(Expression exp)
    {
        for (int i = 0; i < numberOfCoordinates; i++)
        {
            double x = numberOfCoordinates / 2 * (-1) * precision + precision * i;

            ConvertExpression.convert(exp);
            exp.mathematicalCoordinates.add(new Coordinate(x, ExecuteExpression.executeExp(exp, x)));

            //creating new mathematical coordinates at a defined precision
        }
    }

    public static void createPixelCoordinates(Expression exp)
    {
        for (Coordinate c : exp.mathematicalCoordinates)
        {
            exp.pixelCoordinates.add(DisplayTransformations.transformMathematicalToPixelCoordinates(c));

            //mapping mathematical coordinates onto the screen
        }
    }
}
