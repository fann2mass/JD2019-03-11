package by.it.eslaikouskaya.calc;

abstract class Var implements Operation {

	private static ResourceManager manager = ResourceManager.INSTANCE;
	private static Singleton logger = Singleton.getInstance();

	@Override
	public Var add(Var other) throws CalcException {
		logger.log(manager.getString("message.sum") + " " + this + " + " + other + " " + manager.getString("message.impossible"));
		throw new CalcException(manager.getString("message.sum") + " " + this + " + " + other + " " + manager.getString("message.impossible"));
	}

	@Override
	public Var sub(Var other) throws CalcException {
		logger.log(manager.getString("message.sub") + " " + this + " + " + other + " " + manager.getString("message.impossible"));
		throw new CalcException(manager.getString("message.sub") + " " + this + " + " + other + " " + manager.getString("message.impossible"));
	}

	@Override
	public Var mul(Var other) throws CalcException {
		logger.log(manager.getString("message.mul") + " " + this + " + " + other + " " + manager.getString("message.impossible"));
		throw new CalcException(manager.getString("message.mul") + " " + this + " + " + other + " " + manager.getString("message.impossible"));
	}

	@Override
	public Var div(Var other) throws CalcException {
		logger.log(manager.getString("message.div") + " " + this + " + " + other + " " + manager.getString("message.impossible"));
		throw new CalcException(manager.getString("message.div") + " " + this + " + " + other + " " + manager.getString("message.impossible"));
	}

	@Override
	public String toString() {
		logger.log(manager.getString("message.class") + "Abstract Var");
		return manager.getString("message.class") + "Abstract Var";
	}
}
