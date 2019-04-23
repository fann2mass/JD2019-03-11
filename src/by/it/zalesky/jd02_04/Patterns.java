package by.it.zalesky.jd02_04;

public class Patterns {

    static final String OPERATION="(?<=[^-+*=/,{])([-+*/=])";
    static final String SCALAR="-?\\d+(\\.\\d+)?";
    static final String VECTOR="\\{("+SCALAR+",?)+}";
    static final String MATRIX="\\{("+VECTOR+",?)+}";

}
