package by.it.akhmelev.calc_v6;

class Patterns {

    private Patterns() {
    }

    static final String OPERATION="(?<=[^-+*=/,{])([-+*/=])";
    static final String SCALAR="-?\\d+(\\.\\d+)?";
    static final String VECTOR="\\{("+SCALAR+",?)+}";
    static final String MATRIX="\\{("+VECTOR+",?)+}";
}
