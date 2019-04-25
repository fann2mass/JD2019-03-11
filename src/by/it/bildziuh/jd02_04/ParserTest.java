package by.it.bildziuh.jd02_04;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    private static Parser parser;

    @BeforeClass
    public static void creatParser() {
        parser = new Parser();
    }

    @Test
    public void simpleExpressionCalc() throws Exception {
        Var var = parser.calc("2+2*2");
        double expected = 6.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
    }

    @Test
    public void createScalarVarCalc() throws Exception {
        parser.calc("A=2+2*2");
        Var var = Var.createVar("A");
        double expected = 6.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
    }

 /*   @Test
    public void createVectorVarCalc() throws Exception {
        parser.calc("B={1,2}+2");
        Var var = Var.createVar("B");
        double [] expected = {3.0,4.0};
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
    }

    @Test
    public void createMatrixVarCalc() throws Exception {
        parser.calc("A=2+2*2");
        Var var = Var.createVar("A");
        double expected = 6.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
    }*/

}