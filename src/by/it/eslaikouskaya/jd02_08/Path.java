package by.it.eslaikouskaya.jd02_08;

import by.it.eslaikouskaya.jd02_07.TaskC;

import java.io.File;

class Path {
	private Path() {
	}

	private static String getFileName(Class<?> cl, String name) {
		String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
		String strPackage = cl.getPackage().getName().replace(".", File.separator);
		return src + strPackage + File.separator + name;
	}

	static final String XML = getFileName(TaskC.class, "Boritorg.xml");
	static final String XSL = getFileName(SaxHandler.class, "rules.xsl");
	static final String HTML = getFileName(SaxHandler.class, "Boritorg.html");

}