/**
 * Class to convert an input expression into a set of operations which, when executed, yield an answer
 */

public class ConvertExpression {

    private static void processPlusMinus(Expression exp)
    {
        int prevTermBreakPointIndex = -1;   //used in the code logic to separate the terms

        for (int i = 0; i < exp.expString.length(); i++)
        {
            if ((exp.expString.charAt(i) == '+'))
            {
                Operation op = new Operation(0);

                exp.operations.add(op);

                //create a new operation

                Term t = new Term(exp.ids);
                exp.ids++;
                t.termString = exp.expString.substring(prevTermBreakPointIndex + 1, i);
                exp.terms.add(t);
                t.operations.add(op);

                //create a new term

                prevTermBreakPointIndex = i;
            }
            else if (exp.expString.charAt(i) == '-')
            {
                Operation op = new Operation(1);

                exp.operations.add(op);

                //create a new operation

                Term t = new Term(exp.ids);
                exp.ids++;
                t.termString = exp.expString.substring(prevTermBreakPointIndex + 1, i);
                exp.terms.add(t);
                t.operations.add(op);

                //create a new term

                prevTermBreakPointIndex = i;
            }

            if (i == (exp.expString.length() - 1))
            {
                Term t = new Term(exp.ids);
                exp.ids++;
                t.termString = exp.expString.substring(prevTermBreakPointIndex + 1, exp.expString.length());
                exp.terms.add(t);

                //creating a new term when we reach the last term
            }
        }
    }

    private static void init(Expression exp)
    {
        int a = 0;
        int b = 0;

        //variables used to differentiate between the two operations

        for (Operation op : exp.operations)
        {
            op.operands.clear();
        }

        for (int i = 0; i < exp.operations.size(); i++)
        {
            if ((exp.operations.get(i).operationId == 0) || (exp.operations.get(i).operationId == 1))
            {
                exp.operations.get(i).operands.add(0, exp.terms.get(a));
                exp.operations.get(i).operands.add(1, exp.terms.get(a + 1));

                a++;
            }
            if ((exp.operations.get(i).operationId == 2) || (exp.operations.get(i).operationId == 3))
            {
                exp.operations.get(i).operands.add(0, exp.innerTerms.get(b));
                exp.operations.get(i).operands.add(1, exp.innerTerms.get(b + 1));

                b++;
            }
        }
        //initializing the operands for each operation
    }

    private static void processMultiplyDivide(Expression exp)
    {
        for (Term t : exp.terms) {

            int prevTermBreakPointIndex = -1;

            for (int i = 0; i < t.termString.length(); i++)
            {
                if (t.termString.charAt(i) == '*')
                {
                    Operation op = new Operation(2);

                    exp.operations.add(op);

                    //create a new operation

                    Term _t = new Term(exp.ids);
                    exp.ids++;
                    _t.termString = t.termString.substring(prevTermBreakPointIndex + 1, i);
                    exp.innerTerms.add(_t);
                    _t.operations.add(op);

                    t.childTerms.add(_t);

                    //creating a new term within the existing term

                    prevTermBreakPointIndex = i;
                }
                else if (t.termString.charAt(i) == '/')
                {
                    Operation op = new Operation(3);

                    exp.operations.add(op);
                    //create a new operation

                    Term _t = new Term(exp.ids);
                    exp.ids++;
                    _t.termString = t.termString.substring(prevTermBreakPointIndex + 1, i);
                    exp.innerTerms.add(_t);
                    _t.operations.add(op);

                    t.childTerms.add(_t);
                    //creating a new term within the existing term

                    prevTermBreakPointIndex = i;
                }
                if ((i == (t.termString.length() - 1)) && (prevTermBreakPointIndex != -1))
                {
                    Term _t = new Term(exp.ids);
                    exp.ids++;
                    _t.termString = t.termString.substring(prevTermBreakPointIndex + 1, t.termString.length());
                    exp.innerTerms.add(_t);

                    t.childTerms.add(_t);
                    //creating a new term when we reach the last term
                }
            }
        }
    }

    public static void convert(Expression exp)
    {
        exp.terms.clear();
        exp.innerTerms.clear();
        exp.operations.clear();

        processPlusMinus(exp);
        processMultiplyDivide(exp);
        init(exp);

        //calling each method
    }
}
