package by.it.narushevich.calc;

class Patterns {
    static final String OPERATION="[-+*/=]";
    static final String SCALAR="(-?)\\d+(\\.\\d+)?";
    static final String VECTOR="\\{(-?\\d+(\\.\\d+)?,\\s?)+-?\\d+(\\.\\d+)?\\}";
    static final String MATRIX="\\{(\\{(-?\\d+.\\d+,?\\s?)+},?\\s?)+}";
}
