package by.it.eslaikouskaya.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    private ResourceManager manager = ResourceManager.INSTANCE;

    private static Map<String, Integer> mapPriority = new HashMap<String, Integer>() {
        {
            this.put("=", 0);
            this.put("+", 1);
            this.put("-", 1);
            this.put("*", 2);
            this.put("/", 2);
        }
    };

    private int getIndexOperation(List<String> operations) {
        int priorityValue = -1;
        int index = -1;
        for (int i = 0; i < operations.size(); i++) {
            String op = operations.get(i);
            int current = mapPriority.get(op);
            if (current > priorityValue) {
                priorityValue = current;
                index = i;
            }
        }
        return index;
    }

    private Var oneOperation(String strOne, String operation, String strTwo) throws CalcException {
        Var two = Var.createVar(strTwo);
        if (operation.equals("=")) {
            Var.saveVar(strOne, two);
            return two;
        }
        Var one = Var.createVar(strOne);
        if (one == null || two == null)
            throw new CalcException(manager.getString("message.noOperation"));
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
                throw new CalcException(manager.getString("message.noOperation"));
        }

    }

    Var calc(String expression) throws CalcException {
        //{2.0, 3.0}+7
        if (expression.contains(")") & expression.contains("(")) {
            return calcWithBracket(new StringBuilder(expression));
        } else {
            List<String> operations = new ArrayList<>();
            List<String> operands = new ArrayList<>(
                    Arrays.asList(expression.split(Patterns.OPERATION))
            );
            Pattern pattern = Pattern.compile(Patterns.OPERATION);
            Matcher matcher = pattern.matcher(expression);
            while (matcher.find())
                operations.add(matcher.group());


            while (operations.size() > 0) {
                int index = getIndexOperation(operations);
                String operation = operations.remove(index);
                String one = operands.remove(index);
                String two = operands.remove(index);
                Var oneOperationResult = oneOperation(one, operation, two);
                operands.add(index, oneOperationResult.toString());
            }
            return Var.createVar(operands.get(0));
        }

    }

    private Var calcWithBracket(StringBuilder expression) {
        String s = expression.toString();
        StringBuilder shortExpression = new StringBuilder();
        String operation = "";
        Pattern pattern = Pattern.compile(Patterns.BRACKETS);
        Matcher match = pattern.matcher(expression);
        if (match.find())
            shortExpression.append(match.group());
        int shortExpressionStarts = s.indexOf(shortExpression.toString());
        shortExpression.deleteCharAt(0).deleteCharAt(shortExpression.length() - 1);
        String[] oneAndTwo = shortExpression.toString().split(Patterns.OPERATION);
        String one = oneAndTwo[0];
        String two = oneAndTwo[1];
        Pattern pat = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = pat.matcher(shortExpression);
        while (matcher.find()) {
            operation = matcher.group();
        }
        Var oneOperationResult = null;
        try {
            oneOperationResult = oneOperation(one, operation, two);
        } catch (CalcException e) {
            e.printStackTrace();
        }
        expression.replace(shortExpressionStarts, shortExpressionStarts +
                shortExpression.length() + 2, oneOperationResult.toString());
        while (expression.toString().contains("(") & expression.toString().contains(")"))
            calcWithBracket(expression);
        Var calc = null;

        try {
            calc = calc(expression.toString());
        } catch (CalcException e) {
            e.printStackTrace();
        }
        return calc;
    }
}
