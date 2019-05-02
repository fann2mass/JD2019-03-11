package by.it.narushevich.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    private static Map<String, Integer> mapPriority = new HashMap<>();
    static {
        mapPriority.put("=", 0);
        mapPriority.put("+", 1);
        mapPriority.put("-", 1);
        mapPriority.put("*", 2);
        mapPriority.put("/", 2);
    }

    private int getIndexOperation(List<String> operations) {
        int priorityValue=-1;
        int index=-1;
        for (int i = 0; i < operations.size(); i++) {
            String op = operations.get(i);
            int current=mapPriority.get(op);
            if (current>priorityValue){
                priorityValue=current;
                index=i;
            }
        }
        return index;
    }

    private static Var oneOperation(String leftOperand, String operation, String rightOperand) throws CalcException {
        Var second = Var.createVar(rightOperand);
        if (operation.equals("=")) {
            Var.saveVar(leftOperand, second);
            return second;
        }
        Var first = Var.createVar(leftOperand);
        if (first == null || second == null)
            throw new CalcException("Операция невозможна, отсутствует операнд");
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


    Var calc(String expr) throws CalcException {
        List<String> operations=new ArrayList<>();
        List<String> operands= new ArrayList<>(
                Arrays.asList(expr.split(Patterns.OPERATION))
        );

        expr = expr.replaceAll("\\s+", "");
        Pattern pattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = pattern.matcher(expr);
            while (matcher.find())
                operations.add(matcher.group());
        while (!operations.isEmpty()) {
            int index = getIndexOperation(operations);
            String operation = operations.remove(index);
            String leftOperand = operands.remove(index);
            String rightOperand = operands.remove(index);
            Var oneOperationResult = oneOperation(leftOperand, operation, rightOperand);
            operands.add(index,oneOperationResult.toString());
        }
        return Var.createVar(operands.get(0));
    }
}
