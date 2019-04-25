package by.it.bildziuh.jd02_04;

public class Patterns {

    static final String OPERATION = "(?<=[^-+*=/,{])([-+*/=])";
    static final String SCALAR = "-?\\d+(\\.\\d+)?";
    static final String VECTOR = "\\{(" + SCALAR + ",?)+}";
    static final String MATRIX = "\\{(" + VECTOR + ",?)+}";
    static final String BRAKETS = "\\(.*\\).";

 /*   static final String printVar = "printvar";
    static final String sortVar = "sortvar";*/

}

