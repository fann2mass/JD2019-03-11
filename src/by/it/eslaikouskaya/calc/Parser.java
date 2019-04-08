package by.it.eslaikouskaya.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc(String expression) {
        expression=expression.replace(" ","");
        String[] operands = expression.split(Patterns.OPERATION);
        if (operands.length!=2)
            return null;
        Var two=Var.createVar(operands[1]);
        if (expression.contains("=")){
            return Var.saveVar(operands[0],two);
        }
        Var one=Var.createVar(operands[0]);
        if (one==null || two==null)
            return null;
        Pattern po= Pattern.compile(Patterns.OPERATION);
        Matcher mo=po.matcher(expression);
        if (mo.find()){
            String operation=mo.group();
            switch (operation){
                case "+": return one.add(two);
                case "-": return one.sub(two);
                case "*": return one.mul(two);
                case "/": return one.div(two);
            }
        }
        return null;
    }
}
