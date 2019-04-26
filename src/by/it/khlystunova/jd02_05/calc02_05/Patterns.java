package by.it.khlystunova.jd02_05.calc02_05;

class Patterns {

    private Patterns() {
    }


    static final String OPERATION="(?<=[^-+*/{,])[-+*/=]";
    static final String SCALAR="(-?)\\d+(\\.\\d+)?";
    static final String VECTOR="\\{(-?\\d+(\\.\\d+)?,\\s?)+-?\\d+(\\.\\d+)?\\}";
    static final String MATRIX="\\{\\{(-?\\d+(\\.\\d+)?,\\s?)+-?\\d+(\\.\\d+)?\\},\\s?\\{(-?\\d+(\\.\\d+)?,\\s?)+-?\\d+(\\.\\d+)?\\}\\}";
}
