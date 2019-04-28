package by.it.eslaikouskaya.calc;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class VarFactory {
	private static Map<String, Var> vars = new HashMap<>();
	private static ResourceManager manager = ResourceManager.INSTANCE;
	private static Singleton logger = Singleton.getInstance();

	public static Map<String, Var> getVars() {
		return vars;
	}


	private static String getFileName() {
		String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
		String strPackage = Var.class.getPackage().getName();
		String relPath = strPackage.replace(".", File.separator);
		return src + relPath + File.separator + "vars.txt";
	}

	static void saveVar(String name, Var var) {
		vars.put(name, var);
		save();
	}

	private static void save() {
		try (PrintWriter out1 = new PrintWriter(new FileWriter(getFileName()))) {
			for (Map.Entry<String, Var> pair : vars.entrySet()) {
				out1.println(pair.getKey() + "=" + pair.getValue());
			}
		} catch (IOException e1) {
			e1.printStackTrace();
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
		logger.log(manager.getString("message.create") + " " + strVar);
		throw new CalcException(manager.getString("message.create") + " " + strVar);
	}

}
