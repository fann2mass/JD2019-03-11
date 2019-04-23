package by.it.akhmelev.jd02_04;

class Patterns {

    private Patterns() {
    }

    static final String OPERATION="(?<=[^-+*=/,{])([-+*/=])";
    static final String SCALAR="-?\\d+(\\.\\d+)?";
    static final String VECTOR="\\{("+SCALAR+",?)+}";
    static final String MATRIX="\\{("+VECTOR+",?)+}";
}
