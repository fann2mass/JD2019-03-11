package by.it.narushevich.jd02_04;

public class CalcException extends Exception {

    public static final String ERROR = "ERROR: ";

    public CalcException() {
    }

    public CalcException(String message) {
        super(ERROR + message);
    }

    public CalcException(String message, Throwable cause) {
        super(ERROR + message, cause);
    }

    public CalcException(Throwable cause) {
        super(ERROR + cause);
    }
}
