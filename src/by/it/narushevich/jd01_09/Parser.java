package by.it.narushevich.jd01_09;

import java.util.regex.Pattern;

class Parser {
    Var calc(String expr) {
        Pattern p = Pattern.compile(Patterns.OPERATION);
        String[] operands = expr.split(p.toString());
        return null;
    }
}
