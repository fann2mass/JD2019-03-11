package by.it.eslaikouskaya.calc;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTestMatrix {
	private static Parser parser;

	@BeforeClass
	public static void createParser() {
		parser = new Parser();
	}

	@Test
	public void simpleExpressionMatrix() throws Exception {
		Var var = parser.calc("{{2, 3},{2, 3}}+{{1, 2},{3, 4}}");
		String expected = "{{3.0, 5.0}, {5.0, 7.0}}";
		String actual = var.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void createVarMatrix() throws Exception {
		parser.calc("B={{2, 5, 8},{2, 5, 8}}");
		Var var = VarFactory.createVar("B");
		String expected = "{{2.0, 5.0, 8.0}, {2.0, 5.0, 8.0}}";
		String actual = var.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void createVarAndCalcMatrix() throws Exception {
		parser.calc("E={{2, 3, 4},{1, 2, 3}}+{{2, 3, 4},{1, 2, 3}}");
		Var var = VarFactory.createVar("E");
		String expected = "{{4.0, 6.0, 8.0}, {2.0, 4.0, 6.0}}";
		String actual = var.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void createVarAndCalcWithBrackets() throws Exception {
		parser.calc("R={{2,3},{1,2}}*(10/2)");
		Var var = VarFactory.createVar("R");
		String expected = "{{10.0, 15.0}, {5.0, 10.0}}";
		String actual = var.toString();
		assertEquals(expected, actual);
	}
}
