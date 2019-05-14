package by.it.khlystunova.jd02_06.calc02_06;


public abstract class Var implements Operation {

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(ResourceManager.INSTANCE.getString(Msg.MESSAGES_ADD)+
                " "+ this + " + " + other +" "+ ResourceManager.INSTANCE.getString(Msg.MESSAGES_IMPOSSSIBLE));//this-в данном случае - это объект который вызывает метод.

    }
    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(ResourceManager.INSTANCE.getString(Msg.MESSAGES_SUB)
                +" " + this + " - " + other +" "+ ResourceManager.INSTANCE.getString(Msg.MESSAGES_IMPOSSSIBLE));

    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(ResourceManager.INSTANCE.getString(Msg.MESSAGES_MUL)+
                " " + this + " * " + other + " "+ ResourceManager.INSTANCE.getString(Msg.MESSAGES_IMPOSSSIBLE));

    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(ResourceManager.INSTANCE.getString(Msg.MESSAGES_DIV) +
                " "+ this + " / " + other +" "+ ResourceManager.INSTANCE.getString(Msg.MESSAGES_IMPOSSSIBLE));

    }

    @Override
    public String toString() {
        return "abstract Var";
    }

}
