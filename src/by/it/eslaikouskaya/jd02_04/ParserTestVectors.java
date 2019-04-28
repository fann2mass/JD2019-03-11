package by.it.eslaikouskaya.jd02_04;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTestVectors {
	private static Parser parser;

	@BeforeClass
	public static void createParser() {
		parser = new Parser();
	}

	@Test
	public void simpleExpressionVector() throws Exception {
		Var var = parser.calc("{2, 3}+1");
		String expected = "{3.0, 4.0}";
		String actual = var.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void createVarVector() throws Exception {
		parser.calc("A={2, 5, 8}");
		Var var=Var.createVar("A");
		String expected = "{2.0, 5.0, 8.0}";
		String actual = var.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void createVarAndCalcVector() throws Exception {
		parser.calc("D={2, 5, 8}+2");
		Var var=Var.createVar("D");
		String expected = "{4.0, 7.0, 10.0}";
		String actual = var.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void createVarAndCalcWithBrackets() throws Exception {
		parser.calc("E={2,3}*(10/2)");
		Var var=Var.createVar("E");
		String expected = "{10.0, 15.0}";
		String actual = var.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void VectorWithVector() throws Exception {
		Var var = parser.calc("{2,3}+{3,4}");
		String expected = "{5.0, 7.0}";
		String actual = var.toString();
		assertEquals(expected, actual);
	}
}
