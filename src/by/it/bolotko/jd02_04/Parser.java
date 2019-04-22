package by.it.bolotko.jd02_04;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc(String expression) throws Exception{
        expression = expression.trim().replaceAll("\\s+", "");
        String[] operand = expression.split(Patterns.OPERATION);
        if (operand.length != 2)
            throw new CalcException("Не указана операция");
        Pattern po = Pattern.compile(Patterns.OPERATION);
        Matcher mo = po.matcher(expression);
        Var two = Var.createVar(operand[1]);
        String operation = "";
        if (mo.find()) {
            operation = mo.group();
            if (operation.equals("=")) {
                Var.saveVar(operand[0],two);
                return two;
            }
        }
        Var one = Var.createVar(operand[0]);
        if (one == null || two == null)
            return null; //todo create error
        Pattern p = Pattern.compile(Patterns.OPERATION);
        Matcher m = p.matcher(expression);
        if (m.find()) {
            switch (operation) {
                case "+":
                    return one.add(two);
                case "-":
                    return one.sub(two);
                case "*":
                    return one.mul(two);
                case "/":
                    return one.div(two);
            }
        }
        return null;
    }
}
