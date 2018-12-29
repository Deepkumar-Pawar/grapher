/**
 * Class to represent a term
 */

import java.util.*;

public class Term {

    String termString;      //to store the term as a String

    int id;     //to identify a term

    boolean innerEqualized = false;     //whether the inner terms have been executed by an operation

    ArrayList<Term> childTerms = new ArrayList<Term>();     //to store the inner terms

    ArrayList<Operation> operations = new ArrayList<Operation>();       //to store the related operations

    public  Term(int i)
    {
        id = i;
    }
}