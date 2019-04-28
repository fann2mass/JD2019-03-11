package by.it.khlystunova.jd02_04;

import java.util.*;
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


    private static boolean isBracketsCorrect(String expression) {
        int openedBracket = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(')
                openedBracket++;
            else if (expression.charAt(i) == ')') {
                if (openedBracket == 0)
                    return false;
                openedBracket--;
            }
        }
        return openedBracket == 0;
    }

    Var calc(String expression) throws CalcException {
        Var result;
        expression = expression.replace(" ", "");
        if(expression.contains("(")) {
            if (!isBracketsCorrect(expression)) {
                throw new CalcException("Скобки расставлены неправильно!");
            }
            else {

                Pattern pattern = Pattern.compile(Patterns.ROUND_BRACKET);
                Matcher matcher = pattern.matcher(expression);
                while (matcher.find()) {
                    StringBuilder sb = new StringBuilder();
                    String group = matcher.group();
                    sb.append(group);
                    sb.deleteCharAt(0);
                    sb.deleteCharAt(sb.length() - 1);
                    Var simpleResult = calcWithoutBrackets(sb.toString());
                    expression = expression.replace(group, simpleResult.toString());
                    if (expression.contains("("))
                        matcher = pattern.matcher(expression);
                }
                result = calcWithoutBrackets(expression);
            }

        }else result = calcWithoutBrackets(expression);
        return result;
    }

    private Var calcWithoutBrackets(String expression) throws CalcException {
        expression = expression.replace(" ", "");
        List<String> operations=new ArrayList<>();
        List<String> operands= new ArrayList<>(
                Arrays.asList(expression.split(Patterns.OPERATION))
        );//сплитим по операциям и заносим опернанды в массив операций
        Pattern pattern=Pattern.compile(Patterns.OPERATION);
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find())
            operations.add(matcher.group());//заносим в массив операций найденую операцию.

        while (operations.size()>0) {
            int indexPriorityOperation = getIndexOperation(operations);
            String operation = operations.remove(indexPriorityOperation);
            String leftPart = operands.remove(indexPriorityOperation);
            String rightPart = operands.remove(indexPriorityOperation);
            Var oneOperationResult = oneOperation(leftPart, operation, rightPart);
            operands.add(indexPriorityOperation,oneOperationResult.toString());
        }
        return Var.createVar(operands.get(0));

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
        return index;//получили индекс самой приоритеной операции
    }

    private Var oneOperation(String strLeftPart, String operation, String strRightPart)
            throws CalcException {
        Var rightPart = Var.createVar(strRightPart);
        if (operation.equals("=")) {
            Var.saveVar(strLeftPart, rightPart);
            return rightPart;
        }
        Var leftPart = Var.createVar(strLeftPart);
        if (leftPart == null || rightPart == null)
            throw new CalcException("неизвестная операция");
        //ok find op
        switch (operation) {
            case "+":
                return leftPart.add(rightPart);
            case "-":
                return leftPart.sub(rightPart);
            case "*":
                return leftPart.mul(rightPart);
            case "/":
                return leftPart.div(rightPart);
            default:
                throw new CalcException("неизвестная операция");
        }

    }




}
