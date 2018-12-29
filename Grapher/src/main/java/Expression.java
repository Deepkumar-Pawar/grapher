/**
 * Class to represent an expression input by the user
 */

import java.util.ArrayList;

public class Expression {

    ArrayList<Term> terms = new ArrayList<Term>();
    ArrayList<Term> innerTerms = new ArrayList<Term>();

    //to store the terms and inner terms separated by operations

    ArrayList<Operation> operations = new ArrayList<Operation>();   //to store related operations

    int ids = 0;    //to identify each each term

    String expString;   //the input expression String

    ArrayList<Coordinate> mathematicalCoordinates = new ArrayList<Coordinate>();
    ArrayList<Coordinate> pixelCoordinates = new ArrayList<Coordinate>();

    //to store the coordinates used for rendering

    public  Expression(String inp)
    {
        expString = inp;
    }
}
