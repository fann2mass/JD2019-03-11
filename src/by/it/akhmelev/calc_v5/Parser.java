package by.it.akhmelev.calc_v5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc(String expression) throws CalcException {
        expression = expression.replace(" ", "");
        String[] operands = expression.split(Patterns.OPERATION);
        if (operands.length != 2)
            throw new CalcException("Не указана операция");
        Pattern po = Pattern.compile(Patterns.OPERATION);
        Matcher mo = po.matcher(expression);
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
        //ok find op
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
                throw new CalcException("неизвестная операция");
        }
    }
}
