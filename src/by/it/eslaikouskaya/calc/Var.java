package by.it.eslaikouskaya.calc;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

	private static Map<String, Var> vars = new HashMap<>();
	static ResourceManager manager = ResourceManager.INSTANCE;
	public static Map<String, Var> getVars() {
		return vars;
	}

	static void saveVar(String name, Var var) {
		vars.put(name, var);
		save();
	}

	static Var createVar(String strVar) throws CalcException {
		strVar = strVar.trim().replace("\\s+", "");
		if (strVar.matches(Patterns.SCALAR))
			return new Scalar(strVar);
		else if (strVar.matches(Patterns.VECTOR))
			return new Vector(strVar);
		else if (strVar.matches(Patterns.MATRIX))
			return new Matrix(strVar);
		else if (vars.containsKey(strVar))
			return vars.get(strVar);
		throw new CalcException(manager.getString("message.create") + " " + strVar);
	}

	private static void save() {
		try (PrintWriter out = new PrintWriter(new FileWriter(getFileName()))) {
			for (Map.Entry<String, Var> pair : vars.entrySet()) {
				out.println(pair.getKey() + "=" + pair.getValue());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void load() throws CalcException {
		Parser p = new Parser();
		File file = new File(getFileName());
		if (file.exists()) {
			try (BufferedReader in = new BufferedReader(new FileReader(file))) {
				String line;
				while ((line = in.readLine()) != null) {
					p.calc(line);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static String getFileName() {
		String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
		String strPackage = Var.class.getPackage().getName();
		String relPath = strPackage.replace(".", File.separator);
		return src + relPath + File.separator + "vars.txt";
	}
	@Override
	public Var add(Var other) throws CalcException {
		throw new CalcException(manager.getString("message.sum") + " " + this + " + " + other + " " + manager.getString("message.impossible"));
	}

	@Override
	public Var sub(Var other) throws CalcException {
		throw new CalcException(manager.getString("message.sub") + " " + this + " + " + other + " " + manager.getString("message.impossible"));
	}

	@Override
	public Var mul(Var other) throws CalcException {
		throw new CalcException(manager.getString("message.mul") + " " + this + " + " + other + " " + manager.getString("message.impossible"));
	}

	@Override
	public Var div(Var other) throws CalcException {
		throw new CalcException(manager.getString("message.div") + " " + this + " + " + other + " " + manager.getString("message.impossible"));
	}

	@Override
	public String toString() {
		return manager.getString("message.class") + "Abstract Var";
	}
}
