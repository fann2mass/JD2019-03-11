package by.it.narushevich.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc(String expr) throws CalcException {
        expr = expr.replaceAll("\\s+", "");
        String[] operands = expr.split(Patterns.OPERATION);
        if (operands.length != 2)
            throw new CalcException("Неверно введено выражение");

        Pattern p = Pattern.compile(Patterns.OPERATION);
        Matcher m = p.matcher(expr);
        Var second = Var.createVar(operands[1]);
        String operation = "";
        if (m.find()) {
            operation = m.group();
            if (operation.equals("=")) {
                Var.saveVar(operands[0],second);
                return second;
            }
        }
        Var first = Var.createVar(operands[0]);
        if (first == null || second == null)
            throw new CalcException("Операция невозможна");
        switch (operation) {
            case "+":
                return first.add(second);
            case "-":
                return first.sub(second);
            case "*":
                return first.mul(second);
            case "/":
                return first.div(second);
            default:
                throw new CalcException("Нет такой операции");
        }
    }
}
