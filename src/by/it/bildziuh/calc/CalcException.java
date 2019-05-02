package by.it.bildziuh.calc;

class CalcException extends Exception {

    private static String ERRORCALCEXCEPTION = ConsoleRunner.manager.getString(Msg.ERRORCALCEXCEPTION);

    CalcException() {
    }

    CalcException(String message) {
        super(ERRORCALCEXCEPTION + message);
    }

    CalcException(String message, Throwable cause) {
        super(Msg.ERRORCALCEXCEPTION + message, cause);
    }

    CalcException(Throwable cause) {
        super(cause);
    }

    CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(ERRORCALCEXCEPTION + message, cause, enableSuppression, writableStackTrace);
    }
}
