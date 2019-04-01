package by.it.khlystunova.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc(String expression) {
        String[] operands = expression.split(Patterns.OPERATION);
        if(operands.length!=2)return null;
        Var one = Var.createVar(operands[0]);
        Var two = Var.createVar(operands[1]);
        if(one == null || two == null)return null;
        //ищем в выражении действие
        Pattern pattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = pattern.matcher(expression);
        while(matcher.find()){
            String operation = matcher.group();
            switch (operation){
                case "+":return one.add(two);
                case "-":return one.sub(two);
                case "*":return one.mul(two);
                case "/":return one.div(two);
            }
        }
        return null;
    }
}
