package by.it.khlystunova.calc;

public class CalcException extends  Exception {
    CalcException() {
        super("ERROR: ");
    }

    CalcException(String message) {
        super("ERROR: "+ message);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR: "+ message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }
}
