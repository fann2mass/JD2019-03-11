package by.it.bildziuh.calc;

public class Patterns {

    static final String OPERATION = "(?<=[^-+*=/,{])([-+*/=])";
    static final String SCALAR = "-?\\d+(\\.\\d+)?";
    static final String VECTOR = "\\{(" + SCALAR + ",\\s?)+" + SCALAR + "\\}";
    static final String MATRIX = "\\{" + VECTOR + ",\\s?" + VECTOR + "\\}";
 /*   static final String printVar = "printvar";
    static final String sortVar = "sortvar";*/

}

