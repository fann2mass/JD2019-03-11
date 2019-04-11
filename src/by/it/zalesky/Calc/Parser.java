package by.it.zalesky.Calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    Var calc (String expressions) throws CalcException{

        String[] operand = expressions.split(Patterns.operation);
        Var one = Var.createVar(operand[0]);
        Var two = Var.createVar(operand[1]);
        if (one == null || two == null)
            return null ; //create TODO error
        Pattern patt = Pattern.compile(Patterns.operation);
        Matcher matt = patt.matcher(expressions);
        if (matt.find()){
            String oper = matt.group();
            switch (oper) {

                case "+": return one.add(two);
                case "-": return one.sub(two);
                case "*": return one.mul(two);
                case "/": return one.div(two);


            }




        }

        return null;


    }


}
