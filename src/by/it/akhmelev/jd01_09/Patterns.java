package by.it.akhmelev.jd01_09;

class Patterns {

    private Patterns() {
    }

    static final String OPERATION="[-+*/=]";
    static final String SCALAR="-?\\d+(\\.\\d+)?";
    static final String VECTOR="\\{("+SCALAR+",?)+}";
    static final String MATRIX="\\{("+VECTOR+",?)+}";
}
