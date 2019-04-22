package by.it.akhmelev.jd02_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    private static Map<String,Integer> mapPriority=new HashMap<String,Integer>(){
        {
            this.put("=",0);
            this.put("+",1);
            this.put("-",1);
            this.put("*",2);
            this.put("/",2);
        }
    };

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

    private Var oneOperation(String strOne, String operation, String strTwo) throws CalcException {
        Var two = Var.createVar(strTwo);
        if (operation.equals("=")) {
            Var.saveVar(strOne, two);
            return two;
        }
        Var one = Var.createVar(strOne);
        if (one == null || two == null)
            throw new CalcException("неизвестная операция");
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
