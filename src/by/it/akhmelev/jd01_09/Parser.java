package by.it.akhmelev.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc(String expression) {
        expression=expression.replace(" ","");
        String[] operands = expression.split(Patterns.OPERATION);
        if (operands.length!=2)
            return null;
        Var one=Var.createVar(operands[0]);
        Var two=Var.createVar(operands[1]);
        if (one==null || two==null)
            return null;
        //ok find op
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
