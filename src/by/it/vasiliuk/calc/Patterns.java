package by.it.vasiliuk.calc;

class Patterns {

    private Patterns() {
    }

    static final String OPERATION="[-+*/=]";
    static final String SCALAR="-?\\d+(\\.\\d+)?";
    static final String VECTOR="\\{("+SCALAR+",?)+}";
    static final String MATRIX="\\{("+VECTOR+",?)+}";
}