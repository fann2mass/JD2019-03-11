package by.it.bildziuh.calc;

class CalcException extends Exception {

    CalcException() {
    }

    CalcException(String message) {
        super(Localization.manager.getString(Msg.CALCEXCEPTION) + ": " + message);
    }

    CalcException(String message, Throwable cause) {
        super(Localization.manager.getString(Msg.CALCEXCEPTION) + ": " + message, cause);
    }

    CalcException(Throwable cause) {
        super(cause);
    }

    CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(Localization.manager.getString(Msg.CALCEXCEPTION) + ": " + message, cause, enableSuppression, writableStackTrace);
    }
}
