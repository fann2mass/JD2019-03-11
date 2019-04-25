package by.it.bildziuh.calc;

public class Patterns {

    static final String OPERATION = "(?<=[^-+*=/,{])([-+*/=])";
    static final String SCALAR = "-?\\d+(\\.\\d+)?";
    static final String VECTOR = "\\{(" + SCALAR + ",?)+}";
    static final String MATRIX = "\\{(" + VECTOR + ",?)+}";
 /*   static final String printVar = "printvar";
    static final String sortVar = "sortvar";*/

}

