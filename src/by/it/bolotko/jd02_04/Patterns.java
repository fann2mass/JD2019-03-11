package by.it.bolotko.jd02_04;

class Patterns {
    static final String OPERATION="[-+*/=]";
    static final String SCALAR="(-?)\\d+(\\.\\d+)?";
    static final String VECTOR="\\{(-?\\d+(\\.\\d+)?,\\s?)+-?\\d+(\\.\\d+)?\\}";
    static final String MATRIX="\\{\\{(-?\\d+(\\.\\d+)?,\\s?)+-?\\d+(\\.\\d+)?\\},\\s?\\{(-?\\d+(\\.\\d+)?,\\s?)+-?\\d+(\\.\\d+)?\\}\\}";
}
