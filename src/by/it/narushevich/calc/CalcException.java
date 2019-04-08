package by.it.narushevich.calc;

public class CalcException extends Exception {
    public CalcException(String s, Var var, Var other) {
        super("ERROR: ");
    }

    public CalcException(String message) {
        super("ERROR: "+ message);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR: " + message, cause);
    }

    public CalcException(Throwable cause) {
        super("ERROR: "+ cause);
    }
}
