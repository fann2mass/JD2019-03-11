package by.it.khlystunova.calc5;

public class CalcException extends  Exception {

    public CalcException() {
    }

    public CalcException(String message) {
        super("ERROR: "+ message);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR: "+ message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }

    protected CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("ERROR: "+message, cause, enableSuppression, writableStackTrace);
    }
}
