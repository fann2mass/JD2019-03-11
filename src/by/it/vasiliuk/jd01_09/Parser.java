package by.it.vasiliuk.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc(String expression) {
        expression = expression.replace(" ", "");
        String[] operands = expression.split(Patterns.OPERATION);
        if (operands.length != 2)
            return null;
        Pattern op = Pattern.compile(Patterns.OPERATION);
        Matcher mo = op.matcher(expression);
        Var two = Var.createVar(operands[1]);
        String operation = "";
        if (mo.find()) {
            operation = mo.group();
            if (operation.equals("=")) {
                Var.saveVar(operands[0],two);
                return two;
            }
        }
        Var one = Var.createVar(operands[0]);
        if (one == null || two == null)
            return null;
                switch (operation) {
            case "+":
                return one.add(two);
            case "-":
                return one.sub(two);
            case "*":
                return one.mul(two);
            case "/":
                return one.div(two);
            default:
                return null;
        }
    }
}
