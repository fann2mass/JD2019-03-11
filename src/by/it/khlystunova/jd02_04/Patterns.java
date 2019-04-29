package by.it.khlystunova.jd02_04;

class Patterns {

    private Patterns() {
    }

    static final String ROUND_BRACKET = "[(]{1}[-\\w{},.+*/]{3,}[)]{1}";
    static final String OPERATION="(?<=[^-+*/{,])[-+*/=]";
    static final String SCALAR="(-?)\\d+(\\.\\d+)?";
    static final String VECTOR="\\{(-?\\d+(\\.\\d+)?,\\s?)+-?\\d+(\\.\\d+)?\\}";
    static final String MATRIX="\\{\\{(-?\\d+(\\.\\d+)?,\\s?)+-?\\d+(\\.\\d+)?\\},\\s?\\{(-?\\d+(\\.\\d+)?,\\s?)+-?\\d+(\\.\\d+)?\\}\\}";
}
