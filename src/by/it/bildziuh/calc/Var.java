package by.it.bildziuh.calc;

abstract class Var implements Operation {

    private String UNABLETODO = Localization.manager.getString(Msg.UNABLETODO);
/*  private String UNABLETOSUM = Localization.manager.getString(Msg.UNABLETOSUM);
    private String UNABLETOSUB = Localization.manager.getString(Msg.UNABLETOSUB);
    private String UNABLETOMUL = Localization.manager.getString(Msg.UNABLETOMUL);
    private String UNABLETODIV = Localization.manager.getString(Msg.UNABLETODIV);*/


    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(UNABLETODO + this + " + " + other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(UNABLETODO + this + " - " + other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(UNABLETODO + this + " * " + other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(UNABLETODO + this + " / " + other);
    }

    @Override
    public String toString() {
        return Localization.manager.getString(Msg.VAR);
    }
}
