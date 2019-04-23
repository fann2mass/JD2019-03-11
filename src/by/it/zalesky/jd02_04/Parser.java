package by.it.zalesky.jd02_04;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static Map<String,Integer> mapPriority = new HashMap<String, Integer>() {
        {
            this.put("=", 0);
            this.put("+", 1);
            this.put("-", 1);
            this.put("*", 2);
            this.put("/", 2);


        }
    };

    private int getIndexOperation(List<String> operations){
        int priorotyValue = -1;
        int index = -1;
        for (int i = 0; i < operations.size(); i++) {
            String op = operations.get(i);
            int current = mapPriority.get(op);
            if (current>priorotyValue){
                priorotyValue = current;
                index = i;
            }
        }

        return index;
    }

    private Var oneOperation(String strLeft, String operation, String strRight) throws CalcException {
        Var right = Var.createVar(strRight);
        if (operation.equals("=")) {
            Var.saveVar(strLeft, right);
            return right;
        }

        Var left = Var.createVar(strLeft);
        if (left == null || right == null)
            throw new CalcException("неизвестная операция");

        switch (operation){
            case "+":
                return right.add(left);
            case "-":
                return right.add(left);
            case "*":
                return right.add(left);
            case "/":
                return right.add(left);
            default:
                throw new CalcException("неизвестная операция");
        }

    }


        Var calc(String expression) throws CalcException {
            //A=-2+2*2-3/-4
            List<String> operations=new ArrayList<>();
            List<String> operands= new ArrayList<>(
                    Arrays.asList(expression.split(Patterns.OPERATION))
            );
            Pattern pattern=Pattern.compile(Patterns.OPERATION);
            Matcher matcher = pattern.matcher(expression);
            while (matcher.find())
                operations.add(matcher.group());


            while (operations.size()>0) {
                int index = getIndexOperation(operations);
                String operation = operations.remove(index);
                String one = operands.remove(index);
                String two = operands.remove(index);
                Var oneOperationResult = oneOperation(one, operation, two);
                operands.add(index,oneOperationResult.toString());
            }
            return Var.createVar(operands.get(0));
        }


    }



