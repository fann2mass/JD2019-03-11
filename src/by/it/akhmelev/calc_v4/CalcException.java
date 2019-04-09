package by.it.akhmelev.calc_v4;

class CalcException extends Exception{

    CalcException() {
        super();
    }

    CalcException(String message) {
        super("ERROR: "+message);
    }

    CalcException(String message, Throwable cause) {
        super("ERROR: "+message, cause);
    }

    CalcException(Throwable cause) {
        super(cause);
    }
}
